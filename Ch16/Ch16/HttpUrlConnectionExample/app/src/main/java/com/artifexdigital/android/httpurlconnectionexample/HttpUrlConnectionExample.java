package com.artifexdigital.android.httpurlconnectionexample;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUrlConnectionExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url_connection_example);

        //invoke an asyncTask based object to do work off main UI thread
        new InternetOperation().execute("");
    }

    private String fetchUrl(String url) {
        String urlContent = "";
        StringBuilder myStrBuff = new StringBuilder();

        try{
            URL myUrl = new URL(url);
            HttpURLConnection myConn = (HttpURLConnection)myUrl.openConnection();
            myConn.setRequestProperty("User-Agent", "");
            myConn.setRequestMethod("GET");
            myConn.setDoInput(true);
            myConn.connect();

            InputStream myInStrm = myConn.getInputStream();
            BufferedReader myBuffRdr = new BufferedReader
                    (new InputStreamReader(myInStrm));

            while ((urlContent = myBuffRdr.readLine()) != null) {
                myStrBuff.append(urlContent);
            }

        } catch (IOException e) {
            // do error handling here
            e.printStackTrace();
        }

        return myStrBuff.toString();
    }

    private class InternetOperation extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {}

        @Override
        protected String doInBackground(String... params) {
            String myJson = "";
            myJson = fetchUrl("http://api.openweathermap.org/data/2.5/weather?q=London,uk");
            return myJson;
        }

        @Override
        protected void onPostExecute(String result) {
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(getApplicationContext(), result, duration);
            toast.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}

package com.artifexdigital.android.rawfileexample;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class RawFileExample extends ListActivity {
    private TextView mySelection;
    ArrayList<String> colorItems=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_file_example);
        mySelection=(TextView)findViewById(R.id.mySelection);

        try {
            InputStream inStream=getResources().openRawResource(R.raw.colors);
            DocumentBuilder docBuild=DocumentBuilderFactory
                    .newInstance().newDocumentBuilder();
            Document myDoc=docBuild.parse(inStream, null);
            NodeList colors=myDoc.getElementsByTagName("color");
            for (int i=0;i<colors.getLength();i++) {
                colorItems.add(((Element)colors.item(i)).getAttribute("value"));
            }
            inStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        setListAdapter(new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, colorItems));
    }

    public void onListItemClick(ListView parent, View v, int position,
                                long id) {
        mySelection.setText(colorItems.get(position).toString());
    }

}

package com.artifexdigital.android.fragmentpreferencesexample;

        import android.preference.PreferenceActivity;
        import java.util.List;

public class ChangePreferences extends PreferenceActivity {
    @Override
    public void onBuildHeaders(List<Header> myPrefHeaders) {
        loadHeadersFromResource(R.xml.preference_headers, myPrefHeaders);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return DefaultPreferenceFragment.class.getName().equals(fragmentName);
    }
}

package com.artifexdigital.android.fragmentpreferencesexample;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class DefaultPreferenceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int myResource=getActivity().getResources().getIdentifier(
                           getArguments().getString("fragprefresource"),"xml",
                           getActivity().getPackageName());

        addPreferencesFromResource(myResource);
    }

}

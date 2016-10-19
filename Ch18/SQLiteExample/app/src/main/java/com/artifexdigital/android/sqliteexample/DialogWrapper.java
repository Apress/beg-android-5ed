package com.artifexdigital.android.sqliteexample;

import android.view.View;
import android.widget.EditText;

public class DialogWrapper {
        EditText modelField=null;
        View base=null;

    DialogWrapper(View base) {
        this.base=base;
    }

    public String getModel() {
            return(getModelField().getText().toString());
        }

    private EditText getModelField() {
        if (modelField==null) {
            modelField=(EditText)base.findViewById(R.id.model_name);
        }

        return(modelField);
    }

}

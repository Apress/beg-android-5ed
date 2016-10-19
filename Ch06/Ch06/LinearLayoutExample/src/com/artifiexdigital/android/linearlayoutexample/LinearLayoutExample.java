package com.artifiexdigital.android.linearlayoutexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class LinearLayoutExample extends Activity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup orientation;
    RadioGroup gravity;
	  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_example);
        
        orientation=(RadioGroup)findViewById(R.id.orientation);
        orientation.setOnCheckedChangeListener(this);
        gravity=(RadioGroup)findViewById(R.id.gravity);
        gravity.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.horizontal:
                orientation.setOrientation(LinearLayout.HORIZONTAL);
            break;
          
            case R.id.vertical:
                orientation.setOrientation(LinearLayout.VERTICAL);
            break;
          
            case R.id.left:
                gravity.setGravity(Gravity.LEFT);
            break;
          
            case R.id.center:
                gravity.setGravity(Gravity.CENTER_HORIZONTAL);
            break;
          
            case R.id.right:
                gravity.setGravity(Gravity.RIGHT);
            break;
        }
      }

}

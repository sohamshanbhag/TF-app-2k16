package org.techfest.techfest2k16;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by sunny on 10/12/16.
 */

public class HandleClick extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.single_row);
      //  findViewById(R.id.image1).setOnClickListener(mButton1_OnClickListener);
    }

    //On click listener for button1
    final View.OnClickListener mButton1_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            //Inform the user the button has been clicked
            Toast.makeText(getApplicationContext(), "Button1 clicked.", Toast.LENGTH_SHORT).show();
        }
    };
}
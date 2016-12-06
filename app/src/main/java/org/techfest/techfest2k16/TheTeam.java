package org.techfest.techfest2k16;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by sunny on 06/12/16.
 */

public class TheTeam extends Activity {

    String[] names;
    private int[] images;

    LinearLayout ll;
    LinearLayout ll1;
    LinearLayout ll2;
    LinearLayout rl;
    ImageView iv1;
    ImageView iv2;
    TextView t1;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        names = getResources().getStringArray(R.array.Lectures_text);
        images = getResources().getIntArray(R.array.contact_img);


        ll = new LinearLayout(this);
        ll1 = new LinearLayout(this);
        ll2 = new LinearLayout(this);
        iv1 = new ImageView(this);
        iv2 = new ImageView(this);
        t1 = new TextView(this);
        t2 = new TextView(this);
        rl = new LinearLayout(this);

        LinearLayout.LayoutParams dimesions = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rl.setLayoutParams(dimesions);

        rl.setOrientation(LinearLayout.VERTICAL);
        rl.setBackgroundResource(R.drawable.background2);



        //      rl.addView(ll);

//        rl.addView(ll1);

        rl.addView(addme1(0));
        setContentView(rl);

    }

    public ViewGroup addme2(int i1, int i2){
        LinearLayout.LayoutParams dimesions = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(dimesions);

        LinearLayout.LayoutParams dimesions1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        dimesions1.weight = 1;
        ll1.setLayoutParams(dimesions1);
        ll2.setLayoutParams(dimesions1);

        ll.setWeightSum(2); ll1.setWeightSum(2); ll2.setWeightSum(2);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        ll1.setOrientation(LinearLayout.VERTICAL);
        ll2.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams dimesions2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
        iv1.setLayoutParams(dimesions2);
        iv2.setLayoutParams(dimesions2);

        LinearLayout.LayoutParams dimesions3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dimesions3.gravity = Gravity.CENTER_HORIZONTAL;
        t1.setTextColor(getResources().getColor(R.color.white));
        t2.setTextColor(getResources().getColor(R.color.white));
        t1.setLayoutParams(dimesions3);
        t2.setLayoutParams(dimesions3);


        t1.setText(names[i1]);
        t2.setText(names[i2]);
        iv1.setImageResource(R.drawable.rakesh);
        iv2.setImageResource(R.drawable.sharmila);

        ll1.addView(iv1);
        ll2.addView(iv2);
        ll1.addView(t1);
        ll2.addView(t2);
        ll.addView(ll1);
        ll.addView(ll2);

        return ll;
    }

    public View addme1(int i1){
        LinearLayout.LayoutParams dimesions = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(dimesions);

        LinearLayout.LayoutParams dimesions1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        dimesions1.weight = 1;
        dimesions1.gravity = Gravity.CENTER_HORIZONTAL;
        ll1.setLayoutParams(dimesions1);

        //   ll.setWeightSum(2); ll1.setWeightSum(2);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        ll1.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams dimesions2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
        iv1.setLayoutParams(dimesions2);

        LinearLayout.LayoutParams dimesions3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dimesions3.gravity = Gravity.CENTER_HORIZONTAL;
        t1.setTextColor(getResources().getColor(R.color.white));
        t1.setLayoutParams(dimesions3);


        t1.setText(names[i1]);
        iv1.setImageResource(R.drawable.rakesh);

        ll1.addView(iv1);
        ll1.addView(t1);
        ll.addView(ll1);

        return ll;
    }
}

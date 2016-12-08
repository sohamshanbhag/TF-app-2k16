package org.techfest.techfest2k16;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sunny on 04/12/16.
 */

public class CustomAdapter extends ArrayAdapter<Container> {

    ArrayList<Container> data = new ArrayList<>();

    public CustomAdapter(Context context, int textViewResourceId, ArrayList<Container> objects) {
        super(context, textViewResourceId, objects);
        data = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (position == 0){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.single_row1, null);
            return v;
        }

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.single_row, null);
        TextView title = (TextView) v.findViewById(R.id.title);
        LinearLayout ll1 = (LinearLayout) v.findViewById(R.id.ll1) ;
        TextView subtitle1 = (TextView) v.findViewById(R.id.subtitle1);
        TextView subtitle2 = (TextView) v.findViewById(R.id.subtitle2);
        ImageView image1 = (ImageView) v.findViewById(R.id.image1);
        ImageView image2 = (ImageView) v.findViewById(R.id.image2);
        title.setText(data.get(position).getTitle());
        subtitle1.setText(data.get(position).getSubtitle1());
        subtitle2.setText(data.get(position).getSubtitle2());
        image1.setImageResource(data.get(position).getImage1());
        image2.setImageResource(data.get(position).getImage2());
        return v;



    }

}

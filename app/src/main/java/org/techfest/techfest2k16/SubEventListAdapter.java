package org.techfest.techfest2k16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by soham_shanbhag on 4/12/16.
 */

public class SubEventListAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] mThumbs;
    private String[] mName;

    public SubEventListAdapter(Context context, Integer[] thumb, String[] name){
        mContext = context;
        mThumbs = thumb;
        mName = name;
    }

    @Override
    public int getCount() {
        return mThumbs.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.grid_sub_event, parent, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.subEventImage);
        TextView textView = (TextView) convertView.findViewById(R.id.subEventText);

        // if it's not recycled, initialize some attributes
        imageView.setImageResource(mThumbs[position]);
        textView.setText(mName[position]);

        return convertView;
    }

}

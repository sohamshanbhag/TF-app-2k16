package org.techfest.techfest2k16;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by soham_shanbhag on 10/10/16.
 */

public class MainEventListAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] mThumbs;
    private String[] mName;
    
    public MainEventListAdapter(Context context, String name){
        mContext = context;
        Resources res = context.getResources();
        mName = res.getStringArray(res.getIdentifier(name + "_text", "array", "org.techfest.techfest2k16"));
        TypedArray ar = res.obtainTypedArray(res.getIdentifier(name + "_img", "array", "org.techfest.techfest2k16"));
        mThumbs = new Integer[ar.length()];
        for (int i = 0; i < ar.length(); i++)
            mThumbs[i] = ar.getResourceId(i, 0);
        ar.recycle();
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
        convertView = inflater.inflate(R.layout.grid_row_event, parent, false);
        TextView textView = (TextView) convertView.findViewById(R.id.title);
        final ImageView imageview = (ImageView) convertView.findViewById(R.id.eventSubEvent);

        // if it's not recycled, initialize some attributes
        textView.setText(mName[position]);
        imageview.setImageResource(mThumbs[position]);

        return convertView;
    }
}

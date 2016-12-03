package org.techfest.techfest2k16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by soham_shanbhag on 3/12/16.
 */

public class EventAdapterMain extends BaseAdapter {

	private Context mContext;
    private Integer[] mThumbs;
    private String[] mName;

    public EventAdapterMain(Context context, Integer[] thumb, String[] name){
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

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.grid_row_event, parent, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.gridRowEventImage);
        TextView textView = (TextView) convertView.findViewById(R.id.gridRowEventText);

        textView.setText(mName[position]);

        return convertView;
    }



}

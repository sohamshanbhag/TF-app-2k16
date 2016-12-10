package org.techfest.techfest2k16;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by soham_shanbhag on 10/10/16.
 */

public class MainEventListAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] mThumbs;
    private String[] mName;
    private String[] location;
    TextView tv;
    String section;
    
    public MainEventListAdapter(Context context, String name){
        section = name;
        mContext = context;
        Resources res = context.getResources();
        mName = res.getStringArray(res.getIdentifier(name + "_text", "array", "org.techfest.techfest2k16"));
        TypedArray ar = res.obtainTypedArray(res.getIdentifier(name + "_img", "array", "org.techfest.techfest2k16"));
        if(!name.equals("Initiatives")) {
            location = res.getStringArray(res.getIdentifier(name + "_location", "array", "org.techfest.techfest2k16"));
        }
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.grid_row_event, parent, false);
        convertView.findViewById(R.id.back).setVisibility(View.GONE);
        TextView textView = (TextView) convertView.findViewById(R.id.title);
        final ImageView imageview = (ImageView) convertView.findViewById(R.id.eventSubEvent);

        // if it's not recycled, initialize some attributes
        textView.setText(mName[position]);
        imageview.setImageResource(mThumbs[position]);

        ImageView iv = (ImageView) convertView.findViewById(R.id.venue);
        if (section.equals("Initiatives")){
            iv.setVisibility(View.GONE);
        }
        iv.setTag("");
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+location[position]));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });

        return convertView;
    }
}

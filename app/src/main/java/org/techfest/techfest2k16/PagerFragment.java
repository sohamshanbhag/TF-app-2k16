
package org.techfest.techfest2k16;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by soham_shanbhag on 10/10/16.
 */

public class PagerFragment extends Fragment {

    public static PagerFragment newInstance(String section) {
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putString("Section", section);
        fragment.setArguments(args);
        //Log.e("String", section);
        Competitions compi=new Competitions();
        return fragment;
    }

    String section;
    String[] listItemsValue;
    private LayoutInflater layoutInflater;
    private PopupWindow popupWindow;
    private View relativeLayout;
    double width;
    double height;
    ListView listview;
    TextView title; //single_row
    String titletext;
    TextView event; //pop_up
    TextView info; //pop_up
    ArrayList<Container> data;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail,container,false);
         //////////////////////////

        listview = (ListView) view.findViewById(R.id.eventMainList);
        relativeLayout = view.findViewById(R.id.relative);

        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        section = getArguments().getString("Section");
        if(section.equals("Competitions")){
            data=new ArrayList<>();
            data.add(new Container("Technorion","RESEMBLANCE","Generex",R.drawable.satellite,R.drawable.generex));
            data.add(new Container("International Challenge","IRC","Robowars",R.drawable.gt,R.drawable.robowars2));
            data.add(new Container("Xtreme Machines","Full Throttle","Submerge",R.drawable.ft,R.drawable.sm));
            data.add(new Container("Tinkerer","Energon","Imitaion Game",R.drawable.energon,R.drawable.da));
            data.add(new Container("Architectonics","Skyscrapper","Colonize",R.drawable.ss,R.drawable.coloniz));
            data.add(new Container("Aerostrike","SkyLark","Boeing ACz",R.drawable.quad,R.drawable.boeing));
            data.add(new Container("Spectechle","Reseblance","Generex",R.drawable.satellite,R.drawable.generex));

            view = inflater.inflate(R.layout.competitions, null);
            listview = (ListView) view.findViewById(R.id.list);
        }



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                title = (TextView) listview.findViewById(R.id.title);
                titletext = title.getText().toString();

                layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View container = layoutInflater.inflate(R.layout.pop_up,null);

                event = (TextView) container.findViewById(R.id.event);
                info = (TextView) container.findViewById(R.id.info);
                event.setText(titletext);
                info.setText("it will compensate. I might be wrong here, and I don't have a source. This is just what I've gathered \n\n Venue: 5pm \n Date: 18th Decem \n Time: 5pm");

                popupWindow = new PopupWindow(container,(int) (width*0.7),(int) (height*0.6),true);
                popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY,(int) (width*0.15),(int) (height*0.2));


                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                    }
                });
            }
        });


    return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        if(section.equals("Competitions")){
            listview.setAdapter(new CustomAdapter(getActivity().getApplicationContext(),R.layout.single_row ,data));
            setRetainInstance(true);
        }
        else {
            listview.setAdapter(new MainEventListAdapter(getActivity().getApplicationContext(), section));

        }
    }
}


package org.techfest.techfest2k16;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
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
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.VISIBLE;

/**
 * Created by soham_shanbhag on 10/10/16.
 */

public class PagerFragment extends Fragment {

    public static PagerFragment newInstance(String section) {
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putString("Section", section);
        fragment.setArguments(args);
        return fragment;
    }

    String section;
    String[] listItemsValue;
    String[] venues;
    String[] dates;
    String[] time;
    String[] content;
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
    View view_ini; //used in flip_store
    TextView pop_tv; //pop up text view
    TextView tv;

    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail,container,false);
         //////////////////////////

        listview = (ListView) view.findViewById(R.id.eventMainList);
        relativeLayout = view.findViewById(R.id.relative);

        tv = (TextView) view.findViewById(R.id.listname);

        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        section = getArguments().getString("Section");


       listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                ViewParent v = ((View) view).getParent().getParent();
                RelativeLayout r = (RelativeLayout) v;
                TextView tvq = (TextView) r.findViewById(R.id.listname);
                String s = tvq.getText().toString();


                if(view_ini == view){
                    if(view.findViewById(R.id.front).getVisibility() == VISIBLE){
                        flip(view.findViewById(R.id.front), view.findViewById(R.id.back), 400);
                    }
                    else {
                        flip(view_ini.findViewById(R.id.back), view_ini.findViewById(R.id.front), 400);
                    }
                }
                pop_tv = (TextView) view.findViewById(R.id.popup_text);
                if(s.equals("Initiatives")){
                    content = getResources().getStringArray(getResources().getIdentifier(s+"_content","array","org.techfest.techfest2k16"));
                    pop_tv.setText(content[position]);
                }
                else if(s.equals("Ozone")){
                    dates = getResources().getStringArray(getResources().getIdentifier(s+"_date","array","org.techfest.techfest2k16"));
                    time = getResources().getStringArray(getResources().getIdentifier(s+"_time","array","org.techfest.techfest2k16"));
                    venues = getResources().getStringArray(getResources().getIdentifier(s+"_venue","array","org.techfest.techfest2k16"));
                    pop_tv.setText("Venue: " + venues[position] + "\n Date: "+dates[position]+"\n Time: "+time[position]);
                }
                else {
                    content = getResources().getStringArray(getResources().getIdentifier(s+"_content","array","org.techfest.techfest2k16"));
                    dates = getResources().getStringArray(getResources().getIdentifier(s+"_date","array","org.techfest.techfest2k16"));
                    time = getResources().getStringArray(getResources().getIdentifier(s+"_time","array","org.techfest.techfest2k16"));
                    venues = getResources().getStringArray(getResources().getIdentifier(s+"_venue","array","org.techfest.techfest2k16"));
                    pop_tv.setText(content[position]+" \n\n\n\n Venue: " + venues[position] + "\n Date: "+dates[position]+"\n Time: "+time[position]+"");
                }



                if(view_ini != view) {
                    flip(view.findViewById(R.id.front), view.findViewById(R.id.back), 400);
                }
                if (view_ini != null && view_ini != view){
                    flip(view_ini.findViewById(R.id.back), view_ini.findViewById(R.id.front), 400);
                }

                view_ini = view;

         /*       title = (TextView) listview.findViewById(R.id.title);
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
                }); */
            }
        });


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

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    title = (TextView) listview.findViewById(R.id.title);
                    titletext = title.getText().toString();

                    layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View container = layoutInflater.inflate(R.layout.pop_up, null);

                    event = (TextView) container.findViewById(R.id.event);
                    info = (TextView) container.findViewById(R.id.info);
                    event.setText(titletext);
                    info.setText("it will compensate. I might be wrong here, and I don't have a source. This is just what I've gathered \n\n Venue: 5pm \n Date: 18th Decem \n Time: 5pm");

                    popupWindow = new PopupWindow(container, (int) (width * 0.7), (int) (height * 0.6), true);
                    popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, (int) (width * 0.15), (int) (height * 0.2));


                    container.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            return false;
                        }
                    });
                }
            });

        }


        /**   listview.setOnClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                   container.setOnTouchListener(new View.OnTouchListener() {
                       @Override
                       public boolean onTouch(View v, MotionEvent event) {
                           return false;
                       }
                   });
               }
           }); **/


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
            LinearLayout.LayoutParams dimesions3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dimesions3.gravity = Gravity.CENTER_HORIZONTAL;
            tv.setText(section);
//            listview.addView(tv);
        }
    }

    public void flip(final View front, final View back, final int duration)
    {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            AnimatorSet set = new AnimatorSet();
            set.playSequentially(
                    ObjectAnimator.ofFloat(front, "rotationY", 90).setDuration(duration / 2),
                    ObjectAnimator.ofInt(front, "visibility", View.GONE).setDuration(0),
                    ObjectAnimator.ofFloat(back, "rotationY", -90).setDuration(0),
                    ObjectAnimator.ofInt(back, "visibility", VISIBLE).setDuration(0),
                    ObjectAnimator.ofFloat(back, "rotationY", 0).setDuration(duration / 2));
            set.start();
        } else
        {
            front.animate().rotationY(90).setDuration(duration / 2)
                    .setListener(new AnimatorListenerAdapter()
                    {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            front.setVisibility(View.GONE);
                            back.setRotationY(-90);
                            back.setVisibility(VISIBLE);
                            back.animate().rotationY(0).setDuration(duration / 2).setListener(null);
                        }
                    });
        }
    }

}

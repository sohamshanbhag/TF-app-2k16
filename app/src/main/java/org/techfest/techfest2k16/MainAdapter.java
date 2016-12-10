package org.techfest.techfest2k16;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * Created by abhinav on 11/22/2016.
 */

public class MainAdapter extends PagerAdapter{

    public Context ctx;
    public LayoutInflater layoutInflater;
    int position1;
    private String[] title;
    String content[];
    ViewPager viewPager;
    Integer[] images = {R.drawable.initiatives1, R.drawable.ideate, R.drawable.front, R.drawable.workshop, R.drawable.lecture, R.drawable.exhi, R.drawable.techx, R.drawable.ozone3};


    public MainAdapter(Context ctx){
        this.ctx = ctx;
        title = ctx.getResources().getStringArray(R.array.event_titles);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        position1 = position;
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.grid_row_nav_events,container,false);
        View item_view1 = layoutInflater.inflate(R.layout.content_nav_drawer,container,false);
         viewPager = (ViewPager) item_view1.findViewById(R.id.event_grid);
        ImageView imageView = (ImageView)item_view.findViewById(R.id.gridRowEventImage);
        TextView heading = (TextView)item_view.findViewById(R.id.gridRowEventText);
        TextView discription = (TextView)item_view.findViewById(R.id.discription);

        imageView.setImageResource(images[position]);
        heading.setText(title[position]);
        content = ctx.getResources().getStringArray(R.array.Main_content);
        discription.setText(content[position]);


        container.addView(item_view);
        imageView.setTag(position);

        ImageView back = (ImageView) item_view.findViewById(R.id.back);
        ImageView next = (ImageView) item_view.findViewById(R.id.next);

    /*    back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(-1), true);
            //    Log.d("sfs","FS");
            }
        }); */

        if(position == 0){
            back.setVisibility(View.GONE);
        }
        else if(position == 7){
            next.setVisibility(View.GONE);
        }


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, EventDetail.class);
                intent.putExtra("position", (int) v.getTag());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });
        return item_view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }
}


package org.techfest.techfest2k16;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sunny on 04/12/16.
 */

public class Competitions extends ListFragment {
    ListView simpleList;
    ArrayList<Container> data=new ArrayList<>();
    ViewGroup v;

    public View onCreateView(LayoutInflater inflater, ViewGroup contain, Bundle savedInstanceState) {

        v = (ViewGroup) inflater.inflate(R.layout.competitions, null);

        simpleList = (ListView) v.findViewById(android.R.id.list);
        data.add(new Container("International Challenge","INTERNATIONAL ROBOTICS CHALLENGE","ROBOWARS",R.drawable.gt,R.drawable.robowars2));
        data.add(new Container("XTREME MACHINES","Full Throttle","Submerge",R.drawable.ft,R.drawable.sm));
        data.add(new Container("Tinkerer","Energon","Imitaion Game",R.drawable.energon,R.drawable.da));
        data.add(new Container("ARCHITECTONICS","Skyscrapper","Colonize",R.drawable.ss,R.drawable.coloniz));
        data.add(new Container("AEROSTRIKE","SkyLark","Boeing AEROMODELLING COMPETITION",R.drawable.quad,R.drawable.boeing));
        data.add(new Container("SPECTECHALE","RESEMBLANCE","Generex",R.drawable.satellite,R.drawable.generex));
        data.add(new Container("SPECTECHALE","RESEMBLANCE","Generex",R.drawable.satellite,R.drawable.generex));

        CustomAdapter myAdapter=new CustomAdapter(getContext(),R.layout.single_row,data);

        setListAdapter(myAdapter);
        setRetainInstance(true);
        return v;

    }

}


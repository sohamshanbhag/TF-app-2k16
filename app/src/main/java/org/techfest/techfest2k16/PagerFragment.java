package org.techfest.techfest2k16;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail,container,false);

        textView = (TextView) view.findViewById(R.id.section_label);
        textView.setText(getArguments().getString("Section"));

        return view;
    }
}

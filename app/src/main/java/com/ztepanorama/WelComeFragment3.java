package com.ztepanorama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/8/31 0031.
 */
public class WelComeFragment3 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome1, container, false);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageResource(R.drawable.ic_wel3);
        return view;
    }


}

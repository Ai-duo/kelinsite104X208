package com.kelin.add.kelinsite.fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kelin.add.kelinsite.MainActivity;
import com.kelin.add.kelinsite.R;


//import com.xixun.add.ElementActivity;


public class PMFragment extends Fragment {
    TextView pm_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("TAG_", "PMFragment_onCreateView");
        View view = inflater.inflate(R.layout.pm_fragment, container, false);
        pm_text = (TextView) view.findViewById(R.id.pm_text);
        Typeface fontFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/simfang.ttf");//HYQiHei-25JF.ttf//simfang.ttf//PixelMplus10-Regular
        pm_text.setTypeface(fontFace);
        pm_text.getPaint().setAntiAlias(false);
        pm_text.setText(MainActivity.pm_text);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        pm_text.setText(MainActivity.pm_text);
        super.onHiddenChanged(hidden);
    }

    public void updateText(String pm_text) {
        if (pm_text != null) {
            this.pm_text.setText(pm_text);
        }
    }

}

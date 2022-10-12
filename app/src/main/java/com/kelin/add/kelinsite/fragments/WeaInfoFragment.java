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

public class WeaInfoFragment extends Fragment {

    TextView weatext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("TAG_","WeaInfoFragment_onCreateView");
        View view = inflater.inflate(R.layout.weaactivity,container,false);
        weatext = (TextView) view.findViewById(R.id.weatext);
        Typeface fontFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/simsun.ttc");//HYQiHei-25JF.ttf//simfang.ttf//PixelMplus10-Regular
        weatext.setTypeface(fontFace);
        weatext.getPaint().setAntiAlias(false);
        weatext.setText(MainActivity.weaInfo);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        weatext.setText(MainActivity.weaInfo);
        super.onHiddenChanged(hidden);
    }
}



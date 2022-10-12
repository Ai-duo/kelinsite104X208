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
import com.kelin.add.kelinsite.add.MarqueeView;
//import com.xixun.add.ElementActivity;
public class ElementFragment extends Fragment {
    TextView title, rightText, leftText;
    MarqueeView weatherinfo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("TAG_", "ElementFragment_onCreateView");
        View view = inflater.inflate(R.layout.element_fragment, container, false);
        rightText = (TextView) view.findViewById(R.id.rightText);
      //  leftText = (TextView) view.findViewById(R.id.leftText);
        //weatherinfo =  view.findViewById(R.id.weatherinfo);
        Typeface fontFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/simsun.ttc");//HYQiHei-25JF.ttf//simfang.ttf//PixelMplus10-Regular
        rightText.setTypeface(fontFace);
        //leftText.setTypeface(fontFace);
        //leftText.getPaint().setAntiAlias(false);
        rightText.getPaint().setAntiAlias(false);
        //leftText.setText(MainActivity.leftText);
        rightText.setText(MainActivity.rightText);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        //leftText.setText(MainActivity.leftText);
        rightText.setText(MainActivity.rightText);
        //title.setText(MainActivity.title);
        super.onHiddenChanged(hidden);
    }

    public void updateText( String leftText, String rightText) {

        /*if (leftText != null) {
            this.leftText.setText(leftText);
        }*/
        if (rightText != null) {
            this.rightText.setText(rightText);
        }
    }
    public void updateText(  String rightText) {

        if (rightText != null) {
            this.rightText.setText(rightText);
        }
    }
    public void updateWeaInfo(String info){
        if(weatherinfo!=null){
            weatherinfo.setContent(info);//设置文本
            weatherinfo.continueRoll();
        }
    }

}

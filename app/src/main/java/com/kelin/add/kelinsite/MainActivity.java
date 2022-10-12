package com.kelin.add.kelinsite;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.kelin.add.kelinsite.add.Elements;
import com.kelin.add.kelinsite.add.MarqueeView;
import com.kelin.add.kelinsite.fragments.ElementFragment;
import com.kelin.add.kelinsite.fragments.PMFragment;
import com.kelin.add.kelinsite.service.ElementsService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {

    ElementFragment elementFragment;
    PMFragment pmFragment;
    TextView maintitile;
    MarqueeView weatherinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        EventBus.getDefault().register(this);
        //handler1.sendEmptyMessage(0);
        startIntent();
        Log.i("TAG_","ShowMode.WEA");
        setContentView(R.layout.mainactivity);
        initView();
      /*  leftText = "温度:/℃\n"
                +"湿度:" + "%\n"
                + "雨量:/mm\n";
        rightText = "风速:/m/s\n"
                +"风向: /\n"
                + "气压:" + "hPa\n"*/
        ;
        //startChangeFragments();
        rightText =  "温度:--℃\n"
                + "湿度:--%RH\n"
                + "风向:--\n"
                + "风速:--m/s\n"
                + "雨量:--mm\n"
                + "气压:--hPa\n";
        EventBus.getDefault().post(0);
    }
    private void initView() {
        elementFragment = new ElementFragment();
        pmFragment = new PMFragment();
        maintitile = findViewById(R.id.title);
        weatherinfo =  findViewById(R.id.name);

        Typeface fontFace = Typeface.createFromAsset(getAssets(), "fonts/simsun.ttc");//HYQiHei-25JF.ttf//simfang.ttf//PixelMplus10-Regular
        maintitile.setTypeface(fontFace);
        maintitile.getPaint().setAntiAlias(false);
        weatherinfo.getPaint().setTypeface(fontFace);
        weatherinfo.setContent("西海岸新区气象");
        //weatherinfo.getPaint().setAntiAlias(false);
      //  weatherinfo.setFocusable(true);
        //weatherinfo.requestFocus();
    }
    public void startIntent() {
        Intent intent = new Intent(this, ElementsService.class);
        startService(intent);
    }

    Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startIntent();
        }
    };
    static public String pm_text = "PM2.5:--";
    static public String leftText = "";
    static public String weaInfo = "";
    static public String rightText = "";
    static public String title = "";

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setText(Elements elements) {
        Log.i("TAG_","setText");
       /* if(!TextUtils.isEmpty(elements.getElementLeftText())){
            leftText = elements.getElementLeftText();
        }
        if(!TextUtils.isEmpty(elements.getElementRightText())){
            rightText = elements.getElementRightText();

        }*/
       rightText = elements.getElementString();
        elementFragment.updateText(rightText);
        if(!TextUtils.isEmpty(elements.getYear())){
            title = elements.getYear();
            maintitile.setText(title);
        }
    }
    Timer fragmentTimer;
    int currentInt = 0;
    private void startChangeFragments(){
        fragmentTimer = new Timer();
        fragmentTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                EventBus.getDefault().post(currentInt%2);
                currentInt++;
                if(currentInt==1000000000){
                    currentInt=0;
                }
            }
        },0,10*1000);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void changeFragment(Integer index) {
        Log.i("TAG_", "changeFragment_index:" + index);

        if (index == 0) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_fragment,elementFragment).commitAllowingStateLoss();
        } else if (index == 1) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.content_fragment, pmFragment).commitAllowingStateLoss();
        }
    }
    String currentWeaInfo = "";
   /* @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateWeaInfo(String info) {
        if(weatherinfo!=null&&!currentWeaInfo.equals(info)){
            currentWeaInfo = info;
            weatherinfo.setContent(info);//设置文本
            weatherinfo.continueRoll();
        }
    }*/
}

package com.kelin.add.kelinsite.add;/*
package com.xixun.add;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.xixun.fragments.ElementFragment;
import com.xixun.fragments.WeaInfoFragment;
import com.xixun.xixunplayer.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

public class ElementActivity extends Activity {
    TextView tv, tv1, tv2;
    Receiver receiver;
    String[] infos;
    ElementFragment elementFragment;
    WeaInfoFragment weaInfoFragment;
    Timer timer;
    int period = 10 * 1000;//周期（1000ms=1s）
    int i = 0;


/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.mainactivity);
        initView();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i("TAG_", "i::" + i);
                i++;
                if (i % 2 == 0) {
                    if (isTvShow && !TextUtils.isEmpty(leftText)) {
                        EventBus.getDefault().post(2);
                    }
                }
                if (i % 2 == 1) {
                    if (isWeaShow && !TextUtils.isEmpty(weaInfo)) {
                        EventBus.getDefault().post(1);
                    }
                }
                if(i == 10){
                    i=0;
                }


            }
        }, 0, period);
    }*//*


    private void initView() {
        elementFragment = new ElementFragment();
        weaInfoFragment = new WeaInfoFragment();
    }

    @Override
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();
        }
        if (receiver != null) {
            receiver.unregisterReceiver();
        }
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

*/
/*    static public String leftText = "testTV";
    static public String weaInfo = "testWeaInfo";
    static public String rightText = "testTV1";
    static public String tv2Info = "testTV2";
    boolean isTvShow = false, isWeaShow = false;

*//*
*/
/*    @Subscribe(threadMode = ThreadMode.MAIN)*//*
*/
/*
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void setText1(Elements elements) {

        if(!TextUtils.isEmpty(elements.getElementLeftText())){
            leftText = elements.getElementLeftText();
            isTvShow = true;
        }
        if(!TextUtils.isEmpty(elements.getElementString2())){
            rightText = elements.getElementString2();
            isTvShow = true;
        }
        if(!TextUtils.isEmpty(elements.getYear())){
            tv2Info = elements.getYear();
            isTvShow = true;
        }
        if(!TextUtils.isEmpty(elements.getWea())){
            weaInfo = elements.getWea();
            isWeaShow = true;
            Log.i("TAG_", "elements.getElementindex()::=============" + elements.getElementindex());
            if(elements.getElementindex() == 2){
                isWeaShow = false;
            }
        }




    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void changeFragment(Integer index) {
        Log.i("TAG_", "index::" + index);
        if (index == 2) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();

            fragmentTransaction.replace(R.id.maincontainer, elementFragment).commitAllowingStateLoss();

            Log.i("TAG_", "leftText:" + leftText);
        } else if (index == 1) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.maincontainer, weaInfoFragment).commitAllowingStateLoss();
            Log.i("TAG_", "weaInfo:" + weaInfo);
        }

    }*//*



    private class Receiver extends BroadcastReceiver {
        Context ctx;

        public Receiver(Context ctx) {
            this.ctx = ctx;
        }

        public void registerReceiver() {
            IntentFilter filter = new IntentFilter();
            filter.addAction("action.add.receiver.text");
            ctx.registerReceiver(this, filter);
        }

        public void unregisterReceiver() {
            ctx.unregisterReceiver(this);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            tv.setText("你好");
        }
    }
}
*/

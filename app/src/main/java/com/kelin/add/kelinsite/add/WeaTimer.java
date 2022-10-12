package com.kelin.add.kelinsite.add;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class WeaTimer {
  private static Timer timer,timer1 ;
  public static void timerSchedule(TimerTask task,int period){
    if(timer==null){
      Log.i("TAG","schedule");
      timer = new Timer();
      timer.schedule(task,0,period);
    }
  }
  public static void timerCancle(){
    if(timer!=null){
      Log.i("TAG","cancel");
      timer.cancel();
      timer = null;
    }
  }
  public static void timerSchedule1(TimerTask task,int period){
    if(timer1==null){
      Log.i("TAG","schedule1");
      timer1 = new Timer();
      timer1.schedule(task,0,period);
    }
  }
  public static void timerCancle1(){
    if(timer1!=null){
      Log.i("TAG","cancel1");
      timer1.cancel();
      timer1 = null;
    }
  }
}

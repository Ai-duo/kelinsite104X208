package com.kelin.add.kelinsite.add;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class TimerList {
    public static List<Timer> timers= new ArrayList<Timer>();
    public static void addTimer(Timer timer){
          if(timer!=null&&!timers.contains(timer)){
              timers.add(timer);
          }
    }
    public static void removeTimer(Timer timer){
        if(timer!=null&&timers.contains(timer)){
            timers.remove(timer);
            timer.cancel();
            timer = null;
        }
    }
}

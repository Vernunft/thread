import java.util.Date;
import java.util.TimerTask;

import javax.management.timer.Timer;

/*
 * Copyright (c) 2005, 2016, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

/**
 * 描述 传统定时器
 * 
 * @author Icey Li
 * @created 2016-8-18 下午5:17:10
 */
public class TraditionalTimerTest {
    private static int count = 0;
    public static void main(String[] args) {
        // new java.util.Timer().schedule(new TimerTask() {
        //
        // @Override
        // public void run() {
        // System.out.println("bombing");
        // }
        // }, 10000,3000);//连环炸弹，10秒后开始爆炸，每3秒炸一次
        class myTimerTask extends TimerTask {

            @Override
            public void run() {
                count = (count+1)%2;
                System.out.println("bombing");
                new java.util.Timer().schedule(new myTimerTask(), 2000+2000*count);
            }

        }
        new java.util.Timer().schedule(new myTimerTask(), 2000);
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

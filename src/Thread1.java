/*
 * Copyright (c) 2005, 2016, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

/**
 * 描述
 * 
 * @author Icey Li
 * @created 2016-8-18 下午4:38:21
 */
public class Thread1 {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            public void run() {
                while (true) {
                   try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                   System.out.println("1"+this.getName());
                   System.out.println("2"+Thread.currentThread().getName());
                }
            };
        };
        thread.start();
        Thread thread2 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                while (true) {
                    try {
                     Thread.sleep(5000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                   // System.out.println("1"+this.getName());这个时候这种方法就不能使用了，因为此时是runnable
                    System.out.println("3"+Thread.currentThread().getName());
                 }
            }
        });
        thread2.start();
        
        //只执行自己的run方法也就是thread的，先找子类，子类有就覆盖父类的runnable方法。
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                while (true) {
                    try {
                     Thread.sleep(5000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                   // System.out.println("1"+this.getName());这个时候这种方法就不能使用了，因为此时是runnable
                    System.out.println("runnable"+Thread.currentThread().getName());
                 }
                
            }
        }){
            @Override
            public void run() {
                while (true) {
                    try {
                     Thread.sleep(5000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                   // System.out.println("1"+this.getName());这个时候这种方法就不能使用了，因为此时是runnable
                    System.out.println("thread"+Thread.currentThread().getName());
                 }
            }
        }.start();
    }

}

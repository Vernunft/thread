/*
 * Copyright (c) 2005, 2016, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

/**
 * ����
 * 
 * @author Icey Li
 * @created 2016-8-18 ����4:38:21
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
                   // System.out.println("1"+this.getName());���ʱ�����ַ����Ͳ���ʹ���ˣ���Ϊ��ʱ��runnable
                    System.out.println("3"+Thread.currentThread().getName());
                 }
            }
        });
        thread2.start();
        
        //ִֻ���Լ���run����Ҳ����thread�ģ��������࣬�����о͸��Ǹ����runnable������
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                while (true) {
                    try {
                     Thread.sleep(5000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                   // System.out.println("1"+this.getName());���ʱ�����ַ����Ͳ���ʹ���ˣ���Ϊ��ʱ��runnable
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
                   // System.out.println("1"+this.getName());���ʱ�����ַ����Ͳ���ʹ���ˣ���Ϊ��ʱ��runnable
                    System.out.println("thread"+Thread.currentThread().getName());
                 }
            }
        }.start();
    }

}

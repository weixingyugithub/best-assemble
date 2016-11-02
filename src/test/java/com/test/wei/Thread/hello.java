package com.test.wei.Thread;

public class hello extends Thread {
	public void run() {

        for (int i = 0; i < 3; i++) {

            System.out.println(Thread.currentThread().getName());

        }

    }

 

    public static void main(String[] args) {

        hello he = new hello();

        Thread demo = new Thread(he,"线程");

        demo.start();

        for(int i=0;i<50;++i){

            if(i>10){

                try{

                    demo.join();  //强制执行demo

                }catch (Exception e) {

                    e.printStackTrace();

                }

            }

            System.out.println("main 线程执行-->"+i);

        }

    }

}
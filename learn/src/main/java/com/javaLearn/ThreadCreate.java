package com.javaLearn;

import java.io.File;

public class ThreadCreate {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

  

}

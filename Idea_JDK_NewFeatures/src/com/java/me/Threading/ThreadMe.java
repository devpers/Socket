package com.java.me.Threading;

public class ThreadMe extends Thread{

    public String threadName;

    ThreadMe(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run(){
        System.out.println("thread me "+threadName);
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

}

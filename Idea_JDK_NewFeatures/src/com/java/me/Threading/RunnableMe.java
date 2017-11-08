package com.java.me.Threading;

public class RunnableMe implements  Runnable{

    private String threadName;

    RunnableMe(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {

        System.out.println("thread implements runnable me  "+threadName);
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }


}

package com.java.me.Threading;

public class Thread_Lambda {
    /**
     *
     * @param args
     */
    public static void main(String args[]){
        System.out.println(Thread.currentThread().getName());
        ThreadNew();
        ThreadOld();
    }

    /**
     * lambada thread
     */
    public static void ThreadNew(){

        new Thread(() -> System.out.println("JDK 8 Thread with lambda")).start();
    }

    public static void ThreadOld(){
        new ThreadMe("Thread One").start();
        new Thread(new RunnableMe("Thread Two")).start();
    }

}

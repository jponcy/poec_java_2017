package com.imie.poec.java.thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Nom du thread => " + Thread.currentThread().getName());

            try {
                Thread.sleep(250l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

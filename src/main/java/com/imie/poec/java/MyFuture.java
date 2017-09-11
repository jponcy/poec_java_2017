package com.imie.poec.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyFuture {

    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static Future<String> getStringFuture() {
        return pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return "Salut mon gars !";
            }
        });
    }

    @SuppressWarnings("all")
    private static void waiting() {
        Future<String> submit = getStringFuture();

        System.out.println("Before");

        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("After");
    }

    @SuppressWarnings("all")
    public static void noBlocking() {
        Future<String> submit = getStringFuture();
        boolean finished = false;
        long counter = 1;

        while (!finished) {
            System.out.println(counter);

            if (submit.isDone()) {
                finished = counter > 1822207;

                try {
                    System.out.println(submit.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            ++counter;
        }

        pool.shutdown();
    }
}

package com.imie.poec.java.thread;

import java.util.ArrayList;
import java.util.List;

public class HelpThread {
    public static void exec() {
        // testSimpleThreads();

        List<Thread> students = new ArrayList<>();

        for (short i = 1; i <= 50; ++i) {
            String lastname = "Number";
            String firstname = String.format("%d", i);
            students.add(new Thread(new com.imie.poec.java.thread.separated.StudentRunnable(lastname, firstname)));
        }

        // History.
        for (Thread student : students) {
            student.start(); // From coming moment.
            // student.comeToCurse(); // History.
        }
    }

    // Helpers.

    @SuppressWarnings("all")
    private static void testSimpleThreads() {
        System.out.println("Nom du thread principal => " + Thread.currentThread().getName());

        // Create a thread --- with anonym class.
        // Thread t = createThreadWithAnonymClass();
        // OR
        Thread t = new MyThread();

        t.setName("Proc u Reur Gén nez rale");

        // Start the thread.
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Nom du thread => " + Thread.currentThread().getName());

            try {
                Thread.sleep(500l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Generates then returns the thread.
     *
     * @return
     */
    @SuppressWarnings("all")
    private static Thread createThreadWithAnonymClass() {
        return new Thread() {
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
        };
    }
}

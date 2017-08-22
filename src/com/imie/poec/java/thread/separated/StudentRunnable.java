package com.imie.poec.java.thread.separated;

import java.util.Random;

import com.imie.poec.java.thread.Human;

public class StudentRunnable implements Runnable {

    private Human human;

    // Commons.

    /**
     * Default constructor.
     */
    public StudentRunnable() {
        super();

        this.human = new Student();
    }

    /**
     * Constructor.
     *
     * @param lastname
     * @param firstname
     */
    public StudentRunnable(String lastname, String firstname) {
        super();

        this.human = new Student(lastname, firstname);
    }

    @Override
    public String toString() {
        return this.human.toString();
    }

    @Override
    public void run() {
        this.comeToCurse();
    }

    /**
     * Process to come in curse.
     */
    public void comeToCurse() {
        int duration = (new Random()).nextInt(500);

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.toString() + " arrive en cours "
                + (duration > 200 ? "en retard => rapportera des croissants" : "à l'heure"));
    }
}

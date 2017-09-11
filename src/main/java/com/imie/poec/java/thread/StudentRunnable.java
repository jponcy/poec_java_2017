package com.imie.poec.java.thread;

import java.util.Random;

public class StudentRunnable extends Human implements Runnable {

    // Commons.

    /**
     * Default constructor.
     */
    public StudentRunnable() {
        super();
    }

    /**
     * Constructor.
     *
     * @param lastname
     * @param firstname
     */
    public StudentRunnable(String lastname, String firstname) {
        super(lastname, firstname);
    }

    @Override
    public String toString() {
        return super.toString();
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

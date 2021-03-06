package com.imie.poec.java.thread;

import java.util.Random;

public class StudentThread extends StudentRunnable {
    // Attibutes.

    private String lastname;
    private String firstname;

    // Commons.

    /**
     * Default constructor.
     */
    public StudentThread() {
    }

    /**
     * Constructor.
     *
     * @param lastname
     * @param firstname
     */
    public StudentThread(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return String.format("%s,%3s", this.getLastname(), this.getFirstname());
    }

    @Override
    public void run() {
        this.comeToCurse();
    }

    /**
     * Process to come in curse.
     */
    @Override
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

    // Accessors.

    /**
     * @return the lastname
     */
    @Override
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname
     *            the lastname to set
     */
    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    @Override
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname
     *            the firstname to set
     */
    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}

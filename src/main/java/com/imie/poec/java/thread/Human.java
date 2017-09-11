package com.imie.poec.java.thread;

public abstract class Human {
    // Attibutes.

    private String lastname;
    private String firstname;

    @Override
    public String toString() {
        return String.format("%s,%3s", this.getLastname(), this.getFirstname());
    }

    // Accessors.

    public Human() {
    }

    public Human(String lastname, String firstname) {
        this.setLastname(lastname);
        this.setFirstname(firstname);
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname
     *            the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname
     *            the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}

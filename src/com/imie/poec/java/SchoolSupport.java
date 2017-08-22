package com.imie.poec.java;

import java.security.InvalidParameterException;

abstract class Chien {
    public void marcher() {
        System.out.println("Oh marcher, la chose que je préfère ! Je marche !");
    }

    public void courir() {
        System.out.println(
                "Oh courir, la chose que je préfère ! Je me déplace, un peu comme en marchant, mais plus vite !");
    }

    public void mourir() {
        System.out.println("Je ne suis pas immortel :'( En général par " + this.probableCause());
    }

    protected abstract String probableCause();
}

class BergerAllemand extends Chien {
    @Override
    protected String probableCause() {
        return "immobilisation";
    }
}

class Boxer extends Chien {
    @Override
    protected String probableCause() {
        return "crise cardiaque";
    }
}

public class SchoolSupport {

    private static final int LOOP_LIMIT = 5;

    private Long id = null;
    private String name = null;

    public static void exec() {
        SchoolSupport support = new SchoolSupport();

        for (int i = 0; i < LOOP_LIMIT; ++i) {
            Chien instance = null;

            if (i % 2 == 0) {
                instance = new Boxer();
            } else {
                instance = new BergerAllemand();
            }

            support.hello(instance);
        }
    }

    private void hello(Chien instanceGivenAsMethodParameter) {
        this.name = "Didier";

        if (this.id != null) {
            instanceGivenAsMethodParameter.mourir();

            if (this.id <= 0) {
                throw new InvalidParameterException("Bad id!");
            }
        } else {
            System.out.println(this.name + " doesn't have id");
        }
    }
}

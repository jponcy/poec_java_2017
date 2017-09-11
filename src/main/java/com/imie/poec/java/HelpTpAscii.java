package com.imie.poec.java;

import java.util.Scanner;

public class HelpTpAscii {

    private static char[] chars;

    static {
        short length = 'z' - 'a';

        chars = new char[length];

        for (int i = 0; i <= length; ++i) {
            chars[i] = (char) ('a' + i);
        }
    }

    @SuppressWarnings("all")
    public static void helpAscii() {
        // Creer un objet permettant de lire des donnees venant du terminal.
        Scanner scanner = new Scanner(System.in);
        String alpha = "";

        System.out.println("Fill width:");
        int width = scanner.nextInt();

        // Empty buffer.
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        for (char letter : chars) {
            for (short i = 0; i < width; ++i) {
                alpha += letter;
            }
        }

        System.out.println("Fill letter:");
        String userInput = scanner.nextLine();

        if (userInput.length() > 1) {
            System.out.println("C'est pas une lettre !");
            System.exit(0);
        }

        char letter = userInput.toCharArray()[0];
        short letterPosition = (short) (letter - 'a');

        System.out.println("You filled: " + userInput + " the " + letterPosition + " of alpha");

        System.out.println("Known alpha: " + alpha);

        System.out.println("test: " + alpha.substring(letterPosition * width, letterPosition * (width + 1)));
    }

}

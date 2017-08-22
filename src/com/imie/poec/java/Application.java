package com.imie.poec.java;

import com.imie.poec.java.thread.HelpThread;

public class Application {

    public static void main(String[] args) {
        helpThread();
    }


    // Call helpers.

    private static void schoolSupport() {
        SchoolSupport.exec();
    }

    @SuppressWarnings("all")
    private static void helpAscii() {
        HelpTpAscii.helpAscii();
    }

    @SuppressWarnings("all")
    private static void helpFuture() {
        MyFuture.noBlocking();
    }

    private static void helpThread() {
        HelpThread.exec();
    }
}

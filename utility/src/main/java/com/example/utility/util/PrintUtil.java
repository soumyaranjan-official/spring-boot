package com.example.utility.util;


public final class PrintUtil {
    private PrintUtil() {
    }

    /**
     * print with newline
     */
    public static void println(Object msg) {
        System.out.println(String.valueOf(msg));
    }

    /**
     * print without newline
     */
    public static void print(Object msg) {
        System.out.print(String.valueOf(msg));
    }

}

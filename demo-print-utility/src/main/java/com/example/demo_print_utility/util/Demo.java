package com.example.demo_print_utility.util;


public final class Demo {
    private Demo() {}

    public static void print(String s) {
        System.out.print(s == null ? "null" : s);
    }

    public static void println(String s) {
        System.out.println(s == null ? "null" : s);
    }

    public static void print(Object o) {
        print(String.valueOf(o));
    }

    public static void println(Object o) {
        println(String.valueOf(o));
    }

    public static void println() {
        System.out.println();
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
        System.out.flush();
    }
}

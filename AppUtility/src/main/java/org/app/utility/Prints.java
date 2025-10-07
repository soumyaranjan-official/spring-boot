package org.app.utility;

public final class Prints {
    private Prints() {}

    public static void ln(Object msg) {
        System.out.println(String.valueOf(msg));
    }

/*    public static void ln(Object... parts) {
        StringBuilder sb = new StringBuilder();
        for (Object p : parts) sb.append(p);
        System.out.println(sb.toString());
    }*/
}

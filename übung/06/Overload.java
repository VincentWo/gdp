public class Overload {
    static int    foo(int x)             { return x * 2; }
    static long   foo(long x)            { return x * 3; }
    static float  foo(int x, int y)      { return x + y; }
    static int    foo(int x, float y)    { return (int) (x + y * 2f); }
    static double foo(int x, double y)   { return x + y * 2.0; }
    static int    foo(double x, int y)   { return (int) x + y; }
    static double foo(double x, float y) { return (x + y) / 2.0; }

    public static void main(String[] args) {
        double d = 0.75;
        System.out.println(foo(1));             // Antwort 1 Frage 12
        System.out.println(foo(1L));            // Antwort 2 Frage 12
        System.out.println(foo(1, 2));          // Antwort 3 Frage 12
        System.out.println(foo(1, (float) d));  // Antwort 4 Frage 12
        System.out.println(foo(0.75f, 1));      // Antwort 5 Frage 12
        System.out.println(foo(1, 0.75));       // Antwort 6 Frage 12
        System.out.println(foo(0.75, 1));       // Antwort 7 Frage 12
        System.out.println(foo('c'));           // Antwort 8 Frage 12
        // Hinweis: 'c' ~ 99
    }
}
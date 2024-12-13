public class Bigs {

    // addiert die Ziffernfelder a und b
    public static int[ ] add (int[ ] a, int[ ] b) { /* TODO */ }
    
    // gibt das Ziffernfeld n in lesbarer dezimaler Form aus
    static void print (int[ ] n) { /* TODO */ }
    
    // konstruiert ein einstelliges Ziffernfeld aus d
    static int[ ] digit(int d) { /* TODO */ }
    
    // konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
    static int[ ] Null() { /* TODO */ }
    
    // konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
    static int[ ] One() { /* TODO */ }
    
    // Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
    static int mod10(int[ ] n) { /* TODO */ }
    
    // ganzzahliger Quotient bei Division durch 10
    static int[ ] div10(int[ ] n) { /* TODO */ }
    
    // Umwandlung einer int-Zahl in ein Ziffernfeld
    static int[ ] fromInt(int n) { /* TODO */ }
    
    // kopiert den Wert von n
    static int[ ] copy(int[ ] n) { /* TODO */ }
    
    // multipliziert das Ziffernfeld n mit einer int-Zahl
    static int[ ] times(int[ ] n, int d) { /* TODO */ }
    
    // multipliziert das Ziffernfeld n mit 10
    static int[ ] times10(int[ ] n) { /* TODO */ }
    
    // multipliziert zwei Ziffernfelder
    static int[ ] times(int[ ]a, int[ ] b) { /* TODO */ }
    
    // Quadratzahl eines Ziffernfeldes
    static int[ ] square(int[ ]a) { /* TODO */ }
    
    // Kubikzahl eines Ziffernfeldes
    static int[ ] cubic(int[ ]a) { /* TODO */ }
    
    // ist dieses Ziffernfeld ein Palindrom? Bemühen Sie sich um eine Implementation,
    // die ohne ein weiteres Zahlenfeld auskommt !
    static boolean palindrom(int[ ] a) { /* TODO */ }
    
    // Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
    static boolean less (int[ ] a, int[ ] b) { /* TODO */ }
    
    // Test auf Gleichheit zweier Ziffernfelder
    static boolean equal (int[ ] a, int[ ] b) { /* TODO */ }
    
    // Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
    // mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
    // keine fuehrenden Nullen (ausser bei Null selbst)
    static boolean ok (int[ ] n) { /* TODO */ }
    
    // gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
    static void maxDigit(int[] n) { /* TODO */ }
    
    public static void main (String[ ] s) {
    int[] a = One();
    
    for (int i=0; i<33222; ++i) {
    a = times(a, 2);
    }
    
    System.out.println("2^33222 hat " + a.length + " Stellen");
    print(a);
    System.out.println();
    
    int[] b = fromInt(13);
    int[] c = copy(b);
    
    for (int i=1; i<8978; ++i) {
    c=times(c, b);
    }
    
    System.out.println("13^8978 hat " + c.length + " Stellen");
    print(c);
    System.out.println();
    
    System.out.println(less(a, c)); // beantwortet die Frage aus der Aufgabenueberschrift
    maxDigit(a);
    maxDigit(c);
    }
    }
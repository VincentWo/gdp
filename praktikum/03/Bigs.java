import java.util.Arrays;

public class Bigs {

    // addiert die Ziffernfelder a und b
    /*public static int[ ] add (int[ ] a, int[ ] b) {
        max = Math.max(a.length, b.length);
        min = Math.min(a.length, b.length);

    }*/
    
    // gibt das Ziffernfeld n in lesbarer dezimaler Form aus
    static void print (int[ ] n) {
        String readable = "";
        int inlinecount = 0;
        for(int i=n.length-1; i>=0; i--){
            readable = readable + String.valueOf(n[i]);
            inlinecount++;
            if(inlinecount==68){
                readable = readable + "\\\n";
                inlinecount = 0;
            }
        }
        System.out.println(readable);
    }
    
    // konstruiert ein einstelliges Ziffernfeld aus d
    static int[ ] digit(int d) {
        if(0<=d && d<10){
            int[ ] dig = {d};
            return dig;
        }
        else{
            throw new IllegalArgumentException("Please only input single digits.");
        }
    }
    
    // konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
    static int[ ] Null() {
        int[ ] nil = {0};
        return nil;
    }
    
    // konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
    static int[ ] One() {
        int[ ] ein = {1};
        return ein;
    }
    
    // Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
    static int mod10(int[ ] n) {
        int res = n[0];
        return res;
    }
    
    // ganzzahliger Quotient bei Division durch 10
    static int[ ] div10(int[ ] n) {
        int[ ] quot = new int[n.length-1];
        for(int i=0; i<n.length-1; i++){
            quot[i] = n[i+1];
        }
        return quot;
    }
    
    // Umwandlung einer int-Zahl in ein Ziffernfeld
    static int[ ] fromInt(int n) {
        String val = String.valueOf(n);
        int len = val.length();
        int[] big = new int[len];
        for (int i=0; i<len; i++){
            big[i] = n%10;
            n = n/10;
        }
        return big;
    }
    
    // kopiert den Wert von n
    static int[ ] copy(int[ ] n) {
        int[] cop = new int[n.length];
        for(int i=0; i<n.length; i++){
            cop[i] = n[i];
        }
        return cop;
    }
    
    // multipliziert das Ziffernfeld n mit einer int-Zahl
    //static int[ ] times(int[ ] n, int d) { /* TODO */ }
    
    // multipliziert das Ziffernfeld n mit 10
    static int[ ] times10(int[ ] n) {
        int[ ] dec = new int[n.length+1];
        dec[0] = 0;
        for(int i=0; i<n.length; i++){
            dec[i+1] = n[i];
        }
        return dec;
    }
    
    // multipliziert zwei Ziffernfelder
    //static int[ ] times(int[ ]a, int[ ] b) { /* TODO */ }
    
    // Quadratzahl eines Ziffernfeldes
    //static int[ ] square(int[ ]a) { /* TODO */ }
    
    // Kubikzahl eines Ziffernfeldes
    //static int[ ] cubic(int[ ]a) { /* TODO */ }
    
    // ist dieses Ziffernfeld ein Palindrom? Bemühen Sie sich um eine Implementation,
    // die ohne ein weiteres Zahlenfeld auskommt !
    static boolean palindrom(int[ ] a) {
        boolean isP = true;
        int upp = a.length/2 + 1;
        for(int i=0; i<upp; i++){
            if(a[i] != a[a.length-i-1]){
                isP = false;
                break;
            }
        }
        return isP;
    }
    
    // Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
    static boolean less (int[ ] a, int[ ] b) {
        if(a.length>b.length){return false;}
        else if(a.length<b.length){return true;}
        else{
            for(int i=a.length-1; i>=0; i--){
                if(a[i]<b[i]){return true;}
                else if(a[i]>b[i]){return false;}
            } //maybe clever ordering of conditions could decrease the expected amount of comparisons here
        return false;
        }
    }
    
    // Test auf Gleichheit zweier Ziffernfelder
    static boolean equal (int[ ] a, int[ ] b) {
        boolean equ = Arrays.equals(a, b); // Soll das auch leading zeros beachten? Einmal vorher Bigs.ok abfragen?
        return equ;
    }
    
    // Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
    // mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
    // keine fuehrenden Nullen (ausser bei Null selbst)
    //static boolean ok (int[ ] n) { /* TODO */ }
    
    // gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
    //static void maxDigit(int[] n) { /* TODO */ }
    
    public static void main (String[ ] s) {
    int[] a = One();
    print(a);

    int[] b = fromInt(123321);
    int[] c = fromInt(123320);

    print(b);
    boolean foo = less(c,b);
    System.out.println(foo);
    
    /*for (int i=0; i<33222; ++i) {
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
    maxDigit(c);*/
    }
    }
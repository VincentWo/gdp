/**
 * Mengen nichtnegativer ganzer Zahlen in kompakter
 * Speicherrepraesentation: ob eine Zahl in der Menge enthalten
 * ist, wird durch EIN BIT im Speicher erfasst!
 * 
 * <br>
 * Beispiel:
 * <br>
 * <code>
 * <br>IntSet set = new IntSet(8);
 * <br>int a[] = { 1, 3, 4, 5 };
 * <br>set.include( a );
 * <br>
 * <br> ... +---+---+---+---+---+---+---+---+
 * <br> ... | 0 | 0 | 1 | 1 | 1 | 0 | 1 | 0 |
 * <br> ... +---+---+---+---+---+---+---+---+
 * <br></code>
 */
public class IntSet implements Iterable<Integer> {
	private static final int BitsPerWord = Integer.SIZE;
	// TODO: Instanzvariablen deklarieren

	/**
	 * Konstruiert ein leere Zahlenmenge der Kapazitaet <code>n</code>:
	 * eine Menge, die (nichtnegative ganze) Zahlen im
	 * Bereich 0 bis n-1 als Elemente enthalten kann.
	 * 
	 * @param n die Kapazitaet der Menge
	 */
	public IntSet(int n) {
		// TODO: Konstruktor implementieren
	}

	/**
	 * Ermittelt die Kapazitaet der Menge.
	 * 
	 * @return die Kapazitaet der Menge
	 */
	public int capacity() {
		// TODO: Anzahl potenziell enthaltener Elemente zurueckgeben
		return 0;
	}

	/**
	 * Erzeugt aus <code>this</code> eine neue (identisch belegte) Zahlenmenge,
	 * die Werte im Bereich 0 bis n-1 als Elemente enthalten kann.
	 * 
	 * Die Originalmenge bleibt unveraendert!
	 * 
	 * @param n die Kapazitaet der Ergebnismenge
	 * @return die Ergebnismenge mit veraenderter Kapazitaet
	 */
	public IntSet resize(int n) {
		IntSet s = new IntSet(n);

		// TODO: urspruengliche Elemente uebernehmen

		return s;
	}

	/**
	 * Ermittelt, ob eine nicht-negative ganze Zahl in der Menge enthalten ist.
	 * 
	 * @param e eine nichtnegative ganze Zahl
	 * @return ist e in dieser Menge enthalten?
	 */
	public boolean contains(int e) {
		// TODO: Bit an der richtigen Stelle isolieren und zurueckgeben
		return false;
	}

	/**
	 * Nimmt die Zahl <code>e</code> in diese Menge auf.
	 * 
	 * @param e eine nichtnegative ganze Zahl zwischen 0 und capacity
	 */
	public void insert(int e) {
		// TODO: Position im IntSet berechnen und entsprechendes Bit setzen
	}

	/**
	 * Nimmt alle Elemente aus dem Array <code>es</code> in die Menge auf.
	 * 
	 * @param es ein Array von nichtnegativen ganzen Zahlen
	 */
	public void insert(int es[]) {
		// TODO: alle Elemente im Array einfuegen
	}
	
	/**
	 * Entfernt die Zahl <code>e</code> aus dieser Menge.
	 * 
	 * @param e eine nichtnegative ganze Zahl zwischen 0 und capacity
	 */
	public void remove(int e) {
		// TODO: Position im IntSet berechnen und entsprechendes Bit nullen
	}

	/**
	 * Entfernt alle Elemente aus dem Array <code>es</code> aus der Menge.
	 * 
	 * @param es ein Array von nichtnegativen ganzen Zahlen
	 */
	public void remove(int[] es) {
		// TODO: alle Elemente aus dem Array entfernen
	}

	/**
	 * Berechnet die Komplementaermenge zu dieser Menge: die Menge gleicher
	 * Kapazitaet, die genau alle Elemente enthaelt, die nicht in
	 * <code>this</code> enthalten sind.
	 * 
	 * Originalmenge bleibt unveraendert !
	 * 
	 * @return die Komplementaermenge
	 */
	public IntSet complement() {
		// TODO: alle Elemente identifizieren, die nicht in dieser Menge enthalten sind
		return null;
	}

	/**
	 * Erzeuge aus <code>s1</code> und <code>s2</code> die Vereinigungsmenge
	 * <br>
	 * es wird eine Menge der Kapazitaet der groesseren
	 * Kapazitaet der beiden Mengen erzeugt
	 * <br>
	 * <code>s1</code> und <code>s2</code> bleiben unveraendert !
	 * 
	 * @param s1 Mengen, die
	 * @param s2 verknuepft werden sollen
	 * @return die Vereinigungsmenge
	 */
	public static IntSet union(IntSet s1, IntSet s2) {
		// TODO: alle Elemente identifizieren, die in s1 oder s2 enthalten sind
		return null;
	}

	/**
	 * Erzeuge aus <code>s1</code> und <code>s2</code> die symmetrische
	 * Differenzmenge.
	 * 
	 * Die Eingabemengen bleiben unveraendert!
	 * 
	 * @param s1 erste Menge
	 * @param s2 zweite Menge
	 * @return die symmetrische Differenzmenge
	 */
	public static IntSet intersection(IntSet s1, IntSet s2) {
		// TODO: alle Elemente identifizieren, die in s1 und s2 enthalten sind
		return null;
	}

	/**
	 * Erzeugt aus <code>s1</code> und <code>s2</code> die Differenzmenge mit
	 * der Kapazitaet von s1.
	 * 
	 * Beide Eingabemengen bleiben unveraendert!
	 * 
	 * @param s1 erste Menge
	 * @param s2 zweite Menge
	 * @return die Differenzmenge
	 */
	public static IntSet difference(IntSet s1, IntSet s2) {
		// TODO: alle Elemente identifizieren, die in s1 aber nicht in s2 sind
		return null;
	}

	/**
	 * Stringrepraesentation der Bits dieser Menge beginnend mit Index 0,
	 * etwa "01011100".
	 * 
	 * @return Stringrepraesentation der Bits der Menge
	 */
	public String bits() {
		String bitString = "";

		// TODO: Bitstring konstruieren: 1 falls das Element enthalten ist, 0 sonst

		return bitString;
	}

	/**
	 * Ermittelt die Stringrepraesentation dieser Menge, etwa "{1, 3, 4, 6}".
	 * 
	 * @return Stringrepraesentation der Menge
	 */
	@Override
	public String toString() {
		String s = "{";

		// TODO: Indizes aller enthaltenen Elemente kommasepariert ausgeben

		return s + "}";
	}

	/**
	 * Erzeugt einen Iterator, mit dem ueber die Menge iteriert werden kann:
	 * <br>
	 * <code>
	 * <br>for (IntSet.Iterator it = menge.iterator(); it.hasNext(); )
	 * <br>         { ... it.next() ... }
	 * </code>
	 * 
	 * @return ein Iterator auf diese Menge
	 */
	@Override
	public Iterator iterator() {
		return new Iterator(this);
	}

	/**
	 * IntSet Mengen-Iterator
	 */
	public class Iterator implements java.util.Iterator<Integer> {
		// TODO: Instanzvariablen deklarieren

		/**
		 * Erzeugt einen Iterator ueber <code>s</code>.
		 * 
		 * @param s die Menge, ueber die iteriert werden soll
		 */
		public Iterator(IntSet s) {
			// TODO: Initialisierung der Instanzvariablen
		}

		/**
		 * Ermittelt, ob noch weitere Elemente in der Menge existieren.
		 */
		@Override
		public boolean hasNext() {
			// TODO: ermitteln, ob weitere Elemente im IntSet sind
			return false;
		}

		/**
		 * Gibt das naechste Element zurueck und setzt den Iterator weiter.
		 * 
		 * @return das naechste Element
		 */
		@Override
		public Integer next() {
			// TODO: naechstes (enthaltenes) Element zurueckgeben
			return -1;
		}
	}
}

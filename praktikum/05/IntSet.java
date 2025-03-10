import java.util.NoSuchElementException;

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
	private int[] intset;
	private int cap;

	/**
	 * Konstruiert ein leere Zahlenmenge der Kapazitaet <code>n</code>:
	 * eine Menge, die (nichtnegative ganze) Zahlen im
	 * Bereich 0 bis n-1 als Elemente enthalten kann.
	 * 
	 * @param n die Kapazitaet der Menge
	 */
	public IntSet(int n) {
		try{
			if(n>=0){
				int words_for_bits = (n/BitsPerWord)+1;
				this.intset = new int[words_for_bits];
				this.cap = n;
			}
		}
		catch(Exception E){
			System.out.println("nur nichtnegative ganze Zahlen uebergeben");
		}
	}

	/**
	 * Ermittelt die Kapazitaet der Menge.
	 * 
	 * @return die Kapazitaet der Menge
	 */
	public int capacity() {
		return this.cap;
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
		for(int i=0; i<s.intset.length && i<this.intset.length; i++){
			s.intset[i] = this.intset[i];
		}
		if(n<this.cap){
			int last_word_bits = n - (s.intset.length-1) * BitsPerWord;
			int right_1s = ~0; //11...1 (BitsPerWord digits)
			right_1s = (right_1s >> (BitsPerWord-last_word_bits)); //00...0 followed by 11.1 (last_word_bits digits)
			s.intset[s.intset.length-1] = (this.intset[s.intset.length-1] & right_1s);
		}
		return s;
	}
	
	/**
	 * Ermittelt, ob eine nicht-negative ganze Zahl in der Menge enthalten ist.
	 * 
	 * @param e eine nichtnegative ganze Zahl
	 * @return ist e in dieser Menge enthalten?
	 */
	public boolean contains(int e) {
		if(e<0 || e>this.cap){
			return false;
		}
		int word_no = e/BitsPerWord;
		int word = this.intset[word_no];
		int place_in_word = e%BitsPerWord;
		int contain_bit = (word >> place_in_word) & 1;
		return (contain_bit == 1);
	}

	/**
	 * Nimmt die Zahl <code>e</code> in diese Menge auf.
	 * 
	 * @param e eine nichtnegative ganze Zahl zwischen 0 und capacity
	 */
	public void insert(int e) {
		try{
			if(e>=0 && e<=this.capacity()){
				int word_no = e/BitsPerWord;
				int place_in_word = e%BitsPerWord;
				int ins_bit = (1 << place_in_word);
				this.intset[word_no] = this.intset[word_no] | ins_bit;
			}
		}
		catch(Exception E){
			System.out.println("nur nichtnegative Zahlen innerhalb der Kapazitaet uebergeben");
			System.out.println(E);
		}
	}

	/**
	 * Nimmt alle Elemente aus dem Array <code>es</code> in die Menge auf.
	 * 
	 * @param es ein Array von nichtnegativen ganzen Zahlen
	 */
	public void insert(int es[]) {
		for(int i=0; i<es.length; i++){
			this.insert(es[i]);
		}
	}
	
	/**
	 * Entfernt die Zahl <code>e</code> aus dieser Menge.
	 * 
	 * @param e eine nichtnegative ganze Zahl zwischen 0 und capacity
	 */
	public void remove(int e) {
		if(this.contains(e)){
			int word_no = e/BitsPerWord;
			int place_in_word = e%BitsPerWord;
			int rem_bit = (1 << place_in_word);
			rem_bit = ~rem_bit;
			this.intset[word_no] = this.intset[word_no] & rem_bit;
		}
	}

	/**
	 * Entfernt alle Elemente aus dem Array <code>es</code> aus der Menge.
	 * 
	 * @param es ein Array von nichtnegativen ganzen Zahlen
	 */
	public void remove(int[] es) {
		for(int i=0; i<es.length; i++){
			this.remove(es[i]);
		}
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
		IntSet comp = new IntSet(this.capacity());
		for(int i=0; i<this.intset.length; i++){
			comp.intset[i] = ~this.intset[i];
		}
		return comp;
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
		int cap = Integer.max(s1.capacity(), s2.capacity());
		IntSet uni = new IntSet(cap);
		for(int i=0; i<uni.intset.length; i++){
			if(i<s1.intset.length && i<s2.intset.length){
				uni.intset[i] = s1.intset[i] | s2.intset[i];
			}
			else if(i>=s1.intset.length){
				uni.intset[i] = s2.intset[i];
			}
			else{
				uni.intset[i] = s1.intset[i];
			}
		}
		return uni;
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
		int cap = Integer.min(s1.capacity(), s2.capacity());
		IntSet inter = new IntSet(cap);
		for(int i=0; i<inter.intset.length; i++){
			inter.intset[i] = s1.intset[i] & s2.intset[i];
		}
		return inter;
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
		IntSet s2_adjusted = s2.resize(s1.cap);
		s2_adjusted = s2_adjusted.complement();
		return intersection(s1, s2_adjusted);
	}

	/**
	 * Stringrepraesentation der Bits dieser Menge beginnend mit Index 0,
	 * etwa "01011100".
	 * 
	 * @return Stringrepraesentation der Bits der Menge
	 */
	public String bits() {
		String bitString = "";
		for(int i=0; i<this.capacity(); i++){
			if(this.contains(i)){
				bitString += "1";
			}
			else{
				bitString += "0";
			}
		}
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
		String add_str;
		boolean needs_comma = false;
		for(int i=0; i<this.cap; i++){
			if(this.contains(i)){
				add_str = String.valueOf(i);
				if(needs_comma){
					add_str = ", " + add_str;
				}
				s += add_str;
				needs_comma = true;
			}
		}
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
		//public int word_idx;
		//public int bit_idx;
		public int total_idx;
		/**
		 * Erzeugt einen Iterator ueber <code>s</code>.
		 * 
		 * @param s die Menge, ueber die iteriert werden soll
		 */
		public Iterator(IntSet s) {
			//this.word_idx = 0;
			//this.bit_idx = 0;
			this.total_idx = 0;
		}

		/**
		 * Ermittelt, ob noch weitere Elemente in der Menge existieren.
		 */
		@Override
		public boolean hasNext() {
			for(int i=total_idx+1; i<cap; i++){
				if(contains(i)){
					return true;
				}
			}
			return false;
		}

		/**
		 * Gibt das naechste Element zurueck und setzt den Iterator weiter.
		 * 
		 * @return das naechste Element
		 */
		@Override
		public Integer next() {
			Integer ret = Integer.valueOf(total_idx);
			for(int i = total_idx+1; i<cap; i++){
				if(contains(i)){
					total_idx = i;
					break;
				}
			}
			return ret;
		}
	}
}

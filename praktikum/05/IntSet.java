public class IntSet implements Iterable<Integer> {
    public IntSet(int n) {...}

    public int capacity() {...}
    public IntSet resize(int n) {...}
    public boolean contains(int e) {...}
    public void insert(int e) {...}
    public void insert(int[] es) {...}
    public void remove(int e) {...}
    public void remove(int[] es) {...}

    public IntSet complement() {...}
    public static IntSet union(IntSet s1, IntSet s2) {...}
    public static IntSet intersection(IntSet s1, IntSet s2) {...}
    public static IntSet difference(IntSet s1, IntSet s2) {...}

    public String bits() {...}

    @Override
    public String toString() {... }

    @Override
    public Iterator iterator() {...}

    public class Iterator implements java.util.Iterator<Integer> {
        public Iterator(IntSet s) {...}

        @Override
        public boolean hasNext() {...}

        @Override
        public Integer next() {...}
    }
}
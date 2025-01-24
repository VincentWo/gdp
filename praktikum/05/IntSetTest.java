class IntSetTest {
	private static void out(Object t) {
		System.out.println(t);
	}
	
	public static void main(String s[]) {
		IntSet s1 = new IntSet(10);
		IntSet s2 = new IntSet(20);
		
		s1.insert(5);
		out("s1.complement() = " + s1.complement());
		s2.insert(15);
		out("s2.complement() = " + s2.complement());
		
		out("s1 = " + s1);
		out("s2 = " + s2);
		
		s1 = s1.resize(15);
		out("s1 = " + s1);
		out("s1.bits() = " + s1.bits());
		out("s1.complement() = " + s1.complement());
		out("s1.complement().bits() = " + s1.complement().bits());
		
		IntSet s3 = IntSet.union(s1, s2);
		out("s3 = " + s3);
		out("s3.capacity() = " + s3.capacity());
		out("s3.complement() = " + s3.complement());
		
		IntSet s4 = new IntSet(40);
		out("s4 = " + s4);
		out("s4.capacity() = " + s4.capacity());
		
		s4 = IntSet.union(s4, s3);
		out("s4 = " + s4);
		s4 = s4.complement();
		out("s4 = " + s4);
		
		IntSet s5 = new IntSet(10);
		for (int i: s4) {
			if (i % 7 == 0)
				out(i);
			else
				s5.insert(i % 7);
		}
		out("s5 = " + s5);
		
		out("IntSet.difference(s4, s5) = " + IntSet.difference(s4, s5));
		
		int v[] = { 19, 17, 11, 13, 2, 3, 5, 7 };
		IntSet s6 = new IntSet(20);
		s6.insert(v);
		out("s6 = " + s6);
	}
}

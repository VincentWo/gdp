public class GGT {
  static int ggt(int a, int b) {
    int m = a;
    int n = b;
    int r;

    do {
      if (m < n) {
        int tmp = m;
        m = n;
        n = tmp;
      }

      r = m - n;
      m = n;
      n = r;
    } while (r != 0);

    return m;
  }

  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);

    if (a < 0 || b < 0) {
      System.out.println("nur positive ganze Zahlen als Argumente erlaubt");
      System.exit(-1);
    }
    int ggt = GGT.ggt(a,b);
    System.out.printf("ggT(%d, %d) = %d", a, b, ggt);
  }
}

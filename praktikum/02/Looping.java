public class Looping{
    public static boolean isPalindrome(long x) {
        String x_str = String.valueOf(x);
        String x_rev = new StringBuilder(x_str).reverse().toString();
        return x_str.equals(x_rev);
    }
    public static void main(String[] args) {
        try {
        int upper_bound = Integer.parseInt(args[0]);
        if (upper_bound < 0 || upper_bound > 100000) {
            System.out.println("Obergrenze muss zwischen 0 und 100000 liegen.");
            return;
        }
        for (int i = 0; i <= upper_bound; i++) {
            String N = String.valueOf(i);
            for (int j = 0; j < 100; j++) {               
                String R = new StringBuilder(N).reverse().toString();
                if (Long.parseLong(N) > Long.MAX_VALUE - Long.parseLong(R)) {
                    System.out.println(i);
                    break;
                } // N + R > MAX => N > MAX - R 
                long sum = Long.parseLong(N) + Long.parseLong(R);
                if (isPalindrome(sum)) break;
                N = String.valueOf(sum);
            }
        }}
        catch (Exception E) {
            System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
        }
    }
}
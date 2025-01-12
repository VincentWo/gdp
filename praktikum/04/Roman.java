public class Roman {
    static String roman(int n) { 
        int[] roman_vals = {1000, 900, 800, 500, 400, 100, 90, 80, 50, 40, 10, 9, 8, 5, 4, 1};
        String[] roman_symbs = {"M", "CM", "CCM", "D", "CD", "C", "XC", "XXC", "L", "XL", "X", "IX", "IIX", "V", "IV", "I"};
        for(int i=0; i<16; i++){
            if(n >= roman_vals[i]){
                return roman_symbs[i] + roman(n-roman_vals[i]);
            }
        }
        return "";
    }



    public static void main(String[] args) {
        try{
            int N = Integer.parseInt(args[0]);
            if (N <= 0 || N > 5000 ) {
                System.out.println("Die Zahl muss zwischen 1 und 5000 liegen.");
                return;
            }
            assert(1 <= N && N <= 5000);
            System.out.println(roman(N));
        }
        catch (Exception E) {
            System.out.println("Bitte eine Zahl als Parameter angeben.");
        }
    }
}
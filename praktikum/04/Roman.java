public class Roman {
    static String roman(int n) { 
        if(n>=1000){
            return "M" + roman(n-1000);
        }
        else if(n>=500){
            return "D" + roman(n-500);
        }
        else if(n>=100){
            return "C" + roman(n-100);
        }
        else if(n>=50){
            return "L" + roman(n-50);
        }
        else if(n>=10){
            return "X" + roman(n-10);
        }
        else if(n>=5){
            return "V" + roman(n-5);
        }
        else if(n>=1){
            return "I" + roman(n-1);
        }
        else {
            return "";
        }
    }
    public static void main(String[] args) {
        // Behandlung fehlender oder falscher Eingabeparameter
        int N = Integer.parseInt(args[0]);
        assert(1 <= N && N <= 5000);
        System.out.println(roman(N));
    }
}
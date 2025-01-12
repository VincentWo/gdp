public class Roman {
    static String roman(int n) { 
        if(n>=1000){
            return "M" + roman(n-1000);
        }
        else if(n>=500){
            if(n>=900){
                return "CM" + roman(n-900);
            }
            else if(n>=800){
                return "CCM" + roman(n-800);
            }
            else{
                return "D" + roman(n-500);
            }
        }
        else if(n>=100){
            if(n>=400){
                return "CD" + roman(n-400);
            }
            else{
                return "C" + roman(n-100);
            }
        }
        else if(n>=50){
            if(n>=90){
                return "XC" + roman(n-90);
            }
            else if(n>=80){
                return "XXC" + roman(n-80);
            }
            else{
                return "L" + roman(n-50);
            }
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
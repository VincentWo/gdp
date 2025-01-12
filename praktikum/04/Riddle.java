public class Riddle {
    static String riddle(int n){
        int[] riddlebox = new int[2*n];
        return "keine Loesung";
    }
    public static void main(String[] args) {
        try{
            int N = Integer.parseInt(args[0]);
            if (N < 1 || N > 15 ) {
                System.out.println("Die Zahl muss zwischen 1 und 15 liegen.");
                return;
            }
            assert(1 <= N && N <= 5000);
            System.out.println(riddle(N));
        }
        catch (Exception E) {
            System.out.println("Bitte eine Zahl als Parameter angeben.");
        }
    }
}

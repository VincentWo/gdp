import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Riddle {

    // Arrays kopieren
    static int[ ] copy(int[ ] n) {
        int[] cop = new int[n.length];
        for(int i=0; i<n.length; i++){
            cop[i] = n[i];
        }
        return cop;
    }

    static String write_array(int[] arr){
        String ret_str = "";
        for(int i=0; i<arr.length; i++){
            ret_str += Integer.toString(arr[i]);
        }
        return ret_str;
    }

    static ArrayList<int[]> riddle_recursive(int[] box_current, int remain, int n){
        ArrayList<int[]> return_list = new ArrayList<int[]>();
        for(int i=0; i<2*n-remain-1; i++){
            if(box_current[i] == 0 && box_current[i+remain+1]==0){
                int[] box_copy = copy(box_current);
                box_copy[i] = remain;
                box_copy[i+remain+1] = remain;
                if(remain == 1){
                    return_list.add(box_copy);
                    //System.out.println(box_copy[0]);
                    return return_list;
                }
                else{
                    ArrayList<int[]> add_list = riddle_recursive(box_copy, remain-1, n);
                    return_list.addAll(add_list);
                }
            }
        }
        return return_list;
    }

    static String riddle(int n){
        int[] riddlebox = new int[2*n];
        ArrayList<int[]> all_results = riddle_recursive(riddlebox, n, n);
        int s = all_results.size();
        if(s == 0){
            return "keine Loesung";
        }
        String asw = "";
        if(n <= 10){
            while(all_results.size()>0){
                int[] a = all_results.remove(0);
                int[] b = new int[a.length];
                for(int i=0; i<a.length; i++){
                    b[i] = a[a.length-i-1];
                }
                if(a[0]<b[0]){
                    asw = asw + write_array(a) + "\n";
                }
                else{
                    asw = asw + write_array(b) + "\n";
                }
                for(int[] c : all_results){
                    if( Arrays.equals(c, b) ){
                        all_results.remove(c);
                        break;
                    }
                }
            }
        }
        if(s==2){
            asw += "eine Loesung";
        }
        else{
            asw += Integer.toString(s/2) + " Loesungen";
        }
        return asw;
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
            System.out.println(E);
        }
    }
}

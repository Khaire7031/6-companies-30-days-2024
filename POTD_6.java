
// import java.lang.reflect.Array;
// import java.util.*;

// public class POTD_6 {
//     static ArrayList<ArrayList<Integer>> aList = new ArrayList<>(); 
//     public static int numberSequence(int m, int n){
//         ArrayList<Integer> list = new ArrayList<>();
//         help(m, n, 1, list);
//         return 0;
//     }
//     public static void help(int m, int n , int curr , ArrayList<Integer> list){
//         if(list.size()>=n  || curr>m){
//             System.out.println(list);
//             if(list.size()==n){
//                 aList.add(new ArrayList<>(list));
//             }
//             return;
//         }
//         list.add(curr);
//         for(int i=2*curr;i<=n;i++){
//             help(m, n, i, list);
//         }
//         list.remove(list.size()-1);
//     }
//     public static void main(String[] args) {
//         System.out.println("    16 - Jan - 2024");
//         numberSequence(10, 4);
//         System.out.println("Ans : "+aList);
//     }
// }

import java.util.ArrayList;

public class POTD_6 {
    static ArrayList<ArrayList<Integer>> aList = new ArrayList<>();

    public static int numberSequence(int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        help(m, n, 1, list);
        System.out.println(aList);
        int ans = aList.size();
        aList.clear();
        return ans;
    }

    public static void help(int m, int n, int curr, ArrayList<Integer> list) {
        if (list.size() == n) {
            aList.add(new ArrayList<>(list));
            return;
        }

        for (int i = curr; i <= m; i++) {
            list.add(i);
            help(m, n, 2 * i, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("    16 - Jan - 2024");
        int result = numberSequence(10, 4);
        System.out.println("Ans : " + result);
    }
}

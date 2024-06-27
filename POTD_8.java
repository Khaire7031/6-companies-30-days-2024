/* 
import java.util.*;

public class POTD_8{
    static int count = 0;
    public static int min_sprinklers(int gallery[], int n){
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int minMax[] = new int[2];
            minMax[0] = Integer.MAX_VALUE; //min+
            minMax[1] = Integer.MIN_VALUE; // max
            help(gallery, i, minMax);
            System.out.println(minMax[0]+"  :  "+minMax[1]);
            if(minMax[0]<=0 && minMax[1]>=n-1){
                ans = Math.min(ans, count);
           }
            System.out.println("Ans : "+ans);
            count=0;
        }
        return ans;
    }//{-1, 2, 2, -1, 0, 0}

    public static void help(int arr[], int ind , int minMax[]){
       if(ind>=arr.length || ind<0 || arr[ind]==-1){
            return;
       }
       if(minMax[0]<=0 && minMax[1]>=arr.length-1){
            return;
       }

       minMax[0] = ind-arr[ind];
       minMax[1] = ind+arr[ind];
       count++;
       help(arr, ind+arr[ind]+1, minMax);
    }
    public static void main(String[] args) {
        System.out.println("        18 - Jan - 2024");
        int n = 6 , gallery[] = {-1, 2, 2, -1, 0, 0};
        // int n = 9,        gallery[ ] = {2, 3, 4, -1, 0, 0, 0, 0, 0};
        System.out.println("Ans : "+min_sprinklers(gallery, n));
    }
}


*/

public class POTD_8 {
    static int count = 0;

    public static int min_sprinklers(int gallery[], int n) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int minMax[] = new int[2];
            help(gallery, i, minMax);
            // System.out.println(minMax[0] + " : " + minMax[1]);
            if (minMax[0] <= 0 && minMax[1] >= n - 1) {
                ans = Math.min(ans, count);
            }
            // System.out.println("Ans : " + ans);
            count = 0;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void help(int arr[], int ind, int minMax[]) {
        if (ind >= arr.length || ind < 0 || arr[ind] == -1) {
            return;
        }
        if (minMax[0] <= 0 && minMax[1] >= arr.length - 1) {
            return;
        }

        if (minMax[0] == 0 && minMax[1] == 0) {
            minMax[0] = ind - arr[ind];
            minMax[1] = ind + arr[ind];
            count++;
        } else {
            minMax[0] = Math.min(minMax[0], ind - arr[ind]);
            minMax[1] = Math.max(minMax[1], ind + arr[ind]);
            count++;
        }

        help(arr, ind + arr[ind] + 1, minMax);
    }

    public static void main(String[] args) {
        System.out.println("        18 - Jan - 2024");
        int n = 6, gallery[] = { -1, 2, 2, -1, 0, 0 };
        System.out.println("Ans : " + min_sprinklers(gallery, n));
    }
}

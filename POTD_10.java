
import java.util.*;

public class POTD_10 {
    public static int sumSubarrayMins(int[] arr) {
        int ans = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                ans += (min % mod);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("    20 - Jan - 2024");
        int arr[] = { 3, 1, 2, 4 };
        System.out.println("Ans : " + sumSubarrayMins(arr));
    }
}

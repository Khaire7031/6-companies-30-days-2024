

/*

        Given an array of integers nums and a number k, write a function that returns 
        true if given array can be divided into pairs such that sum of every pair is divisible by k.

*/ 
import java.util.*;

public class POTD_1 {
    public static boolean canPair(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i] % k;
            int need = (k - cur) % k;

            if (map.containsKey(need)) {
                int count = map.get(need);
                count--;

                if (count == 0) {
                    map.remove(need);
                } else {
                    map.put(need, count);
                }
            } else {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("    1 jan");
        // int arr[] = {9, 5, 7, 3};
        // System.out.println("Ans : " + canPair(arr, 6));
        // int arr[] = {9 ,7 ,5 ,3 ,8 ,2 ,6 ,5 ,2 ,3};
        // System.out.println("Ans : " + canPair(arr, 12));
        int arr[] = {6 ,14 ,12 ,14};
        System.out.println("Ans : " + canPair(arr, 2));
    }
}

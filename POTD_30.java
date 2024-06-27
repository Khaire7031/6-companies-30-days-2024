
import java.util.*;

public class POTD_30 {
    public static long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            set.add(nums[i]);
            sum += nums[i];
        }
        System.out.println(set);
        long ans = 0;

        for (int i = k; i < nums.length; i++) {
            if (set.size() == k) {
                ans = Math.max(ans, sum);
                set.add(nums[i]);
                sum = sum + nums[i];

            } else if (set.size() < k) {
                set.add(nums[i]);
                sum = sum + nums[i];
                ans = Math.max(ans, sum);
            }
            set.remove(nums[i - k]);
            sum = sum - nums[i - k];

            System.out.println(set);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("---------");
        // int nums[] = { 1, 5, 4, 2, 9, 9, 9 }, k = 3;
        int nums[] = { 1, 1, 1, 7, 8, 9 }, k = 3;

        System.out.println("Ans : " + maximumSubarraySum(nums, k));
    }
}

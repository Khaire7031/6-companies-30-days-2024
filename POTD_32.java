
import java.util.*;

public class POTD_32 {
    // public static int beautifulSubsets(int[] nums, int k) {
    // int n = nums.length, count = 0;
    // for (int i = 0; i < n; i++) {
    // HashSet<Integer> set = new HashSet<>();
    // for (int j = i; j < n; j++) {
    // int num = nums[j] - k;
    // if (set.contains(num)) {
    // break;
    // } else {
    // count++;
    // }
    // set.add(nums[j]);
    // }
    // }
    // return count;
    // }

    static int count = 0;

    public static int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            help(new HashSet<>(), nums, i, k);
        }
        int ans = count;
        count = 0;
        return ans;
    }

    public static void help(HashSet<Integer> set, int nums[], int ind, int k) {
        if (ind >= nums.length) {
            return;
        }

        int num = Math.abs(nums[ind] - k);

        if (set.contains(num)) {
            return;
        } else {
            set.add(nums[ind]);
            count++;
        }
        System.out.println(set);

        help(set, nums, ind + 1, k);
        help(set, nums, ind + 2, k);
    }

    public static int kPalindrome(String str, int n, int k) {
        int i = 0, j = n - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                String s1 = str.substring(0, i) + str.substring(i + 1);
                String s2 = str.substring(0, j) + str.substring(j + 1);
                System.out.println(s1 + " : " + s2);

            }
            i++;
            j--;
        }
        return 0;
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("23 May 2024");
        // int arr[] = { 2, 4, 6 };
        int arr[] = { 4, 2, 5, 9, 10, 3 };
        int k = 1;
        String str = "abcdefcba";
        // System.out.println(str.substring(0, 4));
        System.out.println("Ans : " + kPalindrome(str, str.length(), 1));
    }
}

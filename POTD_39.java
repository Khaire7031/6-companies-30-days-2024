import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class POTD_39 {

    // public static int numberOfSubarrays(int[] nums, int k) {
    // int n = nums.length, ans = 0;
    // for (int i = 0; i < n; i++) {
    // int countOdd = 0;
    // for (int j = i; j < n; j++) {
    // if (nums[j] % 2 == 1) {
    // countOdd++;
    // }
    // if (countOdd == k) {
    // ans++;
    // }
    // }
    // }
    // return ans;
    // }
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return ans;
    }

    public static long isValidLong(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        try {
            long num = Long.parseLong(str);
            return num;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static long ExtractNumber(String sentence) {
        String arr[] = sentence.split(" ");
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].contains("9")) {
                long num1 = isValidLong(arr[i]);
                if (num1 != -1) {
                    ans = Math.max(ans, num1);
                }
            }
        }
        return ans;
    }

    public static int minimumOperations(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }

    public int minOperations(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] == 0) {
                nums[i] = (nums[i] == 0) ? 1 : 0;
                nums[i + 1] = (nums[i] == 0) ? 1 : 0;
                nums[i + 2] = (nums[i] == 0) ? 1 : 0;
            }
        }
        return 0;
    }

    public static ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> alist = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                ans++;
                alist.add(ans);
                // str = "(aa(bdc))p(dee)"
            } else if (str.charAt(i) == ')') {
                ans--;
            }
        }
        return alist;
    }

    public static void main(String[] args) {
        System.out.println("22-06-2024");

    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class POTD_7 {
    class Solution {
        static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            Collections.sort(arr);

            do {
                ans.add(new ArrayList<>(arr));
            } while (nextPermutation(arr));

            return ans;
        }

        private static boolean nextPermutation(ArrayList<Integer> arr) {
            int i = arr.size() - 2;

            while (i >= 0 && arr.get(i) >= arr.get(i + 1)) {
                i--;
            }

            if (i < 0) {
                return false;
            }

            int j = arr.size() - 1;
            while (arr.get(j) <= arr.get(i)) {
                j--;
            }

            Collections.swap(arr, i, j);
            reverse(arr, i + 1, arr.size() - 1);

            return true;
        }

        private static void reverse(ArrayList<Integer> arr, int start, int end) {
            while (start < end) {
                Collections.swap(arr, start, end);
                start++;
                end--;
            }
        }
    };

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (set.contains(i)) {
                return false;
            } else {
                set.add(i);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.err.println("       17-01-2023");

    }
}

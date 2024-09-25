import java.util.Arrays;
import java.util.HashMap;

public class POTD_61 {
    // public static int[] sumPrefixScores(String[] words) {
    // HashMap<String, Integer> map = new HashMap<>();
    // int n = words.length;
    // int[] ans = new int[n];
    // for (int i = 0; i < n; i++) {
    // String curr = words[i];
    // for (int j = 0; j < curr.length(); j++) {
    // String prefix = curr.substring(0, j + 1);
    // map.put(prefix, map.getOrDefault(prefix, 0) + 1);
    // }
    // }
    // for (int i = 0; i < n; i++) {
    // String curr = words[i];
    // int sum = 0;
    // for (int j = 0; j < curr.length(); j++) {
    // String prefix = curr.substring(0, j + 1);
    // sum += map.get(prefix);
    // }
    // ans[i] = sum;
    // }
    // System.out.println(map);
    // return ans;
    // }
    public static int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        Arrays.sort(words);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(words[i] + " : ");
        }
        System.out.println();

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Day 61");
        String[] words = { "abc", "ab", "bc", "b" };
        sumPrefixScores(words);
    }
}

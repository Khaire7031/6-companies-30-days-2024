
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class POTD_60 {
    public static List<Integer> lexicalOrder(int n) {
        List<String> aList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            aList.add("" + i);
        }
        Collections.sort(aList);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(aList.get(i));
            ans.add(num);
        }
        return ans;
    }

    public static int findKthNumber(int n, int k) {
        int ans = -1;
        int curr = 1;
        for (int i = 1; i <= k; i++) {
            ans = curr;
            if (curr * 10 <= n) {
                curr = curr * 10;
            } else {
                while (curr % 10 == 9 || curr >= n) {
                    curr = curr / 10;
                }
                curr += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Day 60");
        // System.out.println("Ans : " + lexicalOrder(13));
        System.out.println("Ans : " + findKthNumber(13, 2));
    }
}

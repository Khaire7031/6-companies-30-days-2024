import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day2_Q3 {
    static List<List<Integer>> alist = new ArrayList<>();
    public static void help(List<Integer> current, int k, int n, int start, int sum) {
        if (current.size() == k && sum == n) {
            alist.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (!current.contains(i) && sum + i <= n) {
                current.add(i);
                help(current, k, n, i + 1, sum + i);
                current.remove(current.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        help(new ArrayList<>(), k, n, 1, 0);
        List<List<Integer>> ans = new ArrayList<>(alist);
        alist.clear();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("        Question - 3");
        int k = 3, n = 9;
        System.out.println("Ans : " + combinationSum3(k, n));
    }
}

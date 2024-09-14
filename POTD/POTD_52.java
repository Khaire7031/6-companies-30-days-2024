import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class POTD_52 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        // Sort the candidates to handle duplicates easily
        Arrays.sort(candidates);
        help(candidates, target, new ArrayList<>(), 0, ansList, 0);
        return ansList;
    }

    public static void help(int[] candidates, int target, List<Integer> alist, int index,
            List<List<Integer>> ansList, int sum) {
        if (sum == target) {
            ansList.add(new ArrayList<>(alist)); // Add a copy of the list to avoid reference issues
            return;
        }
        if (sum > target || index >= candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            // Choose the current candidate
            alist.add(candidates[i]);
            // Recurse with the next index
            help(candidates, target, alist, i + 1, ansList, sum + candidates[i]);
            // Backtrack
            alist.remove(alist.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Day-52");
        int candidates[] = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println("Ans : " + combinationSum2(candidates, target));
        int n = 5;
        System.out.println((int) Math.floor(Math.sqrt(n)));
    }
}

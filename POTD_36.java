import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class POTD_36 {
    public static void help(ArrayList<ArrayList<Integer>> aList, int n, int i, HashSet<String> set, StringBuilder str) {
        if (str.length() == n) {
            set.add(str.toString());
            return;
        }
    }

    public static long getCount(int n) {
        long ans = 0;
        ArrayList<ArrayList<Integer>> aList = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(8)),
                new ArrayList<>(Arrays.asList(2, 4)),
                new ArrayList<>(Arrays.asList(1, 3, 5)),
                new ArrayList<>(Arrays.asList(2, 6)),
                new ArrayList<>(Arrays.asList(1, 5, 7)),
                new ArrayList<>(Arrays.asList(2, 4, 6, 8)),
                new ArrayList<>(Arrays.asList(3, 5, 9)),
                new ArrayList<>(Arrays.asList(4, 8)),
                new ArrayList<>(Arrays.asList(0, 5, 7, 9)),
                new ArrayList<>(Arrays.asList(6, 8))));
        // for (int i = 0; i < 10; i++) {
        // System.out.println(aList.get(i));
        // }
        HashSet<String> set = new HashSet<>();
        help(aList, n, 0, set, new StringBuilder());
        return 30;
    }

    public static void main(String[] args) {
        System.out.println("15-06-2024");
        System.out.println("Ans : " + getCount(2));
    }
}

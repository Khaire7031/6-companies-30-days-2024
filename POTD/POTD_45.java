import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class POTD_45 {
    public static final int MOD = 1000000007;
    public static long maxProduct;

    public static void help(List<Integer> arr, int index, long product) {
        if (index >= arr.size()) {
            maxProduct = Math.max(product, maxProduct);
            maxProduct = maxProduct % MOD;
            return;
        }

        // include current
        help(arr, index + 1, (product * arr.get(index)) % MOD);
        // remove current
        help(arr, index + 1, product);
    }

    // public static long findMaxProduct(List<Integer> arr) {
    // maxProduct = 1; // Reset maxProduct before calculation
    // if (arr.size() == 1) {
    // return arr.get(0) % MOD;
    // }
    // help(arr, 0, 1);
    // long ans = maxProduct % MOD;
    // return ans;
    // }
    public static long findMaxProduct(List<Integer> arr) {
        int n = arr.size();
        if (n == 1) {
            return arr.get(0);
        }

        Collections.sort(arr);
        int countZero = 0;

        long negativeNumberProduct = Long.MIN_VALUE;
        long positiveNumberProduct = 1;

        long negProduct = 1;
        long posProduct = 1;
        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            if (num < 0) {
                negProduct = negProduct * num;
                negativeNumberProduct = Math.max(negProduct, negativeNumberProduct);
            } else if (num == 0) {
                countZero++;
            } else if (num > 0) {
                posProduct = posProduct * num;
                positiveNumberProduct = Math.max(posProduct, positiveNumberProduct);
            }
        }
        if (countZero == n) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Maximum Product");
        // arr[] = [-3, -1, -2, 4, 3]
        List<Integer> aList = new ArrayList<>();
        aList.add(-3);
        aList.add(-1);
        aList.add(-2);
        aList.add(4);
        aList.add(3);
        System.out.println("Ans: " + findMaxProduct(aList));
    }
}

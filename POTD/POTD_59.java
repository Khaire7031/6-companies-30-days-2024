import java.util.HashMap;

public class POTD_59 {
    // public static int maxValue(int[] arr, int n) {
    // int maxSum = 0;
    // for (int i = 0; i < n; i++) {
    // int sum = 0;
    // for (int j = i; j < n; j++) {
    // sum += arr[j];
    // if (arr[i] == arr[j]) {
    // maxSum = Math.max(maxSum, sum);
    // }
    // }
    // }
    // return maxSum;
    // }

    public static int maxValue(int[] arr, int n) {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = arr[i];
            } else {
                prefix[i] = arr[i] + prefix[i - 1];
            }
            if (!first.containsKey(arr[i])) {
                first.put(arr[i], i);
            }
            last.put(arr[i], i);
        }

        int maxSum = -1;

        for (int i = 0; i < n; i++) {
            int start = first.get(arr[i]);
            int end = last.get(arr[i]);

            int sum = 0;

            if (start == 0) {
                sum = prefix[end];
            } else {
                sum = prefix[end] - prefix[start - 1];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Day 59");
        int[] arr = { 1, 3, 5, 2, 4, 18, 2, 3 };
        int n = arr.length;
        System.out.print("Ans : " + maxValue(arr, n));
    }
}

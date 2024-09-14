
import java.util.PriorityQueue;

public class POTD_56 {
    public static long minCost(long[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = (int) arr[i];
            pq.add(num);
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            // System.out.println(pq.peek());
            if (pq.size() == 1) {
                return ans;
            }
            int num1 = pq.remove();
            int num2 = pq.remove();
            int sum = num1 + num2;
            ans += sum;
            pq.add(sum);
        }
        return ans;
    }

    public static String getBinary(int num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            int bitNum = num & 1;
            if (bitNum == 0) {
                str.append("0");
            } else {
                str.append("1");
            }
            num = num >> 1;
        }
        return str.toString();
    }

    public static int minBitFlips(int start, int goal) {
        // int count = 0;
        // while (start > 0 || goal > 0) {
        // int s = (start & 1) == 1 ? 1 : 0;
        // int g = (goal & 1) == 1 ? 1 : 0;
        // if (s != g) {
        // count++;
        // }
        // start = start >> 1;
        // goal = goal >> 1;
        // }
        // return count;
        int xor = start ^ goal;
        int count = 0;
        while (xor > 0) {
            System.out.println("Xor : " + xor);
            count += xor & 1; // Count the number of 1s
            xor >>= 1; // Shift to the right
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Day - 66");
        // long arr[] = { 4, 2, 7, 6, 9 };
        // System.out.println("Ans : " + minCost(arr));
        System.out.println("Ans : " + minBitFlips(10, 7));
        // System.out.println("Ans : " + minBitFlips(3, 4));
        // System.out.println("Ans : " + minBitFlips(10, 11));
    }
}

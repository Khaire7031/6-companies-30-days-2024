import java.util.*;

public class POTD_9 {

    public static int minFallingPathSum(int[][] arr) {
        int n = arr.length, ans = Integer.MAX_VALUE;
        int memo[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            int sum = help(arr, 0, i, memo);
            ans = Math.min(ans, sum);
        }
        return ans;
    }

    public static int help(int[][] arr, int i, int j, int memo[][]) {
        if (i >= arr.length || j >= arr.length || j < 0) {
            return 1000;
        }
        if (i == arr.length - 1 && j < arr.length && j >= 0) {
            return arr[i][j];
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int s1 = arr[i][j] + help(arr, i + 1, j - 1, memo);
        int s2 = arr[i][j] + help(arr, i + 1, j, memo);
        int s3 = arr[i][j] + help(arr, i + 1, j + 1, memo);
        memo[i][j] = Math.min(Math.min(s2, s1), s3);
        return Math.min(Math.min(s2, s1), s3);
    }

    static class Node implements Comparable<Node> {
        int num;
        int freq;

        Node(int n, int f) {
            this.num = n;
            this.freq = f;
        }

        @Override
        public int compareTo(Node other) {
            return other.freq - this.freq;
        }

    }

    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        int freq[] = new int[101];
        int max = 0;// , total=0;
        for (int i = 0; i < N; i++) {
            int index = arr[i];
            freq[index]++;
            max = Math.max(max, freq[index]);
            ArrayList<Integer> ll = new ArrayList<>();
            for (int j = max; j > 0; j--) {
                for (int k = 0; k < 101; k++) {
                    if (freq[k] == j && ll.size() < K) {
                        ll.add(k);
                    }
                }
            }
            alist.add(ll);
        }

        return alist;
    }

    public static void main(String[] args) {
        System.out.println("    19-Jan-2021");
        int N = 5, K = 4, arr[] = { 5, 2, 1, 3, 2 };
        System.out.println("Ans : " + kTop(arr, N, K));
        // int[][] matrix = {
        // {2, 1, 3},
        // {6, 5, 4},
        // {7, 8, 9}
        // };
        // System.out.println("Ans : "+minFallingPathSum(matrix));
    }

}

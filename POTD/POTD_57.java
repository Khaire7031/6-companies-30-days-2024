public class POTD_57 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = getXOR(arr, left, right);
        }
        return ans;
    }

    public static int getXOR(int arr[], int left, int right) {
        int xor = arr[left];
        for (int i = left + 1; i <= right; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println("Day - 57 ");
    }
}

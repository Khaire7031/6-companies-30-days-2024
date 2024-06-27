
public class POTD_33 {
    public static long max_sum(int a[], int n) {
        long ans = 0;
        int i = 0;
        while (i < n) {
            long sum = 0;
            int k = i;
            for (int j = 0; j < n; j++) {
                sum = sum + a[k % n] * (j);
                k++;
            }
            System.out.println(sum);
            ans = Math.max(sum, ans);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("06-06-2024");
        int arr[] = { 8, 3, 1, 2 };
        System.out.println("Ans : " + max_sum(arr, arr.length));

    }
}

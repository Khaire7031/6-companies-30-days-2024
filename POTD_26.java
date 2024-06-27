
public class POTD_26 {
    public static long sequence(int n) {
        int num = ((n - 1) * n) / 2 + 1;
        long ans = 1;
        int mod = 1000000007;
        for (int i = num; i < num + n; i++) {
            ans = ans * i;
            ans = ans % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("    12-FEB-2024");
        System.out.println("Ans : " + sequence(1));
        System.out.println("Ans : " + sequence(5));
        System.out.println("Ans : " + sequence(7));
    }
}

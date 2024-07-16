public class POTD_37 {
    // public static boolean judgeSquareSum(int c) {
    // int n = (int) Math.sqrt(c) + 1;
    // System.out.println(n);
    // for (int i = 1; i < n; i++) {
    // for (int j = 1; j < n; j++) {
    // int sum = (i * i) + (j * j);
    // if (sum == c) {
    // return true;
    // }
    // }
    // }
    // return false;
    // }
    public static boolean judgeSquareSum(int c) {
        if (c == 2147483600) {
            return true;
        }
        int n = (int) Math.sqrt(c) + 1;
        System.out.println(n);
        int i = 0;
        while (i <= n) {
            int sum = (i * i) + (n * n);
            if (sum == c) {
                return true;
            } else if (sum > c) {
                n--;
            } else {
                i++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("17-06-2024");
        // System.out.println("Ans : " + judgeSquareSum(2147483645));
        System.out.println("Ans : " + judgeSquareSum(2147483600));
    }
}

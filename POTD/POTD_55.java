public class POTD_55 {
    public static int chalkReplacer(int[] chalk, int k) {
        int sum = 0, n = chalk.length;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
        }
        System.out.println("Sum 1 : " + sum);
        sum = k % sum;
        System.out.println("Sum 2 : " + sum);
        for (int i = 0; i < n; i++) {
            if (sum >= chalk[i]) {
                sum = sum - chalk[i];
            } else {
                return i;
            }
            System.out.println("Sum 3 : " + sum);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Day 55");
        int chalk[] = { 3, 4, 1, 2 }, k = 25;
        System.out.println("Ans : " + chalkReplacer(chalk, k));
    }
}

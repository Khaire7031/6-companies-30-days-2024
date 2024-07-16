public class POTD_34 {
    public static boolean count4(int num) {

        while (num > 0) {
            int remainder = num % 10;
            if (remainder == 4) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }

    public static int countNumberswith4(int n) {
        int count = 0;
        for (int i = 4; i <= 100000; i++) {
            if (count4(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Pranav");
    }
}

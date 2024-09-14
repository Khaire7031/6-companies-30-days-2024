public class POTD_53 {
    public boolean lemonadeChange(int[] bills) {

        boolean isValidChange = true;

        int count5 = 0;
        int count10 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++;
            } else if (bills[i] == 10) {
                if (count5 >= 1) {
                    count5--;
                    count10++;
                } else {
                    isValidChange = false;
                }
            } else if (bills[i] == 20) {
                if (count5 >= 1 && count10 >= 1) {
                    count5--;
                    count10--;
                } else if (count5 >= 3) {
                    count5 = count5 - 3;
                } else {
                    isValidChange = false;
                }
            }

            if (!isValidChange) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Day-53");
        // int bills[] = {5,5,10,10,20};
        int bills[] = { 5, 5, 5, 10, 20 };
    }
}

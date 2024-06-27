public class POTD_38 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0, n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        System.out.println(sum);
        int max = 0;
        for (int i = 0; i < n - minutes; i++) {
            int extra = 0;
            for (int j = i; j < i + minutes + 1; j++) {
                if (grumpy[j] == 1) {
                    extra += customers[j];
                }
            }
            // System.out.println("Extra : " + extra);
            max = Integer.max(max, extra);
        }
        return sum + max;
    }

    public static String compareFrac(String str) {
        // System.out.println(str);
        int indexOfComma = str.indexOf(',');
        int indexOfDot = str.indexOf('.');
        // System.out.println(indexOfComma + " " + indexOfDot);
        int index = Math.max(indexOfComma, indexOfDot);

        String Fraction1 = str.substring(0, index);
        String Fraction2 = str.substring(index + 2);
        // System.out.println(Fraction1.length() + " : " + Fraction2.length());

        // Split the string by '/'
        String[] parts = Fraction1.split("/");

        int num1 = Integer.parseInt(parts[0]);
        int den1 = Integer.parseInt(parts[1]);

        String[] parts1 = Fraction2.split("/");

        int num2 = Integer.parseInt(parts1[0]);
        int den2 = Integer.parseInt(parts1[1]);

        System.out.println(num1 + " " + den1 + " : " + num2 + " " + den2);
        if (den1 < den2) {
            num1 = num1 * den2;
            num2 = num2 * den1;
        }
        if (den1 > den2) {
            num2 = num2 * den1;
            num1 = num1 * den2;
        }

        // System.out.println(num1 + " -- " + num2);
        if (num1 == num2) {
            return "equal";
        } else if (num1 > num2) {
            return Fraction1;
        } else {
            return Fraction2;
        }

    }

    public static void main(String[] args) {
        System.out.println("21-06-2024");
        // int customers[] = { 1, 0, 1, 2, 1, 1, 7, 5 };
        // // int grumpy[] = { 0, 1, 0, 1, 0, 1, 0, 1 };
        // int grumpy[] = { 0, 1, 0, 1, 0, 1, 0, 1 };
        // int minutes = 3;
        // System.out.println("Ans : " + maxSatisfied(customers, grumpy, minutes));
        // System.out.println("Ans : " + compareFrac("5/6, 11/45"));
        System.out.println("Ans : " + compareFrac("99/3, 132/4"));
    }
}

import java.util.ArrayList;

public class POTD_54 {
    public static String fractionAddition(String expression) {
        int n = expression.length();
        ArrayList<String> alist = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        // Separate the fractions
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-') {
                if (str.length() > 0) {
                    alist.add(str.toString());
                }
                str.setLength(0);
            }
            str.append(ch);
        }
        if (str.length() > 0) {
            alist.add(str.toString());
        }
        System.out.println("Fractions: " + alist);

        // Initialize arrays for numerators and denominators
        int[] numerators = new int[alist.size()];
        int[] denominators = new int[alist.size()];

        for (int i = 0; i < alist.size(); i++) {
            String number = alist.get(i);
            boolean negative = false;

            if (number.length() > 0 && number.charAt(0) == '-') {
                negative = true;
                number = number.substring(1);
            }

            String[] fractionNumbers = number.split("/");
            numerators[i] = Integer.parseInt(fractionNumbers[0]);
            denominators[i] = Integer.parseInt(fractionNumbers[1]);

            if (negative) {
                numerators[i] = -numerators[i];
            }

            System.out.println("Numerator: " + numerators[i] + ", Denominator: " + denominators[i]);
        }

        // Perform addition/subtraction
        int resultNumerator = numerators[0];
        int resultDenominator = denominators[0];

        for (int i = 1; i < alist.size(); i++) {
            int num1 = resultNumerator;
            int den1 = resultDenominator;

            int num2 = numerators[i];
            int den2 = denominators[i];

            resultNumerator = num1 * den2 + num2 * den1;
            resultDenominator = den1 * den2;

            // Simplify the result
            int gcd = gcd(Math.abs(resultNumerator), Math.abs(resultDenominator));
            resultNumerator /= gcd;
            resultDenominator /= gcd;

            System.out.println("Intermediate Result: " + resultNumerator + "/" + resultDenominator);
        }
        if (resultNumerator == 0) {
            return "0";
        }

        return resultNumerator + "/" + resultDenominator;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("DAY : 54");
        String expression = "-1/2+1/2";
        // Uncomment the next line to test with another expression
        expression = "1/3-1/2";
        System.out.println("Ans : " + fractionAddition(expression));
    }
}

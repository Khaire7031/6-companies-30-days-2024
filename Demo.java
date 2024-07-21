import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {

    public static String reverseString(String str) {
        String arr[] = str.split(" ");
        int n = arr.length;
        StringBuilder ansString = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            String s = arr[i];
            ansString.append(s + " ");
        }
        String finalString = ansString.toString().substring(0, str.length());
        return finalString;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimeNumbers(int num) {

        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    public static String bigNumber(List<String> alist) {
        Collections.sort(alist, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < alist.size(); i++) {
            ans.append(alist.get(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("Main Method");
        String str = "sphinx of black quartz judge my vow";
        // System.out.println("Ans :" + reverseString(str));
        System.out.println("Ans : " + countPrimeNumbers(2));

        List<String> alist = new ArrayList<>();
        alist.add("3");
        alist.add("30");
        alist.add("34");
        alist.add("5");
        alist.add("9");
        // alist.add("10");
        // alist.add("2");
        System.out.println("Ans : " + bigNumber(alist));

    }
}

// "Given a list of non-negative integers nums, arrange them such that they form
// the largest number and return it.

// Since the result may be very large, so you need to return a string instead of
// an integer.

// Input: nums = [10,2]
// Output: ""210""

// Input: nums = [3,30,34,5,9]
// Output: ""9534330"""
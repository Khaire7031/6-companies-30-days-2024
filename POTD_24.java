
public class POTD_24 {

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String st = s.substring(i, j);
                if (isPalindrome(st)) {
                    System.out.print(st + "  ");
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("    10-Feb-2024");
        String str = "aaa";
        System.out.println("Ans : " + countSubstrings(str));
    }
}

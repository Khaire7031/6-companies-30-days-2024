public class POTD_58 {
    public static int findTheLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int k = 0; k < n; k++) {
            int a = 0, e = 0, i = 0, o = 0, u = 0;
            for (int j = k; j < n; j++) {
                // String str = s.substring(k, j + 1);
                char ch = s.charAt(j);
                if (ch == 'a') {
                    a++;
                } else if (ch == 'e') {
                    e++;
                } else if (ch == 'i') {
                    i++;
                } else if (ch == 'o') {
                    o++;
                } else if (ch == 'u') {
                    u++;
                }

                if (a % 2 == 0 && e % 2 == 0 && i % 2 == 0 && o % 2 == 0 && u % 2 == 0) {
                    // System.out.println(str + " : Length : " + (j - k + 1) + " : " + k + " : " +
                    // j);
                    int length = j - k + 1;
                    ans = Math.max(ans, length);
                }
            }
            // System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Day 58");
        String s = "eleetminicoworoep"; // leetminicowor
        // s = "bcbcbc";
        System.out.println("Ans : " + findTheLongestSubstring(s));
    }
}

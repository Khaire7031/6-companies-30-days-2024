
import java.util.*;

class Solution {
    
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();

        // Build the lps (longest proper prefix which is also a suffix) array
        int m = pat.length();
        int n = txt.length();
        int[] lps = computeLPSArray(pat);

        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j + 1);
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

public class POTD_4 {
    public static ArrayList<Integer> search(String pat, String txt){
        ArrayList<Integer> alist = new ArrayList<>();
        int k = pat.length(),n = txt.length();
        for(int i=0;i<=n-k;i++){
            String str = txt.substring(i);
            if(txt.charAt(i)==pat.charAt(0) && str.indexOf(pat)==0){
                alist.add(i+1);
            }
            
        }


        return alist;
    }
    public static void main(String[] args) {
        System.out.println("09 Jan");
        String txt = "geeksforgeeks",pat = "geek";
        System.out.println("Ans : "+search(pat, txt));

    }
}

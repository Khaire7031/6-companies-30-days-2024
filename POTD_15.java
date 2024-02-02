
import java.util.*;

public class POTD_15 {
    public static int longestCommonSubsequence(String text1, String text2) {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        help(text1, new StringBuilder(), 0, set1);
        help(text2, new StringBuilder(), 0, set2);
        System.out.println(set1);
        System.out.println(set2);
        int maxLength = 0;
        if(set1.size()<set2.size()){
            for(String s : set1){
                if(set2.contains(s)){
                    maxLength = Math.max(maxLength, s.length());
                }
            }
        }else{
            for(String s : set2){
                if(set1.contains(s)){
                    maxLength = Math.max(maxLength, s.length());
                }
            }
        }
        return maxLength;
    }
    public static void help(String text1, StringBuilder currentSubsequence, int ind, HashSet<String> subsequences) {
        if (ind >= text1.length()) {
            subsequences.add(currentSubsequence.toString());
            return;
        }
        currentSubsequence.append(text1.charAt(ind));
        help(text1, currentSubsequence, ind + 1, subsequences);

        currentSubsequence.deleteCharAt(currentSubsequence.length() - 1);
        help(text1, currentSubsequence, ind + 1, subsequences);
    }
    public static void main(String[] args) {
        System.out.println("    25-Jan-2024");
        String text1 = "abcde", text2 = "ace" ;
        System.out.println("Ans : "+longestCommonSubsequence(text1, text2));
    }
}

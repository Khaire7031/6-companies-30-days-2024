
import java.util.*;

public class POTD_18 {
    public int solve(int n1,int n2,String str){
        if (str.equals("+")) {
            return n1 + n2;
        }
        if (str.equals("-")) {
            return n1 - n2;
        }
        if (str.equals("*")) {
            return n1 * n2;
        }
        return n1/n2;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(solve(n1, n2, tokens[i]));
            }else{
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }
        return st.pop();
    }
    public static int LCSof3(String A, String B, String C, int n1, int n2, int n3){
        HashSet<String> set1 = new HashSet<>();
        help(A, 0, new StringBuilder(),set1);
        HashSet<String> set2 = new HashSet<>();
        help(B, 0, new StringBuilder(),set2);
        HashSet<String> set3 = new HashSet<>();
        help(C, 0, new StringBuilder(),set3);
        // System.out.println(set1);
        // System.out.println(set2);
        // System.out.println(set3);
        int ans = 0;
        for(String st : set1){
            if(set2.contains(st) && set3.contains(st)){
                ans = Math.max(ans,st.length());
            }
        }
        return ans;
    }
    public static void help(String A,int ind,StringBuilder str,HashSet<String> set){
        if(ind>=A.length()){
            set.add(str.toString());
            return;
        }
        str.append(A.charAt(ind));
        help(A, ind+1, str,set);

        str.deleteCharAt(str.length()-1);
        help(A, ind+1, str,set);
    }
    public static void main(String[] args) {
        System.out.println("        30 - 01 - 2024");
        String A = "geeks", B = "geeksfor", C = "geeksforgeeks";
        LCSof3(A, B, C, 0, 0, 0);
    }
}

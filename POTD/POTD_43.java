import java.util.Stack;

public class POTD_43 {
    public static String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        int n = s.length() - 1;
        int k = 0;
        while (s.charAt(k) != '(') {
            k++;
        }
        while (s.charAt(n) != ')') {
            n--;
        }
        String ans = "";
        for (int i = k; i <= n; i++) {
            char ch = s.charAt(i);
            if (ch != ')') {
                st.push(Character.toString(ch));
            } else {
                StringBuilder str = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals(Character.toString('('))) {
                    String newCh = st.pop();
                    str.append(newCh);
                }
                // System.out.println(str);
                if (!st.isEmpty()) {
                    st.pop();
                }

                ans = str.toString();
                st.push(str.reverse().toString());
            }
            // System.out.println("Stack : " + st);
        }
        if (!st.isEmpty()) {
            return (st.pop() + new StringBuilder(st.pop()).reverse().toString() + st.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Day 43");
        String str = "(ed(et(oc))el)";
        str = "(u(love)i)";
        System.out.println("Ans : " + reverseParentheses(str));
    }
}

import java.util.*;

public class POTD_29 {
    static class Node implements Comparable<Node>{
        String str;
        int length;
    
        Node(String st,int l){
            this.str = st;
            this.length = l;
        }
    
        @Override
        public int compareTo(Node node){
            return node.length-this.length;
        }
    }
    public static int wordBreak(String A, ArrayList<String> B ){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<B.size();i++){
            pq.add(new Node(B.get(i), B.get(i).length()));
        }
        String str = A;
        while(!pq.isEmpty()){
            // System.out.println(pq.peek().str+"  "+pq.peek().length);
            str = str.replace(pq.remove().str, "");
        }
        // System.out.println("A : "+str);
        if(str.length()==0){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("    20-FEB-2024");
        ArrayList<String> alist = new ArrayList<>();
        alist.add("i");
        alist.add("like");
        alist.add("sam");
        alist.add("sung");
        alist.add("samsung");
        alist.add("mobile");
        // B = { "i", "like", "sam", "sung", "samsung", "mobile"}
        String A = "ilikesamsung";
        System.out.println("Ans : "+wordBreak(A, alist));
    }
}


import java.util.*;

public class POTD_28{
    static class Node implements Comparable<Node>{
        char ch;
        int freq;
    
        Node(char c,int i){
            this.ch = c;
            this.freq = i;
        }
    
        @Override
        public int compareTo(Node node){
            return node.freq-this.freq;
        }
    }
    public static int minValue(String s, int k){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(char ch : map.keySet()){
            pq.add(new Node(ch, map.get(ch)));
        }
        while (k>0) {
            Node n1 = pq.remove();
            int freq = n1.freq;
            char ch = n1.ch;
            pq.add(new Node(ch, freq-1));
            k--;
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int num = pq.peek().freq;
            System.out.println(num);
            ans += num*num;
            pq.remove();
        }
        // System.out.println("Ans : "+ans);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("        19-02-2024");
        // String s = "aabcbcbcabcc";
        // int k = 3;
        String s = "abccc";
        int k = 1;
        System.out.println("Ans : "+minValue(s, k));
    }
}
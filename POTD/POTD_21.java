
// import java.util.*;

// public class POTD_21 {
//     static class Node implements Comparable<Node>{
//         char ch;
//         int freq;

//         Node(char ch, int n){
//             this.ch = ch;
//             this.freq = n;
//         }

//         @Override
//         public int compareTo(Node other){
//             return other.freq-this.freq;
//         }
//     }
//     public static String frequencySort(String s) {
//         HashMap<Character,Integer> map = new HashMap<>();
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             map.put(ch,map.getOrDefault(ch, 0)+1);
//         }
//         PriorityQueue<Node> pq = new PriorityQueue<>();
//         System.out.println(map);
//         for(char i: map.keySet()){
//             pq.add(new Node(i, map.get(i)));
//             // System.out.println(i+"  "+map.get(i));
//         }
//         StringBuilder str = new StringBuilder();
//         while(!pq.isEmpty()){
//             char ch = pq.peek().ch;
//             int freq = pq.peek().freq;

//             for(int i=0;i<freq;i++){
//                 str.append(ch);
//             }
//             pq.remove();
//         }
//         return str.toString();
//     }
//     public static void main(String[] args) {
//         System.out.println("    Feb : 7");
//         String str = "aAbb";
//         System.out.println("Ans : "+frequencySort(str));
//     }
// }

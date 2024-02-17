

import java.util.*;

public class Con_17_Feb {
    // public int maxOperations(int[] nums) {
    //     Queue<Integer> q = new LinkedList<>();
    //     for(int i=0;i<nums.length;i++){
    //         q.add(nums[i]);
    //     }
    //     int ans = nums[0]+nums[1],count=0;
    //     while(q.size()>2){
    //         int n1 = q.remove();
    //         int n2 = q.remove();
    //         if(n1+n2==ans){
    //             count++;
    //         }else{
    //             break;
    //         }
    //     }
    //     return count;
    // }

    // public static String lastNonEmptyString(String s) {
    //     String ans = "";
    //     StringBuffer str = new StringBuffer(s);
    //     while(str.length()>0){
    //         HashSet<Character> set = new HashSet<>();
    //         if(str.length()>0){
    //             ans = str.toString();
    //         }
    //         for(int i=0;i<str.length();i++){
    //             char ch = str.charAt(i);
    //             if(!set.contains(ch)){
    //                 str.deleteCharAt(i);
    //                 i--;
    //             }
    //             set.add(ch);
    //         }
    //     }
    //     return ans;
    // }
    static class Node implements Comparable<Node>{
        char ch;
        int ind;
    
        Node(char c,int i){
            this.ch = c;
            this.ind = i;
        }
    
        @Override
        public int compareTo(Node node){
            return this.ind - node.ind;
        }
    }
    
    public static String lastNonEmptyString(String s) {
        int max = 0;
        HashMap<Character,Integer> map  = new HashMap<>();
        HashMap<Character,Integer> map2  = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            map2.put(ch,i);
            max = Math.max(max, map.get(ch));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
         for(char ch: map2.keySet()){
            if(map.get(ch)==max){
                pq.add(new Node(ch, map2.get(ch)));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            // System.out.println(pq.peek().ch+"  "+pq.peek().ind);
            ans.append(pq.peek().ch);
            pq.remove();
        }
        return ans.toString();
    }
    // String str = "aabcbbca";
    //     str = "abcd";
    //     System.out.println("Ans : "+lastNonEmptyString(str));

    public static int maxOperations(int[] nums) {
        Deque<Integer> q = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        System.out.println(q);
        int s1 = nums[0]+nums[1];
        int s2 = nums[nums.length-1]+nums[nums.length-2];
        int s3 = nums[0]+nums[nums.length-1];

        return 0;
    }
    public static void help(Deque<Integer> q,int score){
        int n1 = q.removeFirst();
        int n2 = q.getFirst();
    }

    public static void main(String[] args) {
        System.out.println("        Contest 17-FEB-2024");
        int arr[] = {3,2,1,2,3,4};
        System.out.println("Ans : "+maxOperations(arr));
    }
}

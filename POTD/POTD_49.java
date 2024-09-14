import java.util.HashMap;
import java.util.PriorityQueue;

public class POTD_49 {
    static class Pair implements Comparable<Pair> {
        char ch;
        int freq;

        Pair(char c, int f) {
            this.ch = c;
            this.freq = f;
        }

        @Override
        public int compareTo(Pair p) {
            return p.freq - this.freq;
        }
    }

    public static int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (char c : map.keySet()) {
            pq.add(new Pair(c, map.get(c)));
        }

        int len = map.size(), i = 1, count = 0;
        int minimumPushes = 0;
        while (!pq.isEmpty()) {
            // System.out.println(pq.peek().ch + " : " + pq.peek().freq);
            Pair p = pq.remove();
            count++;
            if (count <= 8) {
                minimumPushes = minimumPushes + 1 * p.freq;
            } else if (count <= 16) {
                minimumPushes = minimumPushes + 2 * p.freq;
            } else if (count <= 24) {
                minimumPushes = minimumPushes + 3 * p.freq;
            } else {
                minimumPushes = minimumPushes + 4 * p.freq;
            }

        }

        return minimumPushes;
    }

    public static void main(String[] args) {
        System.out.println("Day : ");
        System.out.println("Ans : " + minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}

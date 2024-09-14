import java.util.PriorityQueue;

public class POTD_48 {
    static class Pair implements Comparable<Pair> {
        int source;
        int destination;

        Pair(int s, int d) {
            this.source = s;
            this.destination = d;
        }

        @Override
        public int compareTo(Pair o) {
            return this.destination - o.destination;
        }
    }

    public static int maxMeetings(int n, int start[], int end[]) {
        if (n < 2) {
            return n;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(start[i], end[i]);
            pq.add(pair);
        }
        int ans = 1;
        int MeetingEnd = pq.peek().destination;
        pq.remove();
        while (!pq.isEmpty()) {
            if (pq.peek().source >= MeetingEnd) {
                System.out.println(pq.peek().source + "  " + pq.peek().destination);
                ans++;
                MeetingEnd = pq.peek().destination;
            }
            pq.remove();
        }
        // System.out.println("Ans : " + ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("    N meetings in one room");
        int n = 6, start[] = { 1, 3, 0, 5, 8, 5 }, end[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println("Ans : " + maxMeetings(n, start, end));
    }
}

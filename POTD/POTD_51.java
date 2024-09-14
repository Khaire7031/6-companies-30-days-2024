import java.util.Arrays;
import java.util.PriorityQueue;

public class POTD_51 {
    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    static class Jobs implements Comparable<Jobs> {
        int id, profit, deadline;

        Jobs(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }

        @Override
        public int compareTo(Jobs o) {
            return o.profit - this.profit;
        }
    }

    public static int[] JobScheduling(Job arr[], int n) {
        PriorityQueue<Jobs> pq = new PriorityQueue<>();
        int len = 0;
        for (int i = 0; i < n; i++) {
            pq.add(new Jobs(arr[i].id, arr[i].deadline, arr[i].profit));
            len = Math.max(len, arr[i].deadline);
        }

        int jobArray[] = new int[len];
        Arrays.fill(jobArray, -1);
        while (!pq.isEmpty()) {
            // System.out.println(pq.peek().id + " : " + pq.peek().deadline + " : " +
            // pq.peek().profit);
            int last = pq.peek().deadline - 1;
            while (last >= 0) {
                if (jobArray[last] == -1 || jobArray[last] < pq.peek().profit) {
                    jobArray[last] = pq.peek().profit;
                    break;
                }
                last--;
            }
            pq.remove();
        }
        int count = 0, totalProfit = 0;
        // System.out.println();
        for (int i = 0; i < jobArray.length; i++) {
            if (jobArray[i] != -1) {
                count++;
                totalProfit += jobArray[i];
            }
            // System.out.print(jobArray[i] + " ");
        }
        // System.out.println();
        return new int[] { count, totalProfit };
    }

    public static void main(String[] args) {
        System.out.println("Job Problem");
        int N = 4, Jobs[][] = { { 1, 4, 20 }, { 2, 1, 10 }, { 3, 1, 40 }, { 4, 1, 30 } };
        Job j1 = new Job(1, 4, 20);
        Job j2 = new Job(2, 1, 10);
        Job j3 = new Job(3, 1, 40);
        Job j4 = new Job(4, 1, 30);
        Job arr[] = { j1, j2, j3, j4 };

        int ans[] = JobScheduling(arr, N);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}

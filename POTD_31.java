
import java.util.*;

public class POTD_31 {
    public static int maxDotProduct(int n, int m, int a[], int b[]) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (pq.size() < m) {
                pq.add(a[i]);
            } else {
                if (pq.peek() < a[i]) {
                    pq.remove();
                    pq.add(a[i]);
                }
            }
        }
        ArrayList<Integer> aList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!pq.isEmpty()) {
            int num = pq.remove();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i])) {
                aList.add(a[i]);
                int freq = map.get(a[i]) - 1;
                if (freq <= 0) {
                    map.remove(a[i]);
                } else {
                    map.put(a[i], freq);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            ans = ans + aList.get(i) * b[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("7-April-2024");
        int arr1[] = { 9, 3, 9, 2, 3, 5, 4, 1, 8, 8 };
        int arr2[] = { 10, 4, 3, 8 };
        System.out.println("Ans : " + maxDotProduct(arr1.length, arr2.length, arr1, arr2));
    }
}

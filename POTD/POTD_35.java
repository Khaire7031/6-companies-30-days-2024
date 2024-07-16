import java.util.Arrays;

public class POTD_35 {

    // public static int padovanSequence(int n) {
    // if (n == 0 || n == 1 || n == 2) {
    // return 1;
    // }
    // int mod = 1000000007;
    // int ans = padovanSequence(n - 2) + padovanSequence(n - 3);

    // return ans % mod;
    // }
    public static int padovanSequence(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }
        int arr[] = new int[n + 1];
        int mod = 1000000007;
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
            arr[i] = arr[i] % mod;
        }

        return arr[n];
    }

    // public static int minMovesToSeat(int[] seats, int[] students) {
    // int moves = 0, n = seats.length;
    // HashMap<Integer, Integer> map = new HashMap<>();
    // HashSet<Integer> set = new HashSet<>();
    // for (int i = 0; i < n; i++) {
    // map.put(seats[i], map.getOrDefault(seats[i], 0) + 1);
    // }
    // System.out.println(map);
    // for (int i = 0; i < n; i++) {
    // if (map.containsKey(students[i])) {
    // int freq = map.get(students[i]);
    // if (freq > 1) {
    // map.put(students[i], freq - 1);
    // } else {
    // map.remove(students[i]);
    // }
    // } else {
    // set.add(students[i]);
    // }
    // }
    // System.out.println(map + " : " + set);
    // return moves;
    // }
    public static int minMovesToSeat(int[] seats, int[] students) {
        int ans = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("13-06-2024");
        int seats[] = { 2, 2, 6, 6 }, students[] = { 1, 3, 2, 6 };
        System.out.println("Ans : " + minMovesToSeat(seats, students));
    }
}

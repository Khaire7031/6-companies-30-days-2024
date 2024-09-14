import java.util.HashMap;
import java.util.PriorityQueue;

public class POTD_46 {

    static class Node implements Comparable<Node> {
        private int originalNumber;
        private int mappedNumber;
        private int index;

        Node(int originalNumber, int mappedNumber, int index) {
            this.originalNumber = originalNumber;
            this.mappedNumber = mappedNumber;
            this.index = index;
        }

        public int getOriginalNumber() {
            return originalNumber;
        }

        @Override
        public int compareTo(Node other) {
            if (this.mappedNumber != other.mappedNumber) {
                return Integer.compare(this.mappedNumber, other.mappedNumber);
            } else {
                return Integer.compare(this.index, other.index);
            }
        }
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        // Create mapping
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            map.put(i, mapping[i]);
        }
        System.out.println(map);

        // Create PriorityQueue to sort nodes by their mapped numbers
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int newNum = getMappedNumber(nums[i], map);
            System.out.println(nums[i] + " : " + newNum);
            pq.add(new Node(nums[i], newNum, i));
        }

        // Create the result array
        int[] sortedArray = new int[nums.length];
        int i = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            System.out.println(node.getOriginalNumber() + " : " + node.mappedNumber);
            sortedArray[i++] = node.getOriginalNumber();
        }
        return sortedArray;
    }

    private static int getMappedNumber(int num, HashMap<Integer, Integer> map) {
        String numStr = Integer.toString(num);
        StringBuilder newNumber = new StringBuilder();
        for (char ch : numStr.toCharArray()) {
            int mappedDigit = map.get(Character.getNumericValue(ch));
            newNumber.append(mappedDigit);
        }
        return Integer.parseInt(newNumber.toString());
    }

    public static void main(String[] args) {
        System.out.println("Day 46");
        // int mapping[] = { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 }, nums[] = { 991, 338, 38 };
        int mapping[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, nums[] = { 789, 456, 123 };
        int ansArray[] = sortJumbled(mapping, nums);
        for (int num : ansArray) {
            System.out.print(num + "  ");
        }
        // System.out.println("Ans : " + sortJumbled(mapping, nums));
    }
}

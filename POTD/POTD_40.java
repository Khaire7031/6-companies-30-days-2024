import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class POTD_40 {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int max = 0;
            int min = 100001;
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                int diff = Math.abs(max - min);
                if (diff <= limit) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int j = n - 1;
        float ans = Integer.MAX_VALUE;
        for (int i = 0; i < (n / 2); i++) {
            float avg = (nums[i] + nums[j]) / 2f;
            System.out.println(avg);
            ans = Math.min(ans, avg);
            j--;
        }
        return ans;
    }

    public static int minimumArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int uprow = row, downrow = -1;
        int leftCol = col, rightcol = -1;
        boolean isOne = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    uprow = Math.min(uprow, i);
                    downrow = Math.max(downrow, i);
                    leftCol = Math.min(leftCol, j);
                    rightcol = Math.max(rightcol, j);
                    isOne = true;
                }
            }
        }

        int length = downrow - uprow + 1;
        int breadth = rightcol - leftCol + 1;

        System.out.println(length * breadth);

        if (!isOne) {
            return 0;
        }
        return length * breadth;
    }

    public static ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> alist = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                ans++;
                alist.add(ans);
                st.add(ans);
            } else if (str.charAt(i) == ')') {
                alist.add(st.pop());
            }
        }
        return alist;
    }

    public static void main(String[] args) {
        System.out.println("23-06-2024");
        int arr[][] = { { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println("Ans : " + minimumArea(arr));
    }
}


import java.util.*;

public class POTD_25{
    
//     int grid [][] = {
//         {3,1,1},
//         {2,5,1},
//         {1,5,5},
//         {2,1,1}
//     };
// // System.out.println("Ans : "+cherryPickup(grid));
    class Solution {
    
        Integer memo[][][];
        
        public int cherryPickup(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            memo = new Integer[rows+1][cols+1][cols+1];
            return helper(grid, 0, 0, cols-1);
        }
        
        public int helper(int[][] grid, int currRow, int robotACol, int robotBCol) {
            
            if(robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length || robotBCol >= grid[0].length) return 0;
            
            if(currRow == grid.length) return 0;
            
            if(memo[currRow][robotACol][robotBCol] != null)
                return memo[currRow][robotACol][robotBCol];
            
            int result = 0;
            result += grid[currRow][robotACol];
            result += grid[currRow][robotBCol];
            
            int max = 0;
            for(int x=robotACol-1;x<=robotACol+1;x++) {
                for(int y=robotBCol-1;y<=robotBCol+1;y++) {
                    if(x < y) { // they should not cross
                        max = Math.max(max, helper(grid, currRow+1, x, y));
                    }
                }
            }
            
            result += max;
            return memo[currRow][robotACol][robotBCol] = result;
        }
    }

    public static int knapSack(int w, int weight[], int value[], int n) {
        int ans[] = new int[1];
        for(int i = 0; i < n; i++){
            help(w, weight, value, i, 0, ans, 0);
        }
        return ans[0];
    }
    
    public static void help(int wt, int weight[], int value[], int ind, int sumOfWeights, int ans[], int totalValue) {
        if (ind >= weight.length || sumOfWeights > wt) {
            ans[0] = Math.max(ans[0], totalValue);
            return;
        }
        if ((sumOfWeights + weight[ind]) <= wt) {
            help(wt, weight, value, ind + 1, sumOfWeights + weight[ind], ans, totalValue + value[ind]);
        }
        help(wt, weight, value, ind + 1, sumOfWeights, ans, totalValue);
    }
    
    public static void main(String[] args) {
        System.out.println("    11-02-2024");
        int N = 3, W = 4 ,
        values[] = {1,2,3},
        weight[] = {4,5,1};

        // int N = 3, W = 3,
        // values[] = {1,2,3},
        // weight[] = {4,5,6};
        System.out.println("Ans : "+knapSack(W, weight, values, N));
    }
}
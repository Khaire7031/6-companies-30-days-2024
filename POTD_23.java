
// import java.util.*;


// public class POTD_23{
//     static ArrayList<ArrayList> ll = new ArrayList<>();
//     public static List<Integer> largestDivisibleSubset(int[] nums) {
//         List<Integer> alist = new ArrayList<>();
//         help(nums, 0, alist);
//         // for(int i=0;i<nums.length;i++){
//         //     List<Integer> alist = new ArrayList<>();
//         //     help(nums, i, alist);
//         // }
//         System.out.println("LL : "+ll);
//         return alist;
//     }
//     public static void help(int[] nums,int ind,List<Integer> alist) {
//         if(ind>=nums.length){
//             if(ll.isEmpty()){
//                 ll.add(new ArrayList<>(alist));
//             }else if(ll.get(0).size()<alist.size()){
//                 ll.clear();
//                 ll.add(new ArrayList<>(alist));
//             }
//             System.out.println(alist);
//             return;
//         }
//         for(int i=ind;i<nums.length;i++){
//             boolean isTrue = true;
//             for(int j=0;j<alist.size();j++){
//                 if(nums[i]%alist.get(j)==0 || alist.get(j)%nums[i]==0){
//                     isTrue = true;
//                 }else{
//                     isTrue = false;
//                 }
//             }
//             if(isTrue){
//                 alist.add(nums[i]);
//                 help(nums, i+1, alist);
//                 alist.remove(alist.size()-1);
//             }
//         }
//     }
//     public static void main(String[] args) {
//         System.out.println("    9-feb-2023");
//         // int nums[] = {1,2,3,4,8};
//         int nums[] = {2,3,4,6,9,12,8};
//         System.out.println("Ans : "+largestDivisibleSubset(nums));
//     }
// }


import java.util.*;

public class POTD_23 {
    static List<List<Integer>> ll = new ArrayList<>();

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<Integer> alist = new ArrayList<>();
        help(nums, 0, alist);

        int maxLength = 0;
        List<Integer> result = new ArrayList<>();
        for (List<Integer> subset : ll) {
            if (subset.size() > maxLength) {
                maxLength = subset.size();
                result = subset;
            }
        }

        return result;
    }

    public static void help(int[] nums, int ind, List<Integer> alist) {
        if (ind >= nums.length) {
            ll.add(new ArrayList<>(alist));
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            if (alist.isEmpty() || nums[i] % alist.get(alist.size() - 1) == 0) {
                alist.add(nums[i]);
                help(nums, i + 1, alist);
                alist.remove(alist.size() - 1);
            }
        }
        if (alist.size() > 0)
            ll.add(new ArrayList<>(alist));
    }


    // static int count = 0;
    // public static long numberOfPath(int n, int k, int [][]arr) {
    //     long ans = 0;
    //     ArrayList<Integer> alist = new ArrayList<>();
    //     help(arr, n, 0, 0, k,alist);
    //     System.out.println(count);
    //     ans = count;
    //     count = 0;
    //     return ans;
    // }
    // public static void help(int [][]arr,int n, int x ,int y,int k,ArrayList<Integer> alist){
    //     if(k<0 || x<0 || y<0 || x>=n || y>=n){
    //         return;
    //     }
    //     alist.add(arr[x][y]);
    //     k = k - arr[x][y];
    //     if(k==0 && x==n-1 && y==n-1){
    //         count++;
    //         System.out.println(alist);
    //         return;
    //     }
    //     help(arr, n, x+1, y, k,alist);
    //     help(arr, n, x, y+1, k,alist);
    //     alist.remove(alist.size()-1);
    // }


    public static long numberOfPath(int n, int k, int [][]arr) {
        int dp[][] = new int[n][n];
        int ans = help(arr, n, 0, 0, k,dp);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+"   ");
            }
            System.out.println();
        }
        return ans;
    }
    public static int help(int [][]arr,int n, int x ,int y,int k,int dp[][]){
        if(k<0 || x<0 || y<0 || x>=n || y>=n){
            return 0;
        }
        if(dp[x][y]!=0){
            return dp[x][y];
        }
        k = k - arr[x][y];
        if(k==0 && x==n-1 && y==n-1){
            return 1;
        }
        dp[x][y] = help(arr, n, x+1, y, k,dp) + help(arr, n, x, y+1, k,dp) ;
        return dp[x][y];
    }

    // public static long numberOfPath(int n, int k, int[][] arr) {
    //     int dp[][] = new int[n][n];
    //     int ans = help(arr, n, 0, 0, k, dp);
    //         for(int i=0;i<n;i++){
    //             for(int j=0;j<n;j++){
    //                 System.out.print(dp[i][j]+"   ");
    //             }
    //             System.out.println();
    //         }
    //     return ans;
    // }
    
    // public static int help(int[][] arr, int n, int x, int y, int k, int dp[][]) {
    //     if (k < 0 || x < 0 || y < 0 || x >= n || y >= n) {
    //         return 0;
    //     }
    //     if (dp[x][y] != 0) {
    //         return dp[x][y];
    //     }
    //     k = k - arr[x][y];
    //     if (k == 0 && x == n - 1 && y == n - 1) {
    //         return 1;
    //     }
    //     int downPaths = help(arr, n, x + 1, y, k, dp);
    //     int rightPaths = help(arr, n, x, y + 1, k, dp);
    //     dp[x][y] = downPaths + rightPaths;
    //     return dp[x][y];
    // }
    

    public static void main(String[] args) {
        System.out.println("    9-feb-2023");
        // int nums[] = {2, 3, 4, 6, 9, 12, 8};
        // System.out.println("Ans : " + largestDivisibleSubset(nums));
        int k = 12, n = 3;
        int arr[][] = {{1, 2, 3}, 
                       {4, 6, 5}, 
                       {3, 2, 1}};
        System.out.println("Ans : "+numberOfPath(n, k, arr));
    }
}

import java.util.ArrayList;

public class Con_21_Jan {
    public int minimumPushes(String word) {
        int ans = 0,n=word.length();
        if(n<=8){
            return n;
        }else if(n>8 && n<=16){
            return 8+(n-8)*2;
        }else if(n>16 && n<=24){
            return 24 + (n-16)*3;
        }
        return 48 + (n-24)*4;
    }

    public static int rob(int[] nums) {
        int max  = Integer.MIN_VALUE;
        int dp[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int ans = solve(nums, i, dp);
            max = Math.max(max, ans);
        }
        return max;
    }
    public static int solve(int arr[],int ind,int dp[]){
        if(dp[ind]!=0){
            return dp[ind];
        }
        if(ind==arr.length-1 || ind==arr.length-2){
            return arr[ind];
        }
        int max = 0;
        for(int i=ind+2;i<arr.length;i++){
            int ans = arr[ind] + solve(arr, i,dp);
            max = Math.max(max, ans);
        }
        dp[ind] = max;
        return max;
    }

    

    public static void main(String[] args) {
        System.out.println("    21-Jan-2024");
        
    }
}

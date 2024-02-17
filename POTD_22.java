import java.util.*;

public class POTD_22 {
    static int ans = 101;
    public static int numSquares(int n) {
        for(int i=1;i<101 && i<=n;i++){
            help(n, i, 0, 0);
        }
        System.out.println(ans);
        int a = ans;
        ans = 101;
        return a;
    }
    public static void help(int n, int num , int count, int sum) {
        if(sum>n){
            return;
        }
        if(sum==n){
            ans = Math.min(count, ans);
            return;
        }
        for(int i=num;i<101;i++){
            if(sum<n){
                help(n, i, count+1, sum + num*num);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("    Feb - 8 -2024");
        // System.out.println("Ans : "+numSquares(13));
        System.out.println("Ans : "+numSquares(10));
    }
}

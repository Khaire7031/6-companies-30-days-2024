
import java.util.*;

public class POTD_19 {
    public int[][] divideArray(int[] nums, int k) {
        int[][] ans = new int[nums.length/3][3];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(pq.size()>0){
            System.out.println(pq.remove(pq)+" : ");
        }
        int i = 0;
        while (pq.size()>0) {
            int num1 = pq.remove();
            int num2 = pq.remove();
            int num3 = pq.remove();
            
            if(num3-num1<=k){
                ans[i][0] = num1;
                ans[i][1] = num2;
                ans[i][2] = num3;
            }else{
                return new int[0][0];
            }
        }
        return ans;
    }
    public static int atoi(String s) {
        boolean neg = false;
        int multi = 1,ans = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch=='-' && i==0){
                neg = true;
            }else if(Character.isDigit(ch)){
                ans = ans + ( (int)(ch-'0') ) * multi;
                multi = multi*10;
            }else{
                return 1;
            }
        }
        if(neg){
            ans = -1 * ans;
        }
        System.out.println("Ans : "+ans);
	    return 0;
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> alist = new ArrayList<>();
        for(int i=1;i<10;i++){
            String str = "" + i;
            int j = i+1;
            // str +=j;
            while(Integer.parseInt(str)<=high && j<10){
                str +=j;
                j++;
                System.out.println(str+" :-> "+String.valueOf(str));
                if(Integer.parseInt(str)>=low && Integer.parseInt(str)<=high){
                    alist.add(Integer.parseInt(str));
                }
            }
            // System.out.println();
        }
        Collections.sort(alist);
        return alist;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int ans = 0;
        for(int i=0;i<arr.length-k;i++){
            int maxSum = 0;
            for(int j=i;j<i+k;j++){
                maxSum= Math.max(maxSum, arr[j]);
            }
            ans +=maxSum;
            System.out.println(ans);
        }
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println("        1-FEB-2024");
        System.out.println("Ans : "+sequentialDigits(100,300));
        // System.out.println("Ans : "+sequentialDigits(1000,13000));
        ArrayList<Integer> alist = new ArrayList<>();

        alist.add(5);
        System.out.println();
        alist.remove(alist.size()-1);
    }
}

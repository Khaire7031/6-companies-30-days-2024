
import java.util.*;
public class POTD_2 {
    public static List<List<Integer>> findMatrix(int[] arr) {
        List<List<Integer>> alist = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
            max = Math.max(max, map.get(arr[i]));
        }
        for(int i=0;i<max;i++){
            List<Integer> list = new ArrayList<>();
            alist.add(list);
        }
        for(int i: map.keySet()){
            int num = map.get(i);
            for(int j=0;j<num;j++){
                alist.get(j).add(i);
            }
        }

        return alist;
    }
    public long maxSumWithK(long arr[], long n, long k){
        long ans = 0;
        for(int i=0;i<arr.length;i++){
            long sum = Integer.MIN_VALUE,count = 0;
            for(int j=i;j<arr.length;j++){
                count++;
                sum+=arr[i];
                if(count>=k){
                    ans = Math.max(ans, sum);
                }
            }
        }
        

        return ans;
    }
    public static void main(String[] args) {
        System.out.println("    2-Jan");
        int arr[] = {1,3,4,1,2,3,1};
        System.out.println("Ans : "+findMatrix(arr));
    }
}

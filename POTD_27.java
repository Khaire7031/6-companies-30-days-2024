

import java.util.*;


public class POTD_27 {
    // public static int furthestBuilding(int[] heights, int bricks, int ladders) {
    //     int ans = 0;
    //     for(int i=1;i<heights.length;i++){
    //         if(heights[i]<=heights[i-1]){
    //             ans = i;
    //             continue;
    //         }else{
    //             if(bricks>=(heights[i]-heights[i-1])){
    //                 ans = i;
    //                 bricks = bricks - (heights[i]-heights[i-1]);
    //             }else if(ladders>0){
    //                 ans = i;
    //                 ladders--;
    //             }else{
    //                 return ans;
    //             }
    //         }
    //     }
    //     return ans;
    // }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < heights.length - 1; ++i) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0)
                pq.offer(-diff);

            if (pq.size() > ladders) {
                bricks += pq.poll();
            }

            if (bricks < 0)
                return i;
        }

        return heights.length - 1;
    }

    public boolean countSub(long arr[], long n) {
        return help(arr, n, 0);
    }
    
    public boolean help(long arr[], long n, int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        
        if (parent >= n || left >= n)
            return true;
        
        if ((right < n && arr[parent] >= arr[left] && arr[parent] >= arr[right]) || (right >= n && arr[parent] >= arr[left])) {
            return help(arr, n, left) && help(arr, n, right);
        }
        return false;
    }
    


    public static void main(String[] args) {
        System.out.println("        17-02-2024");
        int heights[] = {4,2,7,6,9,14,12}, bricks = 5, ladders = 1;

        System.out.println("Ans : "+furthestBuilding(heights, bricks, ladders));
    }
}

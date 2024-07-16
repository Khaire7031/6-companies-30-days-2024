
import java.util.*;


public class POTD_3 {
    public static int smallestSubstring(String str) {
        int i=0,j=0,n=str.length(),ans=Integer.MAX_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        while(i<n && j<n){
            while(j<n && map.size()<=3) {
                char ch = str.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                j++;
            }            
            
            while(map.size()==3){
                char ch = str.charAt(i);
                if(map.get(ch)>1){
                    map.put(ch,map.get(ch)-1);
                }else{
                    map.remove(ch); 
                }
                i++;
            }
            ans = Math.min(ans,j-i);
        }
        if(map.size()<3){
            return -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("        3-Jan");
        String str = "121012001201200";
        System.out.println("Ans : "+smallestSubstring(str));
    }
}

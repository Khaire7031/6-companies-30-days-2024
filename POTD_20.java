
import java.util.*;

public class POTD_20 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> alist = new ArrayList<>();
        ArrayList<HashMap<Character,Integer>> ll = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            String st = strs[i];
            HashMap<Character,Integer> map = new HashMap<>(); 
            for(int j=0;j<st.length();j++){
                char ch = st.charAt(j);
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
            ll.add(map);
        }
        System.out.println(ll);
        for(int i=0;i<ll.size();i++){
            
        }
        return alist;
    }
    public static void main(String[] args) {
        System.out.println("    6-FEB-2024");
        String [] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Ans : "+groupAnagrams(str));
    }
}

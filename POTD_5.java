import java.util.*;

public class POTD_5 {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> aList = new ArrayList<>();
        aList.add(new ArrayList<>());
        aList.add(new ArrayList<>());
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> lost = new HashMap<>();
        for(int i=0;i<matches.length;i++){
            set.add(matches[i][0]);
            lost.put(matches[i][1],lost.getOrDefault(matches[i][1], 0)+1);
        }
        for(int i : set){
            if(!lost.containsKey(i)){
                aList.get(0).add(i);
            }
        }
        for(int i : lost.keySet()){
            if(lost.get(i)==1){
                aList.get(1).add(i);
            }
        }
        Collections.sort(aList.get(0));
        Collections.sort(aList.get(1));
        return aList;
    }

    public static void main(String[] args) {
        System.out.println("Jan - 15");
    }
}

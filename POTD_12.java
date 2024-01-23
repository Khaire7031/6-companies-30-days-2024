import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class POTD_12 {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> aList) {
        int arr[] = new int[n];
        ArrayList<ArrayList <Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<m;i++){
            int start = aList.get(i).get(0);
            int end = aList.get(i).get(1);
            set.add(start);
            set.add(end);
            graph.get(start).add(end);
        }
        if(set.size()!=n){
            return new int[0];
        }
        System.out.println(graph);
        boolean visited[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                help(graph, i, st, visited);
            }
        }
        System.out.println("Stack : "+st);
        if(st.size()<n){
            return new int[0];
        }
        int index = n-1;
        while(!st.isEmpty()){
            arr[index--] = st.pop();
        }
        return arr;
    }

    static void help(ArrayList<ArrayList<Integer>> graph, int curr, Stack<Integer> st, boolean visited[]) {
        visited[curr] = true;
        for (int i : graph.get(curr)) {
            if (!visited[i]) {
                help(graph, i, st, visited);
            }
        }
        st.push(curr);
    }
    
    public static void main(String[] args) {
        System.out.println("    23-Jan-2023");
        ArrayList<ArrayList<Integer>> prerequisitesList = new ArrayList<>();

        // int n = 2, m = 1;
        // prerequisitesList.add(new ArrayList<>(List.of(1, 0)));

        // int n = 4, m = 4;
        // prerequisitesList.add(new ArrayList<>(List.of(1, 0)));
        // prerequisitesList.add(new ArrayList<>(List.of(2, 0)));
        // prerequisitesList.add(new ArrayList<>(List.of(3, 1)));
        // prerequisitesList.add(new ArrayList<>(List.of(3, 2)));

        int n = 4, m = 2;
        
        prerequisitesList.add(new ArrayList<>(List.of(3, 3)));
        prerequisitesList.add(new ArrayList<>(List.of(1, 1)));

        int[] result = findOrder(n, m, prerequisitesList);
        System.out.println(Arrays.toString(result));
    }
}

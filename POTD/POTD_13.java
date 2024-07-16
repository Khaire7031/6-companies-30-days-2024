
import java.util.*;

public class POTD_13 {
    public static boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = edges.get(i).get(0);
            int end = edges.get(i).get(1);
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // System.out.println(graph);
        boolean[] visited = new boolean[n];
        // System.out.println("Is Tree: " + help(graph, 0, -1, visited));
        return help(graph, 0, -1, visited);
    }

    public static boolean help(ArrayList<ArrayList<Integer>> graph, int start, int parent, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) {
                if (help(graph, next, start, visited)) {
                    return true; 
                }
            } else if (next != parent) {
                return true; 
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("    24-Jan-2024");
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(1, 3)));
        // edges.add(new ArrayList<>(List.of(2, 0)));

        System.out.println("Ans : "+isTree(4, 3, edges));
    }
}

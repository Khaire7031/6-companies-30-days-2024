import java.util.*;

public class POTD_47 {

    public static void printGraph(HashMap<Character, ArrayList<Node>> graph) {
        for (char ch : graph.keySet()) {
            ArrayList<Node> alist = graph.get(ch);
            for (Node node : alist) {
                System.out.println(node.source + " : " + node.destination + " : " + node.weight);
            }
            System.out.println("-----------------------------------");
        }
    }

    static class Node {
        char source;
        char destination;
        int weight;

        Node(char s, char d, int w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }

    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        HashSet<Character> set = new HashSet<>();

        // Get All Charactor
        for (int i = 0; i < original.length; i++) {
            set.add(original[i]);
            set.add(changed[i]);
        }

        // Intialize the distance Matrix

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("2976. Minimum Cost to Convert String I");
        String source = "abcd";
        String target = "acbe";
        char[] original = { 'a', 'b', 'c', 'c', 'e', 'd' };
        char[] changed = { 'b', 'c', 'b', 'e', 'b', 'e' };

        int[] cost = { 2, 5, 5, 1, 2, 20 };
        System.out.println("Ans : " + minimumCost(source, target, original, changed, cost));
    }
}

// import java.util.*;

// public class POTD_47 {

// public static void printGraph(HashMap<Character, ArrayList<Node>> graph) {
// for (char ch : graph.keySet()) {
// ArrayList<Node> alist = graph.get(ch);
// for (Node node : alist) {
// System.out.println(node.source + " : " + node.destination + " : " +
// node.weight);
// }
// System.out.println("-----------------------------------");
// }
// }

// static class Node implements Comparable<Node> {
// char source;
// char destination;
// int weight;

// Node(char s, char d, int w) {
// this.source = s;
// this.destination = d;
// this.weight = w;
// }

// @Override
// public int compareTo(Node o) {
// return this.weight - o.weight;
// }
// }

// public static long minimumCost(String source, String target, char[] original,
// char[] changed, int[] cost) {
// int n = original.length;

// // Create Graph
// HashMap<Character, ArrayList<Node>> graph = new HashMap<>();

// // Initialize the graph
// for (int i = 0; i < n; i++) {
// char sourceNode = original[i];
// graph.putIfAbsent(sourceNode, new ArrayList<>());
// }

// // Add Edges and weight in graph
// for (int i = 0; i < n; i++) {
// char sourceNode = original[i];
// char destination = changed[i];
// int weight = cost[i];

// Node graphNode = new Node(sourceNode, destination, weight);
// System.out.println(sourceNode + " : " + destination + " : " + weight);

// graph.get(sourceNode).add(graphNode);
// }

// // Actual Logic to convert source to destination
// long totalCost = 0;
// // for (int i = 0; i < source.length(); i++) {
// // char ch1 = source.charAt(i);
// // char ch2 = target.charAt(i);

// // if (ch1 != ch2) {
// // int minDist = getMinimumDistance(graph, ch1, ch2);
// // if (minDist == Integer.MAX_VALUE) {
// // return -1; // Impossible transformation
// // }
// // totalCost += minDist;
// // }
// // }

// totalCost = getMinimumDistance(graph, 'a', 'e');
// System.out.println("Total : " + totalCost);
// return totalCost;
// }

// // Find minimum distance between two nodes using Dijkstra's algorithm
// public static int getMinimumDistance(HashMap<Character, ArrayList<Node>>
// graph, char start, char end) {
// PriorityQueue<Node> pq = new PriorityQueue<>();
// Map<Character, Integer> distances = new HashMap<>();
// Set<Character> visited = new HashSet<>();

// for (char node : graph.keySet()) {
// distances.put(node, Integer.MAX_VALUE);
// }

// pq.add(new Node(start, start, 0));
// distances.put(start, 0);

// while (!pq.isEmpty()) {
// Node current = pq.remove();
// if (!visited.contains(current.destination)) {
// visited.add(current.destination);

// ArrayList<Node> neighborList = graph.getOrDefault(current.destination, new
// ArrayList<>());

// for (Node neighbor : graph.getOrDefault(current.destination, new
// ArrayList<>())) {
// if (visited.contains(neighbor.destination))
// continue;

// int newDist = distances.get(current.destination) + neighbor.weight;
// if (newDist < distances.get(neighbor.destination)) {
// distances.put(neighbor.destination, newDist);
// pq.add(new Node(neighbor.source, neighbor.destination, newDist));
// }
// }
// }
// }

// return distances.getOrDefault(end, Integer.MAX_VALUE);
// }

// public static void main(String[] args) {
// System.out.println("2976. Minimum Cost to Convert String I");
// String source = "abcd";
// String target = "acbe";
// char[] original = { 'a', 'b', 'c', 'c', 'e', 'd' };
// char[] changed = { 'b', 'c', 'b', 'e', 'b', 'e' };

// int[] cost = { 2, 5, 5, 1, 2, 20 };
// System.out.println("Ans : " + minimumCost(source, target, original, changed,
// cost));
// }
// }

// import java.util.*;

// public class POTD_11 {
//     static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> aList){
//         int arr[] = new int[n];
//         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             graph.add(new ArrayList<>());
//         }
//         for(int i=0;i<n;i++){
//             int start = aList.get(i).get(0);
//             int end = aList.get(i).get(1);
//             graph.get(start).add(end);
//         }
//         Stack<Integer> st = new Stack<>();
//         boolean visited[]= new boolean[n];
//         help(aList, m, st, visited);
//         System.out.println(st);
//         return arr;
//     }
//     static void help(ArrayList<ArrayList<Integer>> aList,int curr,Stack<Integer> st,boolean visited[]){
//         visited[curr] = true;
//         System.out.println(st);
//         for(int i=0;i<aList.get(curr).size();i++){
//             int next = aList.get(curr).get(i);
//             if(!visited[next]){
//                 help(aList, next, st, visited);
//             }
//         }
//         st.push(curr);
//     }
//     public static void main(String[] args) {
//         System.out.println("    23-Jan-2023");
//         int n = 4, m = 4;
//         ArrayList<ArrayList<Integer>> prerequisitesList = new ArrayList<>();

//         prerequisitesList.add(new ArrayList<>(List.of(1, 0)));
//         prerequisitesList.add(new ArrayList<>(List.of(2, 0)));
//         prerequisitesList.add(new ArrayList<>(List.of(3, 1)));
//         prerequisitesList.add(new ArrayList<>(List.of(3, 2)));

//         findOrder(n, m,prerequisitesList);
//     }
// }


import java.util.*;

public class POTD_11 {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> aList) {
        int arr[] = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int start = aList.get(i).get(0);
            int end = aList.get(i).get(1);
            set.add(start);
            set.add(end);
            graph.get(start).add(end);
        }
        if (set.size() < n) {
            System.out.println("No Ordering Possible");
            return arr;
        }
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                help(graph, i, st, visited);
            }
        }

        if (st.isEmpty()) {
            System.out.println("No Ordering Possible");
            return arr;
        }

        int index = n - 1;
        while (!st.isEmpty()) {
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

    static int maxLength = 0;
    public static int maxLength(List<String> arr) {
        HashSet<Character> set = new HashSet<>();
        help(arr,set, "", 0);
        // System.out.println("Str : ");
        int ans = maxLength;
        return ans;
    }
    public static void help(List<String> arr, HashSet<Character> ss ,String str,int start){
        for(int i=start;i<arr.size();i++){
            String st = arr.get(i);
            boolean con = true;
            for(int j=0;j<st.length();j++){
                char ch = st.charAt(j);
                if(str.indexOf(Character.toString(ch))!=-1 || (st.indexOf(ch)!=-1 && j!=st.indexOf(ch))){
                    con = false;
                    break;
                }
            }
            if(con){
                help(arr, ss, str+st, i+1);
            }
        }
        maxLength = Math.max(maxLength, str.length());
        // System.out.println("Str : "+str);
    }

    

    public static void main(String[] args) {
        System.out.println("    23-Jan-2023");
        int n = 1, m = 0;
        ArrayList<ArrayList<Integer>> prerequisitesList = new ArrayList<>();
        prerequisitesList.add(new ArrayList<>(List.of(1, 0)));
        int[] result = findOrder(n, m, prerequisitesList);
        System.out.println(Arrays.toString(result));

        // List<String> arr = new ArrayList<>();
        // // arr.add("un");
        // // arr.add("iq");//["a", "abc", "d", "de", "def"]
        // // arr.add("ue");

        // // arr.add("a");
        // // arr.add("abc");
        // // arr.add("d");
        // // arr.add("de");
        // // arr.add("def");

        // arr.add("aa");
        // arr.add("bb");
        // System.out.println("Ans : "+maxLength(arr));

    }
}


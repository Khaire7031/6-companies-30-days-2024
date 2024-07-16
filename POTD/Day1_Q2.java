
/*
 

    You are given a 2D 0-indexed array of strings, access_times, with size n. For each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an employee, and access_times[i][1] represents the access time of that employee. All entries in access_times are within the same day.

    The access time is represented as four digits using a 24-hour time format, for example, "0800" or "2250".

    An employee is said to be high-access if he has accessed the system three or more times within a one-hour period.

    Times with exactly one hour of difference are not considered part of the same one-hour period. For example, "0815" and "0915" are not part of the same one-hour period.

    Access times at the start and end of the day are not counted within the same one-hour period. For example, "0005" and "2350" are not part of the same one-hour period.

    Return a list that contains the names of high-access employees with any order you want.



*/

import java.util.*;

public class Day1_Q2 {
    public static List<String> findHighAccessEmployees(List<List<String>> alist) {
        List<String> ans = new ArrayList<>();
        Collections.sort(alist, Comparator.comparing(list -> list.get(0)));
        System.out.println(alist);
        int i = 0,j=0,n = alist.size();
        while(j<n && i<n){
            int count = 1;
            int max  = Integer.MIN_VALUE;
            int min  = Integer.MAX_VALUE;
            while(j<n && alist.get(i).get(0).equals(alist.get(j).get(0)) && Math.abs(max-min)<100){
                int num = Integer.parseInt(alist.get(j).get(1));

                if(Math.abs(num-min)<100 && Math.abs(max-min)<100 && Math.abs(num-max)<100){
                    count++;
                }
                max = Math.max(max, num);
                min = Math.min(min, num);
                j++;
            }
            System.out.println("Max : "+max+" --    Min : "+min+"  }} count : "+count);
            if(count>=3){
                // System.out.println("-----------");
                ans.add(alist.get(i).get(0));
            }
            i=j;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("    Question 2");
        List<List<String>> alist = new ArrayList<>();
        // alist.add(List.of("cd", "1025"));
        // alist.add(List.of("ab", "1025"));
        // alist.add(List.of("cd", "1046"));
        // alist.add(List.of("cd", "1055"));
        // alist.add(List.of("ab", "1124"));
        // alist.add(List.of("ab", "1120"));

        // alist.add(List.of("a", "0549"));
        // alist.add(List.of("b", "0457"));
        // alist.add(List.of("a", "0532"));
        // alist.add(List.of("a", "0621"));
        // alist.add(List.of("b", "0540"));

        alist.add(List.of("d", "0002"));
        alist.add(List.of("c", "0808"));
        alist.add(List.of("c", "0829"));
        alist.add(List.of("e", "0215"));
        alist.add(List.of("d", "1508"));
        alist.add(List.of("d", "1444"));
        alist.add(List.of("d", "1410"));
        alist.add(List.of("c", "0809"));

        System.out.println("Ans : "+findHighAccessEmployees(alist));

    }
}

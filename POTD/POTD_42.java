
public class POTD_42 {

    public static int help(int n, int m, int mat[][], int x, int y) {

        if (x >= n || y >= m) {
            return 0;
        }
        if (mat[x][y] == 0) {
            return 0;
        }
        int p = help(n, m, mat, x + 1, y);
        int q = help(n, m, mat, x, y + 1);
        int r = help(n, m, mat, x + 1, y + 1);
        if (p == q && q == r) {
            return p + 1;
        } else {
            return 0;
        }
        // else if (p != 0 && q != 0 && r != 0) {
        // return 1;
        // }
    }

    public static int maxSquare(int n, int m, int mat[][]) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    int ans = help(n, m, mat, i, j);
                    System.out.println(i + " : " + j + " -> " + ans);
                    max = Math.max(max, ans);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("    Day 42");
        int n = 6, m = 5;
        int mat[][] = {
                { 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 } };

        System.out.println("Ans : " + maxSquare(n, m, mat));
    }
}

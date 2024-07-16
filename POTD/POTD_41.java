public class POTD_41 {
    public static boolean isToepliz(int mat[][]) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int num1 = mat[i][j];
                int num2 = mat[i + 1][j + 1];
                if (num1 != num2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("27-06-2024");
        // int mat[][] = { { 6, 7, 8 },
        // { 4, 6, 7 },
        // { 2, 4, 6 } };

        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 } };
        System.out.println("Ans : " + isToepliz(mat));
    }
}

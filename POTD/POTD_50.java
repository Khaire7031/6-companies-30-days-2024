import java.util.HashSet;

public class POTD_50 {
    public static int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row < 3 || col < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (help(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean help(int i, int j, int grid[][]) {
        HashSet<Integer> set = new HashSet<>();
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (grid[x][y] < 1 && grid[x][y] > 9) {
                    return false;
                }
                set.add(grid[x][y]);
            }
        }

        // Row Sum
        int rowSum1 = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1];
        int rowSum2 = grid[i][j - 1] + grid[i][j] + grid[i][j + 1];
        int rowSum3 = grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];

        // Column sum
        int colSum1 = grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1];
        int colSum2 = grid[i - 1][j] + grid[i][j] + grid[i + 1][j];
        int colSum3 = grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1];
        // Diagonal sum
        int leftDiagonal = grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1];
        int rightDiagonal = grid[i + 1][j - 1] + grid[i][j] + grid[i - 1][j + 1];

        System.out.println(rowSum1 + " : " + rowSum2 + " : " + rowSum3);
        System.out.println(colSum1 + " : " + colSum2 + " : " + colSum3);
        System.out.println(leftDiagonal + " : " + rightDiagonal);

        System.out.println("=======");
        return set.size() == 9 && colSum1 == 15 && colSum2 == 15 && colSum3 == 15 && rowSum1 == 15 && rowSum2 == 15
                && rowSum3 == 15 && leftDiagonal == 15 && rightDiagonal == 15;
    }

    public static void main(String[] args) {
        System.out.println("Magic Squares In Grid");
        // int grid[][] = { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } };
        int grid[][] = { { 2, 7, 6 }, { 1, 5, 9 }, { 4, 3, 8 } };

        System.out.println("Ans : " + numMagicSquaresInside(grid));
    }
}

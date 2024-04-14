public class NQuenn {

    public static void nQueens(int[][] chess, int row, String asf) {
        if (row == chess.length) {
            asf += '.';
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            if (isItSafe(chess, row, i) == true) {
                chess[row][i] = 1;
                nQueens(chess, row + 1, asf + "," + row + "-" + i);
                chess[row][i] = 0;
            }
        }
    }

    public static boolean isItSafe(int[][] chess, int r, int c) {

        for (int i = r - 1, j = c; i >= 0; i--) {
            if (chess[i][j] == 1)
                return false;
        }

        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;
        }

        for (int i = r - 1, j = c + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];
        nQueens(chess, 0, "");
    }
}

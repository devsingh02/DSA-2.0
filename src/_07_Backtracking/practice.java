package _07_Backtracking;

public class practice { //horse
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        knights(board, 0, 0, n);
        System.out.println("Total no. of possible ways of placing knights = " );
    }

    // imagine as for{for{}} 
    static void knights(boolean[][] board, int row, int col, int target) {
        if (target == 0) {
            display(board);
            return;
        }
        int len = board.length;
        if (row == len-1 && col == len) return; //no sol
        if (col == len) {
            knights(board, row+1, 0, target);
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knights(board, row, col+1, target-1);
            board[row][col] = false;
        }
        knights(board, row, col+1, target);
        return;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row-2, col-1) && board[row-2][col-1]) return false;
        if (isValid(board, row-2, col+1) && board[row-2][col+1]) return false;
        if (isValid(board, row-1, col-2) && board[row-1][col-2]) return false;
        if (isValid(board, row-1, col+2) && board[row-1][col+2]) return false;
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        if (row < board.length && row >= 0 && col < board[0].length && col >= 0) return true;
        return false;
    }
    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) System.out.print("K ");
                else System.out.print("O ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

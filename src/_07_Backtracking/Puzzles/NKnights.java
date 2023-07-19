package _07_Backtracking.Puzzles;

public class NKnights { //horse
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        System.out.println("Total no. of possible ways of placing knights = " + knights(board, 0, 0, n));
    }

    // imagine as for{for{}} 
    static int knights(boolean[][] board, int row, int col, int targets) {
        if (targets == 0) {
            display(board);
            return 1;
        }
        int count = 0;

        //BOUNDARIES
        if (row == board.length-1 && col == board.length) return 0; //no soln. (reached end of board & target not yet 0)
        if (col == board.length) {
            count += knights(board, row+1, 0, targets); //i++ (next row)
            return count;   // earlier had ""
        }
        //PUT
        if (isSafe(board, row, col)) {  // normal position
            board[row][col] = true;
            count += knights(board, row, col+1, targets-1);  //ans. with this setup
            board[row][col] = false;
        }
        //BOUNDARIES
        count += knights(board, row, col+1, targets); // j++ (next col)
        return count;
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
                else System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

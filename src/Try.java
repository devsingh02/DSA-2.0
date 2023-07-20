import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Try {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    static List<List<String>> solveNQueens(int n) {
        // Initialize the chess board with empty cells represented by '.'
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        // Initialize lists to store the solutions
        List<List<String>> res = new ArrayList<>();
        // Initialize arrays to keep track of used columns and diagonals
        int[] usedCols = new int[n];  //default All = 0
        int[] usedRightDiagonal = new int[2 * n - 1];
        int[] usedLeftDiagonal = new int[2 * n - 1];
        // Call the recursive solve method
        solve(0, board, res, usedCols, usedRightDiagonal, usedLeftDiagonal);
        // Return the solutions
        return res;
    }
    // Recursive function to solve the N-Queens problem
    static void solve(int row, char[][] board, List<List<String>> res, int[] usedCols, int[] usedRightDiagonal, int[] usedLeftDiagonal){
        // If all rows are filled with queens, add the solution to the list and return
        if (row == board.length){
            res.add(construct(board));
            return;
        }
        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++){
            // Check if the current cell is safe for a queen
            if(usedCols[col] == 0 && usedRightDiagonal[col + row] == 0 && usedLeftDiagonal[board.length - 1 + row - col] == 0){
                // Place the queen in the current cell
                board[row][col] = 'Q';
                // Mark the used column and diagonals
                usedCols[col] = 1;
                usedRightDiagonal[col + row] = 1;
                usedLeftDiagonal[board.length - 1 + row - col] = 1;
                // Recursively solve for the next row
                solve(row + 1, board, res, usedCols, usedRightDiagonal, usedLeftDiagonal);
                // Remove the queen from the current cell
                board[row][col] = '.';
                // Unmark the used column and diagonals
                usedCols[col] = 0;
                usedRightDiagonal[col + row] = 0;
                usedLeftDiagonal[board.length - 1 + row - col] = 0;
            }
        }
    }
    // Helper function to construct a list of strings representing the chess board
    static List<String> construct(char board[][]){
        List<String> res = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}

//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//class Try {
//    public static void main(String[] args) {
//        System.out.println(solveNQueens(4));
//    }
//
//    static List<List<String>> solveNQueens(int n) {
//        // Initialize the chess board with empty cells represented by '.'
//        char[][] board = new char[n][n];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                board[i][j] = '.';
//            }
//        }
//        // Initialize lists to store the solutions
//        List<List<String>> res = new ArrayList<>();
//        // Initialize arrays to keep track of used rows and diagonals
//        int[] usedRows = new int[n];
//        int[] usedRightDiagonal = new int[2 * n - 1];
//        int[] usedLeftDiagonal = new int[2 * n - 1];
//        // Call the recursive solve method
//        solve(0, board, res, usedRows, usedRightDiagonal, usedLeftDiagonal);
//        // Return the solutions
//        return res;
//    }
//
//    // Recursive function to solve the N-Queens problem
//    static void solve(int col, char[][] board, List<List<String>> res, int[] usedRows, int[] usedRightDiagonal, int[] usedLeftDiagonal){
//        // If all columns are filled with queens, add the solution to the list and return
//        if (col == board.length){
//            res.add(construct(board));
//            return;
//        }
//        // Try placing a queen in each row of the current column
//        for (int row = 0; row < board.length; row++){
//            // Check if the current cell is safe for a queen
//            if(usedRows[row] == 0 && usedRightDiagonal[row + col] == 0 && usedLeftDiagonal[board.length - 1 + col - row] == 0){
//                // Place the queen in the current cell
//                board[row][col] = 'Q';
//                // Mark the used row and diagonals
//                usedRows[row] = 1;
//                usedRightDiagonal[row + col] = 1;
//                usedLeftDiagonal[board.length - 1 + col - row] = 1;
//                // Recursively solve for the next column
//                solve(col + 1, board, res, usedRows, usedRightDiagonal, usedLeftDiagonal);
//                // Remove the queen from the current cell
//                board[row][col] = '.';
//                // Unmark the used row and diagonals
//                usedRows[row] = 0;
//                usedRightDiagonal[row + col] = 0;
//                usedLeftDiagonal[board.length - 1 + col - row] = 0;
//            }
//        }
//    }
//    // Helper function to construct a list of strings representing the chess board
//    static List<String> construct(char board[][]){
//        List<String> res = new LinkedList<>();
//        for(int i = 0; i < board.length; i++){
//            String s = new String(board[i]);
//            res.add(s);
//        }
//        return res;
//    }
//}


import java.util.ArrayList;
import java.util.List;

class Try {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    static List<List<String>> solveNQueens(int n) {
        // Constructing all TOOLS necessary
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        int[] usedCols = new int[n];    // 1 if Q present
        int[] usedLeftDiagonals = new int[2*n - 1];
        int[] usedRightDiagonals = new int[2*n - 1];

        solve(0, board, usedCols, usedLeftDiagonals, usedRightDiagonals, result);
        return result;
    }
    static void solve(int row, char[][] board, int[] usedCols, int[] usedLeftDiagonals, int[] usedRightDiagonals, List<List<String>> result) {
        if (row == board.length) {
            result.add(new ArrayList<>(arrayToList(board)));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            // Put if Safe
            if (usedCols[col] == 0 && usedLeftDiagonals[board.length - 1 - row + col] == 0 && usedRightDiagonals[row + col] == 0) {
                board[row][col] = 'Q';
                usedCols[col] = 1;
                usedLeftDiagonals[board.length - 1 - row + col] = 1;
                usedRightDiagonals[row + col] = 1;
                solve(row + 1, board, usedCols, usedLeftDiagonals, usedRightDiagonals, result); // all updated
                //backtrack
                board[row][col] = '.';
                usedCols[col] = 0;
                usedLeftDiagonals[board.length - 1 - row + col] = 0;
                usedRightDiagonals[row + col] = 0;
            }
        }
    }

    static List<String> arrayToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = "";
            for (int j = 0; j < board.length; j++) {
                row += board[i][j];
            }
            list.add(row);
        }
        return list;
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
//        // Initialize arrays to keep track of used columns and diagonals
//        int[] usedCols = new int[n];  //default All = 0
//        int[] usedRightDiagonal = new int[2*n - 1];
//        int[] usedLeftDiagonal = new int[2*n - 1];
//        // Call the recursive solve method
//        solve(0, board, res, usedCols, usedRightDiagonal, usedLeftDiagonal);
//        // Return the solutions
//        return res;
//    }
//    // Recursive function to solve the N-Queens problem
//    static void solve(int row, char[][] board, List<List<String>> res, int[] usedCols, int[] usedRightDiagonal, int[] usedLeftDiagonal){
//        // If all rows are filled with queens, add the solution to the list and return
//        if (row == board.length){
//            res.add(construct(board));
//            return;
//        }
//        // Try placing a queen in each column of the current row
//        for (int col = 0; col < board.length; col++){
//            // Check if the current cell is safe for a queen
//            if(usedCols[col] == 0 && usedRightDiagonal[row + col] == 0 && usedLeftDiagonal[board.length - 1 - row + col] == 0){
//                // Place the queen in the current cell
//                board[row][col] = 'Q';
//                // Mark the used column and diagonals
//                usedCols[col] = 1;
//                usedRightDiagonal[col + row] = 1;
//                usedLeftDiagonal[board.length - 1 - row + col] = 1;
//                // Recursively solve for the next row
//                solve(row + 1, board, res, usedCols, usedRightDiagonal, usedLeftDiagonal);
//                // Remove the queen from the current cell && Unmark the used column and diagonals
//                board[row][col] = '.';
//                usedCols[col] = 0;
//                usedRightDiagonal[col + row] = 0;
//                usedLeftDiagonal[board.length - 1 - row + col] = 0;
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
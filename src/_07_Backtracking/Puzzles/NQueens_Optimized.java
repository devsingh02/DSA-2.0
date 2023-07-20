package _07_Backtracking.Puzzles;

import java.util.ArrayList;
import java.util.List;

class NQueens_Optimized {
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

/*

IMPORTANT POINTS :-
-------------------------------------
No. of diagonals   -> 2*n - 1
usedCols           -> j
usedLeftDiagonals  -> n - 1 - i + j
usedRightDiagonals -> i + j
-------------------------------------

 */
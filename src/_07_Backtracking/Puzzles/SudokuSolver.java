package _07_Backtracking.Puzzles;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{    // 0 means empty space
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if (solve(board)) display(board);
        else System.out.println("Cannot Solve.");
    }

    static boolean solve(int[][] board) {   //true -> solved
        int row = -1, col = -1;
        int n = board.length;
        boolean leftEmpty = false;
        // find an empty space
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i; col = j;
                    leftEmpty = true;
                    break;  //stop 
                }
            }
            if (leftEmpty == true) break; //stop at that index first
        }
        if (leftEmpty == false) return true;    //no empty space
        //BACKTRACK
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) return true; //sudoku is solved with this input
                else board[row][col] = 0; //backtrack
            }
        }
        return false;   // if isSafe == false for any number : can't solve -> return false
    }

    static boolean isSafe(int[][] board, int row, int col, int number) { //false -> not Safe
        //is number unique in row
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == number) return false;
        }
        //in col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == number) return false;
        }
        //in block [1-9]
        int sqrt = (int)Math.sqrt(board.length);    //sudoku(9X9) divided in 3s
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == number) return false;
            }
        }

        return true; // if non above true
    }

    static void display(int[][] board) {
        System.out.println();

        int n = board.length;
        int skipR = 0;
        for (int i = 0; i < n + 2; i++) { // 2 divisions
            if (i == 3 || i == 7) {
                    System.out.print("---------------------\n");
                    skipR++;
                    continue;
                }
            int skipC = 0;
            for (int j = 0; j < n + 2; j++) {
                if (j == 3 || j == 7) {
                    System.out.print("| ");
                    skipC++;
                    continue;
                }
                System.out.print(board[i-skipR][j-skipC] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
}


/*
METHOD 2 : 
class Solution {
    public static void main(String[] args) {
        char[][] input = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] output = solveSudoku(input);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] solveSudoku(char[][] board) {
        solve(board, 0, 0);
        return board;
    }
    static boolean solve(char[][] board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return solve(board, row + 1, 0);
        if (board[row][col] != '.') return solve(board, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, num, row, col)) {
                board[row][col] = num;
                if (solve(board, row, col + 1)) return true; // if board can be solved filling this place
            }
        }
        board[row][col] = '.';
        return false; // no number able to put
    }

    static boolean isValid(char[][] board, char num, int row, int col) {
        // col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }
        // row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }
        // 3x3 Box
        int sqrt = (int)Math.sqrt(9);
        int startC = col - col%sqrt;
        int startR = row - row%sqrt;
        for (int i = startR; i < startR + sqrt; i++) {
            for (int j = startC; j < startC + sqrt; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}
 */
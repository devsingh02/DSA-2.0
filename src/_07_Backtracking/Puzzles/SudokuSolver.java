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
        return false;   // if isSafe == false, can't solve -> return false
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

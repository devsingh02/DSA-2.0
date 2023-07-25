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
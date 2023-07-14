package _07_Backtracking.Puzzles;

class NQueens {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println("Total no. of possible ways of placing queens = " + queens(board, 0));
    }

    // returns count(no. of possible ways of placing queens) + places queens
    static int queens(boolean[][] board, int row) { // traversing rows
        if (row == board.length) {  // reached end + 1 -> successfully placed all queens before
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {   //traversing cols
            if (isSafe(board, row, col)) {
                board[row][col] = true; //queen placed, now next row
                count += queens(board, row+1);  //next recursive call
                board[row][col] = false; //for checking for next col in same row
            }
        }
        return count; //returns 0 if none safe place found in that row
    }

    static boolean isSafe(boolean[][] board, int row, int col) { //  \,|,/  (upwards) check
        //check vertically upwards
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        
        //Left-Diagonal
        int maxLeft = Math.min(row, col); //these times I have to subtract to make either row or col = 0
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]) return false;
        }

        //Right-Diagonal
        int maxRight = Math.min(row, board.length-1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row-i][col+i]) return false;
        }

        return true;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }
}

/* NO FOR LOOPS :-

static int queens(boolean[][] board, int row, int col, int target) { // traversing rows
        if (target == 0) {
            display(board);
            return 1;
        }
        int count = 0;

        if (row == board.length-1 && col == board[0].length) return 0; //reached last and target not yet 0;
        if (col == board[0].length) {   //next row
            count += queens(board, row+1, 0, target);
            return count;
        }
        if (isSafe(board, row, col)) {  //normal position
            board[row][col] = true;
            count += queens(board, row, col+1, target-1);
            board[row][col] = false;
        }
        count+= queens(board, row, col+1, target); //next col
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) { // \,|,/ (upwards) check
        // Vertical up
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        
        //Left-Diagonal
        int maxLeft = Math.min(row, col); //these times I have to subtract to make either row or col = 0
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]) return false;
        }

        //Right-Diagonal
        int maxRight = Math.min(row, board.length-1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row-i][col+i]) return false;
        }

        //Horizontal Left
        for (int i = 0; i < col; i++) {
            if (board[row][i]) return false;
        }
        return true;
    }

*/
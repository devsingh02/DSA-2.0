package _12_DP.Basics._02_GridTraveler;

public class Tabulation {
    public static void main(String[] args) {
        System.out.println(gridTraveler(3,4));    //total paths possible DOWN | RIGHT
        System.out.println(gridTraveler(5,9));
        System.out.println(gridTraveler(18,18));
    }
    static long gridTraveler(int m, int n) {
        long[][] table = new long[m+1][n+1];
        table[1][1] = 1; // base case -> gT(1,1) return 1; //path found

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                long curr = table[i][j];
                if (j + 1 <= n) table[i][j + 1] += curr; // RIGHT
                if (i + 1 <= m) table[i + 1][j] += curr; // DOWN
            }
        }
        return table[m][n];
    }
}

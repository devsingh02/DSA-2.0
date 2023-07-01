package _12_DP.Basics._02_GridTraveler;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println(gridTraveler(3,4));    //total paths possible DOWN | RIGHT
        System.out.println(gridTraveler(18,18));    //total paths possible DOWN | RIGHT
    }

    static long gridTraveler(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveler(m-1, n) + gridTraveler(m, n-1);
    }
}

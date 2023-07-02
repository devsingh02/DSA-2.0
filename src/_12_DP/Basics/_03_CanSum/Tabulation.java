package _12_DP.Basics._03_CanSum;

public class Tabulation {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] {4,3}));
        System.out.println(canSum(8, new int[] {2,3,5}));
        System.out.println(canSum(300, new int[] {7,14}));
    }
    static boolean canSum(int target, int[] arr) {
        boolean[] table = new boolean[target + 1];  //default -> false
        table[0] = true;
        for (int i = 0; i <= target; i++) {
            if (!table[i]) continue;    //if False then do nothing
            for (int num : arr) if (i + num <= target) table[i + num] = true;
        }
        return table[target];
    }
}

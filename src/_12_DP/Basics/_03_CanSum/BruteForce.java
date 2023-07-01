package _12_DP.Basics._03_CanSum;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] {4,3}));
        System.out.println(canSum(8, new int[] {2,3,5}));
        System.out.println(canSum(300, new int[] {7,14}));
    }
    static boolean canSum(int target, int[] arr) {
        if (target == 0) return true;
        if (target < 0) return false;
        for (int num : arr) {
            if (canSum(target - num, arr)) return true;
        }
        return false;
    }
}

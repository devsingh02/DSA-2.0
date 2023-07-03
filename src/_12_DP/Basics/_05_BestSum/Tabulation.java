package _12_DP.Basics._05_BestSum;

import java.util.ArrayList;
import java.util.List;

public class Tabulation {
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] {4,3}));
        System.out.println(bestSum(8, new int[] {2,3,5}));
        System.out.println(bestSum(300, new int[] {7,14}));
        System.out.println(bestSum(100, new int[] {1,2,5,25}));
    }
    static List<Integer> bestSum(int target, int[] arr) {
        List<List<Integer>> table = new ArrayList<>(target + 1);
        for (int i = 0; i <= target; i++) table.add(null);
        table.set(0, new ArrayList<>());    //[ [] , null , .....]

        for (int i = 0; i <= target; i++) {
            if (table.get(i) == null) continue;

            for (int num : arr) {
                if (i + num <= target) {
                    List<Integer> curr = new ArrayList<>(table.get(i));
                    curr.add(num);
                    List<Integer> next = table.get(i + num); // don't update upd (call by reference)
                    if (next == null || next.size() > curr.size()) table.set(i + num, curr);
                }
            }
        }
        return table.get(target);
    }
}

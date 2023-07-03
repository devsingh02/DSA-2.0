package _12_DP.Basics._04_HowSum;

import java.util.List;
import java.util.ArrayList;

public class Tabulation {
    public static void main(String[] args) {
        System.out.println(howSum(7, new int[] {4,3}));
        System.out.println(howSum(8, new int[] {2,3,5}));
        System.out.println(howSum(300, new int[] {7,14}));
    }

    static List<Integer> howSum(int target, int[] arr) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i <= target; i++) table.add(null);
        table.set(0, new ArrayList<>()); //[ [] , null , .....]

        for (int i = 0; i <= target; i++) {
            if (table.get(i) == null) continue;

            for (int num : arr) {
                if (i + num <= target) {
//                  List<Integer> curr = table.get(i); -> WRONG (CALL BY REFERENCE)
                    List<Integer> curr = new ArrayList<>(table.get(i));
                    curr.add(num);
                    table.set(i + num, curr);
                }
            }
        }
        return table.get(target);
    }
}

// table.add(0, x) -> X         //shifts all else, put x at 0
// table.set(0, x) -> Correct   //replaces 0

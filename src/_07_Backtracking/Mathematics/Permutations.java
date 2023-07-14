package _07_Backtracking.Mathematics;

import java.util.List;
import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        System.out.println("Permutations : " + permutationsRecursive(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permutationsRecursive(int[] nums) {
        return helper(0, nums);
    }

    public static List<List<Integer>> helper(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> resPerms = new ArrayList<>();
        List<List<Integer>> perms = helper(i + 1, nums);
        for (List<Integer> p : perms) {
            for (int j = 0; j < p.size() + 1; j++) {
                List<Integer> pCopy = new ArrayList<>();
                pCopy.addAll(p);
                pCopy.add(j, nums[i]);
                resPerms.add(pCopy);
            }
        }
        return resPerms;
    }
}

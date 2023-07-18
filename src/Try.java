import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Try {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, target, candidates, curset, subset);
        return subset;
    }
    static void helper(int i, int target, int[] candidates, List<Integer> curset, List<List<Integer>> subset) {
        if (i == candidates.length) return;
        if (target == 0) {
            subset.add(new ArrayList<>(curset));
            return;
        }
        //TAKE ALL DUPLICATES
        if (candidates[i] <= target) {
            curset.add(candidates[i]);
            helper(i + 1, target - candidates[i], candidates, curset, subset);
            curset.remove(curset.size() - 1);
        }
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++; //at last duplicate
        helper(i + 1, target, candidates, curset, subset);
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        Try solution = new Try();
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        System.out.println("Combinations that sum up to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
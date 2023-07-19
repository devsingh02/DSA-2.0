import java.util.ArrayList;
import java.util.List;

public class Try {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        List<List<Integer>> ans = new ArrayList<>();

        System.out.println(permutations(new ArrayList<>(), nums));
    }

    static List<List<Integer>> permutations(List<Integer> current, int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) {
                continue;
            }

            current.add(nums[i]);
            ans.addAll(permutations(current, nums));
            current.remove(current.size() - 1);
        }
        return ans;
    }
}

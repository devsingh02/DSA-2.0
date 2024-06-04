package _13_Bitmasking;

import java.util.*;

public class MeetInTheMiddle {
    // Function to find all subsets of a given array
    static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        // Iterate through 2^n possible combinations
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            // Include elements whose corresponding bit is set
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }

    // Function to find subset sums and store them in a map
    static Map<Integer, List<List<Integer>>> subsetSums(List<List<Integer>> subsets) {
        Map<Integer, List<List<Integer>>> sumsMap = new HashMap<>();
        for (List<Integer> subset : subsets) {
            int sum = 0;
            for (int num : subset) {
                sum += num;
            }
            if (!sumsMap.containsKey(sum)) {
                sumsMap.put(sum, new ArrayList<>());
            }
            sumsMap.get(sum).add(subset);
        }
        return sumsMap;
    }

    // Function to solve the "meet in the middle" problem
    static List<List<Integer>> meetInTheMiddle(int[] nums, int target) {
        int n = nums.length;
        // Split the array into two parts
        int mid = n / 2;
        int[] firstHalf = Arrays.copyOfRange(nums, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(nums, mid, n);

        // Generate subsets for each part
        List<List<Integer>> subsetsFirstHalf = generateSubsets(firstHalf);
        List<List<Integer>> subsetsSecondHalf = generateSubsets(secondHalf);

        // Find subset sums for each part
        Map<Integer, List<List<Integer>>> sumsFirstHalf = subsetSums(subsetsFirstHalf);
        Map<Integer, List<List<Integer>>> sumsSecondHalf = subsetSums(subsetsSecondHalf);

        // Search for the desired sum
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<List<Integer>>> entry : sumsFirstHalf.entrySet()) {
            int complement = target - entry.getKey();
            if (sumsSecondHalf.containsKey(complement)) {
                List<List<Integer>> subsets1 = entry.getValue();
                List<List<Integer>> subsets2 = sumsSecondHalf.get(complement);
                for (List<Integer> subset1 : subsets1) {
                    for (List<Integer> subset2 : subsets2) {
                        List<Integer> combined = new ArrayList<>();
                        combined.addAll(subset1);
                        combined.addAll(subset2);
                        result.add(combined);
                    }
                }
            }
        }
        return result;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] nums = {5, 3, -1, 7};
        int target = 9;
        List<List<Integer>> subsets = meetInTheMiddle(nums, target);
        if (subsets.isEmpty()) {
            System.out.println("No subset found.");
        } else {
            System.out.println("Subsets with sum " + target + ":");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
        }
    }
}

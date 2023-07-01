package _12_DP.Basics._07_CountConstruct;

import java.util.HashMap;

public class Memoization {
    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>())); // true
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>())); // false
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>())); // true
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eee", "eeee", "eeeeeee", "eeeeee", "eeeeeeeeeeeeee", "ee"}, new HashMap<>())); // true
    }

    static int countConstruct(String target, String[] arr, HashMap<String, Integer> memo) {
        if (target.equals("")) return 1;
        if (memo.containsKey(target)) return memo.get(target);

        int count = 0;
        for (String pre : arr) {
            if (target.indexOf(pre) == 0) {
                String suff = target.substring(pre.length());
                int numOfWays = countConstruct(suff, arr, memo);
                count += numOfWays;
            }
        }
        memo.put(target, count);
        return count;
    }
}
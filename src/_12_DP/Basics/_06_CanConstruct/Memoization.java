package _12_DP.Basics._06_CanConstruct;

import java.util.HashMap;

public class Memoization {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>())); // true
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>())); // false
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>())); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eee", "eeee", "eeeeeee", "eeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeee", "ee"}, new HashMap<>())); // true
    }
    static boolean canConstruct(String target, String[] arr, HashMap<String, Boolean> memo) {
        if (target == "") return true;
        if (memo.containsKey(target)) return memo.get(target);
        
        for (String prefix : arr) {
            if (target.indexOf(prefix) == 0) {  //if is prefix
                String suffix = target.substring(prefix.length());
                if (canConstruct(suffix, arr, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }
}
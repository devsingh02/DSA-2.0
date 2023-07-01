package _12_DP.Basics._08_AllConstruct;

import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println(allConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"}));
        // Output: [[purp, le], [p, ur, p, le]]
        System.out.println(allConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
        // Output: [[ab, cd, ef], [ab, c, def], [abc, def]]
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eee", "eeee", "eeeeeee", "eeeeee", "eeeeeeeeeeeeee", "ee"}));

    }

    static List<List<String>> allConstruct(String target, String[] arr) {
        List<List<String>> result = new ArrayList<>();
        if (target.equals("")) {
            result.add(new ArrayList<>());
            return result;
        }

        for (String pre : arr) {
            if (target.indexOf(pre) == 0) {
                String suff = target.substring(pre.length());
                List<List<String>> allPaths = allConstruct(suff, arr);
                for (List<String> path : allPaths) {
                    path.add(0, pre);
                    result.add(path);
                }
            }
        }
        return result;
    }
}
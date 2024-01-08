package _12_DP._04_MCM;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStrings {

    static Map<String, Boolean> memo = new HashMap<>();
    static boolean isAnagram(String s1, String s2) {
        int[] chars = new int[26]; //0->a 1->b ...
        for (char ch : s1.toCharArray()) chars[ch-'a']++;
        for (char ch : s2.toCharArray()) chars[ch-'a']--;

        for (int val : chars) if (val != 0) return false;

        return true;
    }

    static boolean isScramble(String s1, String s2) {
        // strings of unequal length for sure never scramble
        if (s1.length() != s2.length()) return false;
        // equal strings are always scramble
        if (s1.equals(s2)) return true;

        String key = s1 + "-" + s2;
        if (memo.containsKey(key)) return memo.get(key);

        // If a string is not anagram -> it will never be a scramble
        if (!isAnagram(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {   //partitions using substring
            // swap || no-swap
            if ((isScramble(s1.substring(0,i),s2.substring(n-i)) && isScramble(s1.substring(i),s2.substring(0,n-i)))
                    || (isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
    // Driver Code
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";

        System.out.println(isScramble(s1, s2)); // Output: true
    }
}

// NOTES :-
//Anagram logic is used to optimize the code,
//since if both strings are anagram, they may be scrambled
//but if not anagrams, then for sure not scrambled
//Therefore we further narrow down the cases
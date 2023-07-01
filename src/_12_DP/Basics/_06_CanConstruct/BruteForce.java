package _12_DP.Basics._06_CanConstruct;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eee", "eeee", "eeeeeee", "eeeeee", "eeeeeeeeeeeeee", "ee"})); // true

    }
    static boolean canConstruct(String target, String[] arr) {
        if (target == "") return true;
        
        for (String prefix : arr) {
            if (target.indexOf(prefix) == 0) {  //if is prefix
                String suffix = target.substring(prefix.length()); // Recursively check if we can construct the suffix using the word bank
                if (canConstruct(suffix, arr)) return true; // agar ek bhi child true hai -> to return true
            }
        }
        return false;
    }
}
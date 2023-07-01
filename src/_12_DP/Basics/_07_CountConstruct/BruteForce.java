package _12_DP.Basics._07_CountConstruct;

public class BruteForce {
    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); 
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); 
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); 
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eee", "eeee", "eeeeeee", "eeeeee", "eeeeeeeeeeeeee", "ee"})); 
    }
    static int countConstruct(String target, String[] arr) {
        if (target.equals("")) return 1;
        int count = 0;
        
        for (String prefix : arr) {
            if (target.indexOf(prefix) == 0) {  //if is prefix
                String suffix = target.substring(prefix.length()); // Recursively check if we can construct the suffix using the word bank
                int numOfWays = countConstruct(suffix, arr);
                count += numOfWays;
            }
        }
        return count;   // 0 if no path found
    }
}

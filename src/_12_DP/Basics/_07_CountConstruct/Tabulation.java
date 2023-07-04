package _12_DP.Basics._07_CountConstruct;

public class Tabulation {
    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eee", "eeee", "eeeeeee", "eeeeee", "eeeeeeeeeeeeee", "ee"}));
    }
    static int countConstruct(String target, String[] arr) {
        int[] table = new int[target.length() + 1];
        table[0] = 1;   //rest by default = 0

        for (int i = 0; i < table.length; i++) {
            if (table[i] == 0) continue;

            for (String word : arr) {
                if (target.indexOf(word, i) == i) table[i + word.length()] += table[i];
            }
        }
        return table[target.length()];
    }
}


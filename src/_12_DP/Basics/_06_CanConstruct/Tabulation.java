package _12_DP.Basics._06_CanConstruct;

public class Tabulation {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eee", "eeee", "eeeeeee", "eeeeee", "eeeeeeeeeeeeee", "ee"})); // false

    }
    static boolean canConstruct(String target, String[] arr) {
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if (!table[i]) continue;

            for (String word : arr) {
                if (target.indexOf(word, i) == i) table[i + word.length()] = true;
            }
        }
        return table[target.length()];
    }
}

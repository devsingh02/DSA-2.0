//package _12_DP.Basics._08_AllConstruct;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Tabulation {
//    public static void main(String[] args) {
//        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
//        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
//        System.out.println(allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
//        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eee", "eeee", "eeeeeee", "eeeeee", "eeeeeeeeeeeeee", "ee"}));
//    }
//    public static List<List<String>> allConstruct(String target, String[] wordBank) {
//        List<List<List<String>>> table = new ArrayList<>();
//        for (int i = 0; i <= target.length(); i++) table.add(new ArrayList<>());
//        table.get(0).add(new ArrayList<>());
//
//        for (int i = 0; i <= target.length(); i++) {
//            for (String word : wordBank) {
//                if (target.startsWith(word, i)) {
//                    List<List<String>> newCombinations = new ArrayList<>();
//                    for (List<String> subArray : table.get(i)) {
//                        List<String> newArray = new ArrayList<>(subArray);
//                        newArray.add(word);
//                        newCombinations.add(newArray);
//                    }
//                    table.get(i + word.length()).addAll(newCombinations);
//                }
//            }
//        }
//        return table.get(target.length());
//    }
//}

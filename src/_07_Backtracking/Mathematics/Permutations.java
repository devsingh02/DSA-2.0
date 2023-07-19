package _07_Backtracking.Mathematics;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        // STRING
        List<String> ans = new ArrayList<>();
        System.out.println("Count = " + permutationsString("", "abc", ans) + "\n" + ans + "\n");
        // ARRAY / LIST
        List<List<Integer>> answer = new ArrayList<>();
        System.out.println("Count = " + permutationsArray(new ArrayList<>(), new int[]{1,2,3}, 0, answer) + "\n" + answer);
    }

    static int permutationsString(String p, String up, List<String> ans) {
        int count = 0;  //**
        if (up.isEmpty()) {
            ans.add(p);
            return 1;   //any call / base calls
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i);
            count += permutationsString(f + ch + l, up.substring(1), ans);
        }
        return count;   //1st call**
    }

    static int permutationsArray(List<Integer> p, int[] up, int ind, List<List<Integer>> ans) {
        int count = 0;
        if (ind == up.length) { //up is empty logically
            ans.add(new ArrayList<>(p));
            return 1;
        }
        int ch = up[ind]; //first index of up string
        for (int i = 0; i <= p.size(); i++) {
            List<Integer> newp = new ArrayList<>(p);
            newp.add(i, ch);
            count += permutationsArray(newp, up, ind + 1, ans);
        }
        return count;
    }
}

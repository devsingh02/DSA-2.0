import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class MBTI_CognitiveFunctions_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mbti = "";
        while (true) {
            System.out.print("Enter any MBTI : ");
            mbti = sc.next().toUpperCase();

            if (mbti.equals("E") || mbti.equals("EXIT") || mbti.equals("EXI") || mbti.equals("EX")) break;
            if (invalid(mbti)) continue;  // returns true if meaningless input

            System.out.println("Cognitive Functions : " + cognitiveFunctions(mbti) + "\n");
        }
        sc.close();
    }

    static List<String> cognitiveFunctions(String mbti) {   //UPPERCASE
        List<String> ans = new ArrayList<>(4);
        char[] order = order(Character.toLowerCase(mbti.charAt(0)));   // i,e,i,e  || e,i,e,i
        HashMap<Character, Character> PJ = determiner(mbti);           // e -> N/S || e -> F/T
        HashMap<Character, Character> opposite = opposites();         //   [P]         [J]
        // FirstTwo
        for (int i = 0; i < 2; i++) {
            ans.add("" + PJ.get(order[i]) + order[i]);
        }
        // Third
        ans.add("" + opposite.get(ans.get(1).charAt(0)) + order[2]);
        // Fourth
        ans.add("" + opposite.get(ans.get(0).charAt(0)) + order[3]);

        return ans;
    }
    
    static char[] order(char start) {
        char[] a = new char[4];
        a[0] = start;
        for (int i = 0; i < a.length - 1 ; i++) {
            if (a[i] == 'e') a[i + 1] = 'i';
            else a[i + 1] = 'e';
        }
        return a;
    }
    
    static HashMap<Character, Character> determiner(String mbti) {
        HashMap<Character, Character> PJ = new HashMap<>(2);
        if (mbti.charAt(3) == 'P') {
            PJ.put('e', mbti.charAt(1));
            PJ.put('i', mbti.charAt(2));
        }
        else {
            PJ.put('e', mbti.charAt(2));
            PJ.put('i', mbti.charAt(1));
        }
        return PJ;
    }

    static HashMap<Character, Character> opposites() {
        HashMap<Character, Character> opp = new HashMap<>(4);
//        opp.put('I', 'E'); opp.put('E', 'I');
        opp.put('N', 'S'); opp.put('S', 'N');
        opp.put('F', 'T'); opp.put('T', 'F');
//        opp.put('J', 'P'); opp.put('P', 'J');
        return opp;
    }

    static boolean invalid(String mbti) {
        if ((mbti.length() != 4) || (mbti.charAt(0) != 'E' && mbti.charAt(0) != 'I') || (mbti.charAt(1) != 'N' && mbti.charAt(1) != 'S') || (mbti.charAt(2) != 'F' && mbti.charAt(2) != 'T') || (mbti.charAt(3) != 'P' && mbti.charAt(3) != 'J')) {
            System.out.println("INVALID type. Try again.\n");
            return true;
        }
        return false;
    }
}
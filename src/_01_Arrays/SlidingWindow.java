package _01_Arrays;// In Sliding Windows : Size maintainence comes first. Then rest logic.

import java.util.HashSet;

public class SlidingWindow {

    //**FIXED**
    //return true if more than one same element in a window size k
    public static boolean duplicate(int[] a, int k) {
        HashSet<Integer> window = new HashSet<>();
        int L = 0;
        for (int R = 0; R < a.length; R++) {
            if (R - L + 1 > k) {    // first maintain/correct size, then compare.
                window.remove(a[L]);
                L++;
            }
            if (window.contains(a[R])) return true;
            window.add(a[R]);
        }
        return false;
    }

    //**VARIABLE**
    //find the length of the longest sub-array with each element same
    public static int longestSame(int[] a) {
        int length = 0, L = 0;
        for (int R = 0; R < a.length; R++) {
            if (a[R] != a[L]) L = R;
            length = Math.max(length, R - L + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        int[] a_fixed = {1, 2, 3, 2, 3, 3};
        int[] a_variable = {4, 2, 2, 3, 3, 3};
        System.out.println("FIXED : " + duplicate(a_fixed, 2));
        System.out.println("VARIABLE : " + longestSame(a_variable));
    }
}

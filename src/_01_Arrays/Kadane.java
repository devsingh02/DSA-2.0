package _01_Arrays;

public class Kadane {

    //find a non-empty subarray with largest sum
    public static void KadaneAlgo(int[] a) {
        int maxSum = a[0];  // ***
        int maxL = 0, maxR = 0;
        int curSum = 0;
        int L = 0;

        for (int R = 0; R < a.length; R++) {
            curSum += a[R];
            if (curSum < 0) {
                curSum = 0;
                L = R + 1;
            }
            if (maxSum <= curSum) {
                maxSum = curSum;
                maxL = L;
                maxR = R;
            }
        }
        display(a, maxL, maxR, maxSum);
    }

    public static void display(int[] a, int start, int end, int maxSum) {
        System.out.print("Sub-array with largest Sum = " + maxSum + " is : {");
        for (int i = start; i < end; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[end] + "}");
    }

    public static void main(String[] args) {
        int[] a = {4, -1, 2, -7, 3, 4};
        KadaneAlgo(a);
    }
}

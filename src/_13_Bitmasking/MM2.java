package _13_Bitmasking;

import java.util.*;

public class MM2 {
    public static int minAbsDifference(int[] nums, int goal) {
        // goal ki value -10^9 to 10^9 hai to dp nhi lga sakte dp lagayenge to utna memory out aa jayege 2d me.
        // aur negative bhi goal ho sakta usko handle krna padega.
        // length of arr <=40 if we generate all subsequence tc= 2^n =2^40, greater than 1sec.
        // so try meet in the middle approach;
        int n=nums.length;
        if(n==1){
            return Math.min(Math.abs(0-goal),Math.abs(nums[0]-goal));
        }
        int m=n/2;
//        System.out.println(n+" "+m);
        ArrayList<Integer> left=new ArrayList<>();
        solve(nums,0,m,left,0);
        ArrayList<Integer> right=new ArrayList<>();
        solve(nums,m,n,right,0);

        // step 2. sort right;
        Collections.sort(right);

        //step 3. search for best ans;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<left.size();i++){
            int k=left.get(i);
            int a=BinarySearch(right,goal,k);
            ans=Math.min(ans,a);
        }
        return ans;
    }
    public static void solve(int[] nums,int i,int n,ArrayList<Integer> list,int sum){
        if(i==n){
            list.add(sum);
            return ;
        }
        solve(nums,i+1,n,list,sum);
        solve(nums,i+1,n,list,sum+nums[i]);
    }
    static int BinarySearch(ArrayList<Integer> list,int goal,int k){
        int l=0;
        int h=list.size()-1;
        int ans=Integer.MAX_VALUE;
        while(l<=h){
            int mid=l+(h-l)/2;
            int a=k+list.get(mid);
            int dif=Math.abs(goal-a);
            ans=Math.min(ans,dif);
            if(a<goal){
                l=mid+1;
            }
            else if(a>goal){
                h=mid-1;
            }
            else return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int goal = -5;
        int[] nums = {7,-9,15,-2};
        System.out.println(minAbsDifference(nums, goal));
    }
}

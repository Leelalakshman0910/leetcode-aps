class Solution {
    public int[] runningSum(int[] a) {
        int [] ans = new int[a.length];
        ans[0] = a[0];
        for(int i = 1;i < a.length;i++){
          int  s = 0;
            for(int j = 0;j <= i;j++){
                s = s+a[j];
            }
            ans[i] = s;
        }
        return ans;
    }
}
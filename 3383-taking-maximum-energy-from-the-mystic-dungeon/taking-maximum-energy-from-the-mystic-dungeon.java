class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int []ans = new int[k];
        int n = energy.length;
        Arrays.fill(ans,-2000000000);
        for(int i=0;i<n;i+=k){
            for(int j = i;j < i+k && j < n;j++){
                ans[j-i] = Math.max(ans[j-i]+energy[j],energy[j]);
            }   
        }

        int max = Integer.MIN_VALUE;

        for(int i:ans)
            max = Math.max(i,max);

        return max;
    }
}
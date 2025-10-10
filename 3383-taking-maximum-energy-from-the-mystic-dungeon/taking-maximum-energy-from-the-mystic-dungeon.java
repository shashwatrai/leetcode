class Solution {
    public int maximumEnergy(int[] energy, int k) {
       
        int n = energy.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            int temp = -2000000000;
            for(int j = i; j < n;j+=k){
                temp = Math.max(temp+energy[j],energy[j]);
            }
            max = Math.max(max,temp);   
        }

        return max;
    }
}
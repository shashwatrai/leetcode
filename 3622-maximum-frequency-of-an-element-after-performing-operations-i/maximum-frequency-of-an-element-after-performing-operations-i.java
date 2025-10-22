class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int []freq1 = new int[3*100000+3];
        int []freq2 = new int[3*100000+3];

        for(int i:nums){
            freq1[i+100000]++;

            freq2[i-k+100000]++;
            freq2[i+k+100000+1]--;
        }

        for(int i=1;i<freq2.length;i++)
            freq2[i] += freq2[i-1];

        int max  =0 ;
        for(int i=0;i<freq2.length-1;i++){
            max = Math.max(max,freq1[i] + Math.min(freq2[i]-freq1[i],numOperations));    
        }
        return max;
    }
}
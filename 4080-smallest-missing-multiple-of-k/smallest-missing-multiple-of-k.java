class Solution {
    public int missingMultiple(int[] nums, int k) {
        int []track = new int[102];

        for(int i:nums){
            if(i%k == 0)
                track[i/k]++;
        }

        for(int i=1;i<102;i++){
            if(track[i] == 0)
                return k*i;
        }
        return -1;
    }
}
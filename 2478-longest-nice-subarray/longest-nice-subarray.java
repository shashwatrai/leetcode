class Solution {
    public int longestNiceSubarray(int[] nums) {
        int len =0;
        int start=-1;
        int temp = 0;
        int lastPos[] = new int[32];
        Arrays.fill(lastPos,-1);
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            for(int j=0;j<32;j++){
                if((nums[i] & (1 << j)) != 0){
                    if(lastPos[j] != -1){
                        start = lastPos[j];
                        for(int k=0;k<32;k++){
                            if(lastPos[k] <= start)
                                lastPos[k] = -1;
                        }
                    }
                    lastPos[j] = i;
                }

            }
            // System.out.println(start+" "+i+" "+len);
            len = Math.max(i-start,len);
        }
        return len;
    }
}
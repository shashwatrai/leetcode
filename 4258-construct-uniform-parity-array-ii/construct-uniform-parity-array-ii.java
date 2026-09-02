class Solution {
    public boolean uniformArray(int[] nums1) {
        int count = 0;
        int even = Integer.MAX_VALUE;
        int odd = Integer.MAX_VALUE;
        for(int i:nums1){
            if(i%2 == 0){
                count++;
                even  = Math.min(even, i);
            }
            else
                odd  = Math.min(odd, i);
        }

        if(count == nums1.length ||count == 0)
            return true;
        return even - 1 >= odd;
    }
}
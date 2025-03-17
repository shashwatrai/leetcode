class Solution {
    public boolean divideArray(int[] nums) {
        int arr[] = new int[501];
        for(int i:nums)
            arr[i]++;
        
        for(int i:arr)
            if(i%2 != 0)
                return false;
        
        return true;
    }
}
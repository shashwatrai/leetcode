class Solution {
    public int findAns(int l, int r, int []arr){
        if(l == r)
            return arr[l];

        if(arr[l] < arr[r])
            return arr[l];
        
        int m = (l+r)/2;

        return Math.min(findAns(l,m,arr),findAns(m+1,r,arr));
    }

    public int findMin(int[] nums) {
        return findAns(0 , nums.length-1,nums);
    }
}
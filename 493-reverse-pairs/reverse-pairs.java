class Solution {
    public int merger(int []nums, int l , int m,int r){
        int []arr = new int[r-l+1];
        int i=l,j=m+1,k=0;
        int cnt=0;
        for(int x = l,y=m+1;y<=r;y++){
            while(x <= m && (long)nums[x] > 2L*(long)nums[y])
                x++;
            cnt += x-l;
        }
        while( i <=m || j<=r){
            if(i > m || (j <= r && nums[j] > nums[i])){
                arr[k] = nums[j];
                j++;
                k++;

            }else{
                arr[k] = nums[i];
                i++;
                k++;
            }
        }
        for(i= l;i<=r;i++){
            nums[i] = arr[i-l];
        }
        return cnt;
    }
    public int helper(int nums[],int l,int r){
        if(l == r)
            return 0;
        int m = (l+r)/2;
        int left = helper(nums,l,m);
        int right = helper(nums,m+1,r);
        int merger = merger(nums,l,m,r);
        return left+right+merger;
    }
    public int reversePairs(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
}
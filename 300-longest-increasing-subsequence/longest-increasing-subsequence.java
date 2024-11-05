class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            int l = 0,r = arr.size() -1;
            while(l<=r){
                int m = (l+r)/2;
                if(nums[i] <= arr.get(m))
                    r= m-1;
                else
                    l = m+1;
            }
            if(l == arr.size())
                arr.add(nums[i]);
            else
                arr.set(l,nums[i]);
            
        }
        
        return arr.size();
    }
}
class FindSumPairs {
    Map<Integer,Integer> map ;
    int[] nums1,nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i:nums2)
            map.put(i,map.getOrDefault(i,0)+1);
    }
    
    public void add(int indx, int val) {
        map.put(nums2[indx],map.get(nums2[indx]) - 1);
        if(map.get(nums2[indx]) == 0)
            map.remove(nums2[indx]);
        nums2[indx] += val;
        map.put(nums2[indx],map.getOrDefault(nums2[indx],0)+1);
    }
    
    public int count(int tot) {
        int ans =0 ;
        for(int i:nums1){
            ans += map.getOrDefault(tot-i,0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
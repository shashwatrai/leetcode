class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> raw = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] == key){
                for(int j= i;j>=i-k && j >= 0 ;j--){
                    raw.add(j);
                }

                for(int j = i+1;j<nums.length && j <= i+k;j++){
                    raw.add(j);
                }
            }
        }
        List<Integer> ans = new ArrayList<>(raw);
        Collections.sort(ans);
        return ans;
    }
}
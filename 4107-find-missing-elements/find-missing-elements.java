class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            min = Math.min(i,min);
            max = Math.max(i,max);
            set.add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=min;i<=max;i++){
            if(set.contains(i))
                continue;
            ans.add(i);
        }
        return ans;
    }
}
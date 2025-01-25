class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        TreeSet<Integer> set = new TreeSet<>((a,b) -> nums[a] != nums[b] ? nums[a] - nums[b] : a -b);
        for(int i=0;i<nums.length;i++){
            set.add(i);
        }
        int ans[] = new int[nums.length];
        while(!set.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            TreeSet<Integer> sorted = new TreeSet<>();
            arr.add(set.first());
            sorted.add(set.first());
            set.remove(set.first());
            while(!set.isEmpty()){
                
                if(nums[set.first()] - nums[arr.get(arr.size()-1)] > limit)
                    break;
                sorted.add(set.first());
                arr.add(set.first());
                set.remove(set.first());
            }
            int indx=0;
            // System.out.println(arr+" "+sorted);
            while(!sorted.isEmpty()){
                int i = sorted.first();
                sorted.remove(i);
                int j = arr.get(indx++);
                ans[i]  = nums[j];
            }
            
        }
        return ans;
    }
}

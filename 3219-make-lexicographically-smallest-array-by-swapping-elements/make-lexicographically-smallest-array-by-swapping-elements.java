class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int arr[] = Arrays.copyOf(nums,nums.length);

        Arrays.sort(arr);

        Map<Integer,Integer> group = new HashMap<>();
        Map<Integer,LinkedList<Integer>> groupMem = new HashMap<>();
        int curr=0;
        group.put(arr[0],curr);
        groupMem.put(curr,new LinkedList<>());
        groupMem.get(curr).add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i] - arr[i-1 ] > limit)
                curr++;
            
            group.put(arr[i],curr);
            if(!groupMem.containsKey(curr))
                groupMem.put(curr,new LinkedList<>());
            groupMem.get(curr).add(arr[i]);
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = groupMem.get(group.get(nums[i])).pop();
        }
        return nums;


    }
}
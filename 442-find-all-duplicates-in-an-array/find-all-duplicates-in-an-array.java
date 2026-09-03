class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int left = 0;

        int curr = -1;
        while(true){

            if(curr == -1){
                while(left < nums.length && nums[left] <= 0)
                    left++;
                if(left == nums.length)
                    break;
                curr = nums[left];
                nums[left] = 0;
            }

            int temp = nums[curr - 1];
            // System.out.println("B "+left+" "+curr+" "+temp+" "+Arrays.toString(nums));
            if(temp > 0){
                nums[curr - 1 ] = -1;
                curr = temp;
            }
            else{
                nums[curr - 1] -= 1;
                curr = -1;
            }
            // System.out.println("A "+left+" "+curr+" "+temp+" "+Arrays.toString(nums));
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] < - 1)
                ans.add(i+1);
        }
        return ans;
    }
}
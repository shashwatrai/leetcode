class Solution {
    public String findDifferentBinaryString(String[] nums) {
        char []arr = new char[nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i].charAt(i) == '0')
                arr[i] = '1';
            else
                arr[i] = '0';
        }
        return new String(arr);
    }
}
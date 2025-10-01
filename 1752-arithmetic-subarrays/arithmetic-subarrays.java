class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] left, int[] right) {
        

        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<left.length;i++){
            int l = left[i],r = right[i];

            if(l == r)
                ans.add(false);
            else{
                int temp[] = new int[r-l+1];
                for(int j = l;j<=r;j++)
                    temp[j-l] = nums[j];
                Arrays.sort(temp);

                int d = temp[1] - temp[0];
                // System.out.println(Arrays.toString(temp));
                boolean isValid = true;
                for(int j = 0;isValid && j<temp.length-1;j++){
                    if(temp[j]+d != temp[j+1])
                        isValid = false;
                }
                ans.add(isValid);
            }
        }
        return ans;
    }
}
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            if(digits[i]%2 == 0){
                for(int j = 0;j<digits.length;j++){
                    for(int k =0 ;k<digits.length;k++){
                        if(digits[k]!= 0 && i!=j && i!= k && j!=k){
                            set.add(digits[k]*100+digits[j]*10 + digits[i]);
                        }
                    }
                }
            }
        }
        int ans[] = new int[set.size()];
        int indx=0;
        for(int i:set){
            ans[indx++] = i;
        }
        Arrays.sort(ans);
        return ans;
    }
}
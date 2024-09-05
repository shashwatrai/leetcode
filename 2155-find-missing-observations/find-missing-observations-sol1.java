class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int sum=0;
        for(int i:rolls)
            sum += i;
        int missingSum = mean * (rolls.length+n) - sum;
        if( missingSum > 6*n || missingSum < n)
            return new int[0];

        int []ans = new int [n];

        int faces[] = {6,5,4,3,2,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<6;){
                if(missingSum - faces[j] >= n-i-1 ){
                    ans[i] = faces[j];
                    missingSum -= faces[j];
                    break;
                }else
                    j++;
            }
        }
        return ans;
    }
}

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int sum=0;
        for(int i:rolls)
            sum += i;
        int missingSum = mean * (rolls.length+n) - sum;
        if( missingSum > 6*n || missingSum < n)
            return new int[0];

        int []ans = new int [n];

        int dm = missingSum  / n;
        int remains = missingSum%n;
        Arrays.fill(ans,dm);
        for(int i=0;i<remains;i++)
            ans[i]++;
        return ans;
    }
}
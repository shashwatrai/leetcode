class Solution {
    public int numTeams(int[] rating) {

        int n = rating.length;
        int ans[] = new int[n];
        int prevI[] = new int[n];
        int prevD[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(rating[i] > rating[j]){
                    ans[i] += prevI[j];
                    prevI[i]++;
                }
                if(rating[i] < rating[j]){
                    ans[i] += prevD[j];
                    prevD[i]++;
                }
            }
        }
        int sum=0;
        for(int i:ans)
            sum+=i;
        return sum;
    }
}
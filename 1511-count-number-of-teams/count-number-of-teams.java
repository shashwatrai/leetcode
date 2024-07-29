class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;

        int ans =0;

        for(int i=1;i<n-1;i++){
            int decL=0,incL=0,incR=0,decR=0;

            for(int j= i-1;j>=0;j--){
                if(rating[i] > rating[j])
                    decL++;
                else if(rating[i] < rating[j])
                    incL++;
            }

            for(int j= i+1;j<n;j++){
                if(rating[i] > rating[j])
                    decR++;
                else if(rating[i] < rating[j])
                    incR++;
            }

            ans += decL*incR + incL*decR;

        }
        return ans;
    }
}
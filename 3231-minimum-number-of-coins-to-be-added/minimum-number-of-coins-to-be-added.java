class Solution {
    public int minimumAddedCoins(int[] coins, int target) {

        Arrays.sort(coins);
        int sum=1;
        int cnt=0;
        int i=0,j=0;

        while( sum <= target){
            if( i < coins.length && sum >= coins[i]){
                sum += coins[i++] ; 
            }else{
                sum += sum; 
                cnt++;
            }
        }
        return cnt;
    }
}
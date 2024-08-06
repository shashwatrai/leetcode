class Solution {
    public int minimumAddedCoins(int[] coins, int target) {

        Arrays.sort(coins);
        int sum=1;
        int cnt=0;
        int i=0,j=0;

        // here sum signifies the range of the target covered i.e. [1,sum] i.e the smallest number to formed
        // logic is to start from 1, if the sum is less than the current element of the coins
        // then sum itself has to taken in the set, and ergo range expands to [1 , 2*sum-1]
        while( sum <= target){
            if( i < coins.length && sum >= coins[i]){
                sum += coins[i++] ; 
            }else{
                // this signifies that new taken number is sum itself, thus range is expanded from
                // [1 ... 2*sum-1]
                sum += sum; 
                cnt++;
            }
        }
        return cnt;
    }
}
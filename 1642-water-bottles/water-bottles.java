class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans =0 ;

        while(numBottles >= numExchange){

            ans += (numBottles/numExchange) * numExchange;

            numBottles = (numBottles/numExchange) + numBottles%numExchange;
        }
        ans += numBottles;
        return ans;

    }
}
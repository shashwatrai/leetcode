class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans =0;
        while(numBottles >= numExchange){
            ans += numExchange;
            numBottles += 1 - numExchange;
            numExchange++;
        }
        ans += numBottles;
        return ans;
    }
}
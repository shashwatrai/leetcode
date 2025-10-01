class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans =0 ;
        int cnt = piles.length/3;
        for(int i= piles.length-2;cnt-->0;i-=2){
            ans += piles[i];
        }
        return ans;
    }
}
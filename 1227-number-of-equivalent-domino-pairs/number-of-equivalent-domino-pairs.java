class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int []arr = new int[100];

        for(int i[]:dominoes){
            Arrays.sort(i);

            arr[i[0]*10+i[1]]++;
        }
        int ans=0;
        for(int i=11;i<100;i++){
            ans += (arr[i]*(arr[i]-1))/2;
        }
        return ans;
    }
}
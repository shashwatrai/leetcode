class Solution {
    public int solve(int []tops,int bottoms[]){
        int n = tops.length;
        int ans[][] = new int[n][7];
        
        int total[] = new int[7];
        int freq[] = new int[7];

        for(int i=0;i<n;i++){
            ans[i][tops[i]] = 1;
            freq[tops[i]]+=1;
            total[tops[i]]+=1;
        }
        for(int i: total){
            if(i == n)
                return 0;
        }
        for(int i=0;i<n;i++){
            if(ans[i][bottoms[i]] != 1){
                ans[i][bottoms[i]] = 1;
                total[bottoms[i]] += 1;
            }
        }
        int min =  Integer.MAX_VALUE;

        for(int i=1;i<7;i++){
            if(total[i] == n){
                min = Math.min(min,Math.min(freq[i],n-freq[i]));
            }
        }
        return min != Integer.MAX_VALUE? min:-1;
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {

        return Math.min(solve(tops,bottoms),solve(bottoms,tops));
    }
}
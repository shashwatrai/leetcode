class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int ans = Integer.MAX_VALUE ;
        for(int i=1;i<7;i++){
            int cnt= 0;
            int t=0,b=0;
            for(int j=0;j<n;j++){
                if(tops[j] == i && bottoms[j] == i){
                    cnt++;
                }else if(tops[j] == i){
                    cnt++;
                    t++;
                }else if(bottoms[j] == i){
                    cnt++;
                    b++;
                }
            }
            // System.out.println(i+" "+cnt+" "+t+" "+b);
            if(cnt == n){
                ans = Math.min(ans,Math.min(t,b));
            }
        }
        return ans != Integer.MAX_VALUE?ans:-1;
    }
}
class Solution {
    public boolean isValid(int []trainers,int []players,int m){
        int n = trainers.length;
        int i = m,j=n-1;
        for(;i>=0 && j >=0 ;i--,j--){
            if(players[i] > trainers[j])
                return false;
        }
        return i == -1;
    }
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int l = 0,r = players.length-1;

        while(l<=r){
            int m = (l+r)/2;

            if(isValid(trainers,players,m))
                l = m+1;
            else
                r = m-1;
        }
        return l;
    }
}
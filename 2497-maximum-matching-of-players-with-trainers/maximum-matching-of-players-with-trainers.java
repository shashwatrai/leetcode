class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        TreeMap<Integer,Integer> tMap = new TreeMap<>();

        for(int i=0;i<trainers.length;i++){
            tMap.put(trainers[i],tMap.getOrDefault(trainers[i],0)+1);
        }

        int ans = 0;
       
        for(int i=0;i<players.length;i++){
            // System.out.println(tMap);
            Integer t = tMap.ceilingKey(players[i]);
            if(t== null)
                continue;
            if(tMap.get(t) == 1){
                tMap.remove(t);
            }else
                tMap.put(t,tMap.get(t)-1);

            ans++;
        }
        return ans;
    }
}
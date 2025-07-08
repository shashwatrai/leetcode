class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a,b)-> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0] );
        TreeMap<Integer,Long> tmap = new TreeMap<>();

        for(int i=0;i<rides.length;i++){
            Integer l = tmap.floorKey(rides[i][0]);

            Integer r = tmap.floorKey(rides[i][1]);
            long tip = 0L;
            long currTip = (long)(rides[i][1] - rides[i][0] + rides[i][2]);
            if(l != null){
                if(l == r){
                    tip = tmap.get(l) + currTip;
                }else{
                    tip = Math.max(tmap.get(r), tmap.get(l) + currTip );
                }
            }else{
                if( r != null){
                    tip = Math.max(tmap.get(r),currTip);
                }else{
                    tip = currTip;
                }
            }
            // System.out.print(tmap+"\t");
            tmap.put(rides[i][1],Math.max(tmap.getOrDefault(rides[i][1],0L),tip));
            // System.out.println(tmap);
        }
        return tmap.get(tmap.lastKey());
    }
}
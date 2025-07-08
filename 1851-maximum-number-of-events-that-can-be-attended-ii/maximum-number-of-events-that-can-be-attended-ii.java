class Solution {
    public int maxValue(int[][] events, int k) {
        HashMap<Integer, Integer> tmap[] = new HashMap[k+1];

        for(int i=0;i<=k;i++){
            tmap[i] = new HashMap<>();
        }

        Arrays.sort(events,(a,b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        TreeSet<Integer> tset = new TreeSet<>();

        for(int i =0 ;i<events.length;i++){
            for(int j = 1;j<=k;j++){
                int left = tmap[j-1].getOrDefault(events[i][1],0);

                Integer upperKey = i > 0 ? events[i-1][1] : null;
                int upper = 0;
                if(upperKey != null)
                    upper = tmap[j].get(upperKey);
                
                Integer upperLeftKey = tset.floor(events[i][0]-1);
                int upperLeft = 0;
                // System.out.println(j+" "+upperLeftKey+" "+tmap[j-1]);
                if(upperLeftKey != null)
                    upperLeft = tmap[j-1].getOrDefault(upperLeftKey,0);

                int profit = Math.max(Math.max(left,upper), upperLeft + events[i][2]);
                tmap[j].put(events[i][1],profit);
                
            }
            tset.add(events[i][1]);
        }
        return tmap[k].get(events[events.length - 1][1]);
    }
}
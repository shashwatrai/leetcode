class Solution {
    public int findFloor(List<Integer> arr,int t){
        int l = 0;
        int r = arr.size()-1;

        while(l<=r){
            int m = (l+r)/2;

            if(arr.get(m) <= t)
                l = m+1;
            else
                r = m-1;
        }
        return r;
    }
    public int findCeil(List<Integer> arr, int t){
        int l = 0;
        int r = arr.size()-1;

        while(l<=r){
            int m = (l+r)/2;

            if(arr.get(m) >= t)
                r = m-1;
            else
                l = m+1;
        }
        return l == arr.size() ? -1:l;
    }
    public int[] countPoints(int[][] points, int[][] queries) {

        TreeMap<Integer,List<Integer>> tmap = new TreeMap<>();

        for(int p[]:points){
            if(!tmap.containsKey(p[0])){
                tmap.put(p[0],new ArrayList<>());
            }
            tmap.get(p[0]).add(p[1]);
        }
        for(int i:tmap.keySet()){
            Collections.sort(tmap.get(i));
        }
        int n = queries.length;

        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            int lx  = queries[i][0] - queries[i][2];
            int ux = queries[i][0] + queries[i][2];

            int ly = queries[i][1] - queries[i][2];
            int uy = queries[i][1] + queries[i][2];

            Integer start = tmap.ceilingKey(lx);

            if(start == null){
                ans[i] = 0;
                continue;
            }
            Integer end = tmap.floorKey(ux);
            
            if(end == null){
                ans[i] = 0;
                continue;
            }
            
            while(start != null && start <= end){
                List<Integer> arr = tmap.get(start);
                Integer starty = findCeil(arr,ly);
                Integer endy = findFloor(arr,uy);
                // System.out.println(i+" "+start+" "+end+" "+starty+" "+endy);
                if(starty != -1 && endy != -1){
                    while(starty <= endy){
                        boolean flag = (queries[i][0]- start) * (queries[i][0]- start) +
                        (queries[i][1]- arr.get(starty)) * (queries[i][1]- arr.get(starty)) <= queries[i][2] * queries[i][2];
                        if(flag)
                            ans[i]++;
                        starty++;
                    }
                }
                start = tmap.ceilingKey(start+1);
            }
        }
        return ans;
    }
}
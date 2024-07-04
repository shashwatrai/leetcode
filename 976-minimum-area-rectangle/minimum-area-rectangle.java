class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer,Set<Integer>> map = new HashMap();
        for(int i[]:points){
            if(!map.containsKey(i[0])){
                map.put(i[0],new HashSet<>());
            }
            map.get(i[0]).add(i[1]);
        }
        int area = Integer.MAX_VALUE;
        List<Integer> xAxes = new ArrayList<>(map.keySet());
        Collections.sort(xAxes);
        for(int i=0;i< xAxes.size();i++){

            for(int j=i+1;j<xAxes.size();j++){
                List<Integer> common = new ArrayList<>();
                for(int k:map.get(xAxes.get(i))){
                    if(map.get(xAxes.get(j)).contains(k))
                        common.add(k);
                }
                if(common.size() > 1){
                    Collections.sort(common);
                    int width  = Integer.MAX_VALUE;
                    for(int t = 1;t<common.size() ; t++){
                        width = Math.min(width,common.get(t)-common.get(t-1));
                    }
                    area = Math.min(area, width * (xAxes.get(j)- xAxes.get(i)));
                }
            }

        }
        return area == Integer.MAX_VALUE ? 0: area;
    }
}
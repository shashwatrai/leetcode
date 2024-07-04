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
        
        for(int i=0;i< points.length;i++){

            for(int j=i+1;j<points.length;j++){
                
                int x1 = points[i][0],x2 = points[j][0];
                int y1 = points[i][1],y2 = points[j][1];
                if(x1 == x2 || y1 == y2) 
                    continue;
                
                if(map.get(x1 ).contains(y1) && map.get(x1 ).contains(y2) && 
                map.get(x2 ).contains(y1) && map.get(x2 ).contains(y2)){
                    area = Math.min(area,Math.abs(x1-x2) * Math.abs(y1-y2));
                }
            }

        }
        return area == Integer.MAX_VALUE ? 0: area;
    }
}
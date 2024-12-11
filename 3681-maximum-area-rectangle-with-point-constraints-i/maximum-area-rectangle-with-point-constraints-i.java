class Solution {
    public int maxRectangleArea(int[][] points) {
        TreeMap<Integer,TreeSet<Integer>> xMap = new TreeMap<>();
        TreeMap<Integer,TreeSet<Integer>> yMap = new TreeMap<>();

        for(int i=0;i<points.length;i++){
            if(!xMap.containsKey(points[i][0])){
                xMap.put(points[i][0],new TreeSet<>());
            }
            xMap.get(points[i][0]).add(points[i][1]);

            if(!yMap.containsKey(points[i][1])){
                yMap.put(points[i][1],new TreeSet<>());
            }
            yMap.get(points[i][1]).add(points[i][0]);
        }
        int area = -1;
        for(int x1: xMap.keySet()){
            if(xMap.get(x1).size() > 1){

                for(int y1 : xMap.get(x1)){
                    Integer y2 = xMap.get(x1).ceiling(y1+1);

                    if(y2 == null)
                        continue;

                    if(yMap.get(y1).ceiling(x1+1) == null ||   yMap.get(y2).ceiling(x1+1) == null || 
                         yMap.get(y1).ceiling(x1+1).intValue() != yMap.get(y2).ceiling(x1+1).intValue() ){
                        continue;
                    }
                    

                    Integer x2 =  yMap.get(y1).ceiling(x1+1);

                    boolean isValid = true;
                    Integer y = yMap.ceilingKey(y1+1);



                    while(y<y2){
                        Integer x = yMap.get(y).ceiling(x1);
                        if(x  != null && x <= x2){
                            isValid = false;
                            break;
                        }
                        y =  yMap.ceilingKey(y+1);
                    }

                
                    if(isValid){
                        area=  Math.max(area, Math.abs(x2 - x1) * Math.abs(y1-y2));
                    }

                } 
            }
        }
        return area;
    }
}
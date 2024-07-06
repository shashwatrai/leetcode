class DetectSquares {

    Map<Integer,Map<Integer,Integer>> xMap ;
    Map<Integer,Map<Integer,Integer>> yMap;
    public DetectSquares() {
        xMap = new HashMap<>();
        yMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        if(xMap.containsKey(point[0])){
            if(xMap.get(point[0]).containsKey(point[1])){
                xMap.get(point[0]).put(point[1],xMap.get(point[0]).get(point[1])+1);
            }else{
                xMap.get(point[0]).put(point[1],1);
            }
        }else{
            xMap.put(point[0],new HashMap<>());
            xMap.get(point[0]).put(point[1],1);
        }

        if(yMap.containsKey(point[1])){
            if(yMap.get(point[1]).containsKey(point[0])){
                yMap.get(point[1]).put(point[0],yMap.get(point[1]).get(point[0])+1);
            }else{
                yMap.get(point[1]).put(point[0],1);
            }
        }else{
            yMap.put(point[1],new HashMap<>());
            yMap.get(point[1]).put(point[0],1);
        }
    }
    
    
    public int count(int[] point) {
        if(!xMap.containsKey(point[0]) || !yMap.containsKey(point[1]))
            return 0;
        
        if(xMap.get(point[0]).keySet().contains(point[1]) && xMap.get(point[0]).keySet().size() == 1)
            return 0;
        
        if(yMap.get(point[1]).keySet().contains(point[0]) && yMap.get(point[1]).keySet().size() == 1)
            return 0;
        
        int ans=0;
        
        for(int i:xMap.get(point[0]).keySet()){
            
            if(i == point[1])
                continue;
            
            int r = xMap.get(point[0]).get(i);
            
            for(int j:yMap.get(point[1]).keySet()){
                if(j == point[0])
                    continue;
                if(yMap.get(i).keySet().contains(j) && Math.abs(i-point[1]) == Math.abs(point[0] - j)){
                    ans+=r * yMap.get(point[1]).get(j) * yMap.get(i).get(j); 
                }
            }
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
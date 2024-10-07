class RandomizedCollection {
    List<Integer> arr;
    Map<Integer,Set<Integer>> map;
    int size;
    public RandomizedCollection() {
        arr = new ArrayList<>();
        map = new HashMap<>();
        size = 0;
    }
    
    public boolean insert(int val) {
        boolean ans = false;
        if(!map.containsKey(val)){
            ans = true;
            map.put(val,new HashSet<>());
        }
        if(size < arr.size()){
            arr.set(size,val);
        }else{
            arr.add(val);
        }
        map.get(val).add(size);
        size++;
        return ans;
    }
    
    public boolean remove(int val) {
        boolean ans = false;
        if(map.containsKey(val)){
            ans = true;
            
            int indx = map.get(val).iterator().next();
            if(map.get(val).size() == 1){
                map.remove(val);
            }else{
                map.get(val).remove(indx);
            }

            if(size == 1 || size -1 == indx){
                arr.set(size-1,Integer.MAX_VALUE);
            }else{
                
                arr.set(indx,arr.get(size -1));
                arr.set(size-1,Integer.MAX_VALUE);
                map.get(arr.get(indx)).remove(size-1);
                map.get(arr.get(indx)).add(indx);
            }
            size--;
             
        }
        return ans;
    }
    
    public int getRandom() {
        int random = (int)(Math.random() * size);
        return arr.get(random);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
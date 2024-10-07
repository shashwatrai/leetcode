
class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    int size;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }
    
    public boolean insert(int val) {
        boolean ans = false;
        if(!map.containsKey(val)){
            ans = true;
            if(size < list.size()){
                list.set(size,val);
            }else{
                list.add(val);   
            }  
            map.put(val,size);
            size++;
        }
        return ans;
    }
    
    public boolean remove(int val) {
        boolean ans = false;
        if(map.containsKey(val))  {
            ans = true;
            size--;
            if(size > 0){
                list.set(map.get(val),list.get(size));
                map.put(list.get(size),map.get(val));
            }
            list.set(size,Integer.MIN_VALUE); 
        }

        map.remove(val);
        return ans; 
    }
    
    public int getRandom() {
       
        int random = (int)(Math.random() * size);
        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;


    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean ans = false;
        if(!map.containsKey(val)){
            ans = true;
            list.add(val);
            map.put(val,list.size()-1);
        }
        return ans;
    }
    
    public boolean remove(int val) {
        boolean ans = false;
        if(map.containsKey(val))  {
            ans = true;
            list.set(map.get(val),Integer.MIN_VALUE); 
        }

        map.remove(val);
        return ans; 
    }
    
    public int getRandom() {
        if(map.size() < 1){
            return -1;
        }
        int random = (int)(Math.random() * list.size());

        while(random < list.size() && list.get(random) == Integer.MIN_VALUE){
            random = (int)(Math.random() * list.size());
        }
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
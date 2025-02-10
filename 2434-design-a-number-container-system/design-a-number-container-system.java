class NumberContainers {
    HashMap<Integer,Integer> indxToNo;
    Map<Integer,TreeSet<Integer>> noToIndx;
    public NumberContainers() {
        indxToNo = new HashMap<>();
        noToIndx = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indxToNo.containsKey(index)){
            int target = indxToNo.get(index);
            noToIndx.get(target).remove(index); 
        }
        if(!noToIndx.containsKey(number))
            noToIndx.put(number,new TreeSet<>());   
        indxToNo.put(index,number);
        noToIndx.get(number).add(index);
    }
    
    public int find(int number) {
        if(!noToIndx.containsKey(number) ||noToIndx.get(number).isEmpty())
            return -1;
        return noToIndx.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
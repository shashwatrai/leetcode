class Solution {
    public int preimageSizeFZF(int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        while(set.last() <= 1000000000){
            set.add(set.last() * 5 + 1);
        }

        while(k > 0){
            Integer key = set.floor(k);
            if(k / key == 5)
                return 0;
            k -= (k/key) * key;
        }

        return 5;
    }

    
}
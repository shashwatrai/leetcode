class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer,Integer> tMap = new TreeMap<>();

        for(int i: arr){
            tMap.put(i,0);
        }

        int rank = 0;
        for(int i: tMap.keySet()){
            tMap.put(i,++rank);
        }

        int res[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i] = tMap.get(arr[i]);
        }
        return res;

    }
}
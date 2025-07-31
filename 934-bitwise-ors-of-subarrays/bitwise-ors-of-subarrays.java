class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> all = new HashSet<>();

        Set<Integer> curr = new HashSet<>();

        for(int i =0 ;i<arr.length;i++){
            Set<Integer> temp = new HashSet<>();
            temp.add(arr[i]);
            for(int j:curr){
                temp.add(j|arr[i]);
            }
            curr = temp;
            all.addAll(curr);
        }
        return all.size();
    }
}
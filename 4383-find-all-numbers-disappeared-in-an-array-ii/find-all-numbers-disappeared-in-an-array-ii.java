class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        TreeSet<Integer> tset = new TreeSet<>();
        for(int i: nums)
            tset.add(i);
 
        List<List<Integer>> ans = new ArrayList<>();

        while(lower <= upper){
            if(tset.contains(lower)){
                lower++;
                continue;
            }

            Integer ceil = tset.ceiling(lower);
            if(ceil == null){
                ans.add(Arrays.asList(lower, upper));
                break;
            }else{
                if(ceil > upper){
                    ans.add(Arrays.asList(lower, upper));
                    break;
                }else{
                    ans.add(Arrays.asList(lower, ceil-1));
                    lower = ceil;
                }
            }
            
        }
        return ans;
    }
}
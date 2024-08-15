class Solution {
    public void helper(int []candidates, int indx,List<List<Integer>> res,List<Integer> temp,int target){
        if(target == 0 || indx  == candidates.length){
            if(target == 0)
                res.add(new ArrayList<>(temp));
            
            return ;

        }

        for(int i=indx;i<candidates.length;i++){
            if(i > indx && candidates[i] == candidates[i-1])
                continue;
            if(target < candidates[i])
                return;
            temp.add(candidates[i]);
            helper(candidates,i+1,res,temp,target-candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        helper(candidates,0,res,new ArrayList<>(),target);
        return res;
    }
}
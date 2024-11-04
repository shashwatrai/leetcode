class Solution {

    public void solver(int []candidates,int indx, int target,List<Integer> ans,List<List<Integer>> res){
        if(target  == 0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(indx == candidates.length)
            return;
        
        for(int i=indx;i<candidates.length;i++){
            if(i > indx && candidates[i] == candidates[i-1])
                continue;
            if(candidates[i] > target)
                return;
            ans.add(candidates[i]);
            solver(candidates,i+1,target-candidates[i],ans,res);
            ans.remove(ans.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res= new ArrayList<>();
        solver(candidates,0,target,new ArrayList<>(),res);
        return res;
    }
}
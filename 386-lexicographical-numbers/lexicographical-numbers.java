class Solution {
    public void helper(List<Integer> ans,int start,int prev,int n){
        
        for(int i= start;i<10;i++){
            int temp = prev*10 + i;
            if(temp > n)
                break;
            ans.add(temp);
            helper(ans,0,temp,n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans= new ArrayList<>();
        helper(ans,1,0,n);
        return ans;
    }
}
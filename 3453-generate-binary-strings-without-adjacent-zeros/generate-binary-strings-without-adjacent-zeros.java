class Solution {
    public void solve(int indx,int end,StringBuilder stb,List<String> arr){
        if(indx == end){
            arr.add(stb.toString());
            return;
        }

        if(indx == 0 || (stb.charAt(indx-1) != '0')){
            stb.append('0');
            solve(indx+1,end,stb,arr);
            stb.setLength(stb.length()-1);
        }
        stb.append('1');
        solve(indx+1,end,stb,arr);
        stb.setLength(stb.length()-1);
    }
    public List<String> validStrings(int n) {
        StringBuilder stb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        solve(0,n,stb,ans);
        return ans;
    }
}
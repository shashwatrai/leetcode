class Solution {
    public boolean helper(String a, String b){
        int n = a.length();
        int m = b.length();

        boolean ans = false;
        int i =0 ,j=0;
        while(i<n && j<m){
            if(a.charAt(i) != b.charAt(j)){
                if(b.charAt(j) >= 'A' && b.charAt(j) <='Z'){
                    return false;
                }else
                    j++;
            }else{
                i++;
                j++;
            }
        }
        if(i == n && j ==m )
            return true;
        else if(i == n){
            for(;j<m;j++){
                if(b.charAt(j) >= 'A' && b.charAt(j) <='Z'){
                    return false;
                }
            }
            return true;
        }else
            return false;
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for(String s:queries){
            ans.add(helper(pattern,s));
        }
        return ans;
    }
}
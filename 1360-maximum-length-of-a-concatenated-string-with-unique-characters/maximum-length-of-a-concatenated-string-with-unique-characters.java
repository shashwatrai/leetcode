class Solution {
    public int setBitCount(int n){
        int cnt=0;
        while(n>0){
            if((n&1) == 1)  
                cnt++;
            n>>=1;
        }
        return cnt;
    }
    public int solve(List<String> arr,int indx,int dp[],int tracker){
        if(arr.size() == indx){
            return 0;
        }

        
        int chars = 0;
        for(int i=0;i<arr.get(indx).length();i++){
           
            chars |= 1 << ((int)(arr.get(indx).charAt(i) - 'a'));
        }   
        
        int with = 0;

        if(setBitCount(chars) == arr.get(indx).length() && ((chars & tracker) == 0))
            with= chars | solve(arr,indx+1,dp,tracker|chars);

        int without = solve(arr,indx+1,dp,tracker);
        // System.out.println(arr.get(indx)+" "+setBitCount(chars)+" "+tracker+" "+with+" "+without);
        if(setBitCount(with) > setBitCount(without)){
            dp[indx] = with;
        }else
            dp[indx] = without;
        
        return dp[indx];
        
    }
    public int maxLength(List<String> arr) {
        return  setBitCount(solve(arr,0,new int[arr.size()],0));
    }
}
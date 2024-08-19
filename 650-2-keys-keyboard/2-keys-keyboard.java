class Solution {
    public int minSteps(int n) {
        if(n==1)
            return 0;
        boolean []isNotPrime= new boolean[n+1];
        int []ans =new int[n+1];

        isNotPrime[0]= isNotPrime[1] = true;
        for(int i=2;i<=n;i++){
            if(!isNotPrime[i]){
                ans[i] = i;
                for(int j=i+i;j<=n;j+=i){
                    isNotPrime[j] = true;
                }    
            }
        }
        for(int i=2;i<ans.length;i++){
            if(!isNotPrime[i])
                continue;
            ans[i] = i;
            for(int j=2;j<=n/2;j++){
                if(i%j == 0)
                    ans[i] = Math.min(ans[i],ans[j] + i/j);
            }
        }
        
        return ans[n];
    }
}
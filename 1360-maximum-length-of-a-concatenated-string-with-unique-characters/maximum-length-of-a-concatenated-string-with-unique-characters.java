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
    public int solve(List<String> arr,int indx,int tracker){
        if(arr.size() == indx){
            return 0;
        }

        int chars = 0;
        for(int i=0;i<arr.get(indx).length();i++){
           
            chars |= 1 << ((int)(arr.get(indx).charAt(i) - 'a'));
        }   
        
        int with = 0;

        if(setBitCount(chars) == arr.get(indx).length() && ((chars & tracker) == 0))
            with= chars | solve(arr,indx+1,tracker|chars);

        int without = solve(arr,indx+1,tracker);
        
        if(setBitCount(with) > setBitCount(without)){
            return with;
        }else
            return without;
        
        
    }
    public int maxLength(List<String> arr) {

        return  setBitCount(solve(arr,0,0));
    }
}
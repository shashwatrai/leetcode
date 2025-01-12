class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = locked.length();
        if(n%2 == 1)
            return false;

        
        int count=0;
        int bCount=0;
        for(int i=0;i<n;i++){
            if(locked.charAt(i) == '1' && s.charAt(i) == ')'){
                count++;
            }else{
                bCount++;
            }
            
            if(count > bCount)
                return false;
        }

        count=bCount=0;

        for(int i=n-1;i>=0;i--){
            if(locked.charAt(i) == '1' && s.charAt(i) == '('){
                count++;
            }else{
                bCount++;
            }
            
            if(count > bCount)
                return false;
        }
        return true;
    }
}
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1) == '1')
            return false;

        int prefix[] = new int[s.length()];
        int cnt=0;
        for(int i=0;i<prefix.length;i++){
            if(i > 0)
                prefix[i] += prefix[i-1];
            if(s.charAt(i) == '0' && (i ==0 ||  prefix[i] - cnt > 0)){
                prefix[i] += 1;
                cnt++;
                if(i+minJump < s.length())
                    prefix[i+minJump] += 2;
                if(i+maxJump + 1 < s.length())
                    prefix[i+maxJump+1] += -2;
            }
        
        }
        // System.out.println(Arrays.toString(prefix));
        return prefix[prefix.length - 1] - cnt  > 0;

    }
}
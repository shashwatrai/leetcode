class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int start = -1;
        int prevCount =0;
        int end =0;
        int curr=0;
        int ans = Integer.MAX_VALUE;
        
        while(end < n){
            
            if(blocks.charAt(end) == 'W')
                curr++;
            // System.out.println(end+" "+curr+" "+start+" "+prevCount+" "+ans);
            if(k+start == end){
                ans = Math.min(ans,curr-prevCount);
            }

            end++;
            if(k+start < end){
                start++;
                if(start < n && blocks.charAt(start) == 'W')
                    prevCount++;
            }
        }
        return ans;
    }
}
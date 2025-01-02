class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        int maxReach = 0;
        boolean vis[]  = new boolean[s.length()];
        while(!queue.isEmpty()){
            int curr = queue.poll();

            if(curr == s.length() - 1){
                return true;
            }

            
            for(int i= Math.max(maxReach,curr+minJump) ; i < Math.min(s.length(),curr+maxJump+1); i++){
                if(!vis[i] && s.charAt(i) == '0'){
                    queue.add(i);
                    vis[i] =  true;
                }
            }
            maxReach = Math.max(maxReach,curr+maxJump+1);

        }
        return false;

    }
}
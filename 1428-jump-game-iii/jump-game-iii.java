class Solution {
    public boolean canReach(int[] arr, int start) {
        

        int n = arr.length;

        Queue<Integer> q = new ArrayDeque<>();
        boolean vis[] = new boolean[n];
        q.add(start);
        vis[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            
            if(arr[curr] == 0)
                return true;

            
            if(curr - arr[curr] >= 0 && !vis[curr - arr[curr]]){
                q.add(curr - arr[curr]);
                vis[curr - arr[curr]] = true;
            }

            if(curr + arr[curr] < n && !vis[curr + arr[curr]]){
                q.add(curr + arr[curr]);
                vis[curr + arr[curr]] = true;
            }

        }
        return false;
    }
}
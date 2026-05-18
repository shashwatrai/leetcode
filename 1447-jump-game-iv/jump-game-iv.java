class Solution {
    public int minJumps(int[] arr) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean vis[] = new boolean[n];
        int count = 0;
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int t = q.size();
            while(t-- > 0){
                int curr = q.poll();

                if(curr == n-1)
                    return count;

                if(curr +  1< n && !vis[curr+1]){
                    q.add(curr + 1);
                    vis[curr + 1] = true;
                }
                if(curr > 0 && !vis[curr - 1]){
                    q.add(curr - 1);
                    vis[curr - 1] = true;
                }

                if(map.containsKey(arr[curr])){
                    for(int i: map.get(arr[curr])){
                        if(i != curr && !vis[i]){
                            q.add(i);
                            vis[i] = true;
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            count++;
        }
        return -1;
    }
}
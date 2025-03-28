class Solution {
    public void traverse(int [][]grid,List<int[]> start,int []count,int target,TreeMap<Integer,List<int[]>> map){
        Queue<int[]> queue = new LinkedList<>();

        for(int []i:start){
            queue.add(i);
            grid[i[0]][i[1]] =0;
        }
        // System.out.print(queue.size()+" ");        
        while(!queue.isEmpty()){
            int []curr = queue.poll();
            int x = curr[0],y = curr[1];
            count[0]++;
            // System.out.println(target+" "+x+" "+y+" "+count[0]+" "+map); 
            if(x + 1 < grid.length && grid[x+1][y]!=0){
                if(Math.abs(grid[x+1][y]) <= target ){
                    queue.add(new int[]{x+1,y});
                    grid[x+1][y]=0;
                }else{
                    if(grid[x+1][y] > 0){
                        if(!map.containsKey(grid[x+1][y])){
                            map.put(grid[x+1][y],new ArrayList<>());
                        }
                        map.get(grid[x+1][y]).add(new int[]{x+1,y});
                        grid[x+1][y] *= -1;
                    }
                }
            }
            if(x - 1 >= 0 && grid[x-1][y]!=0){
                if(Math.abs(grid[x-1][y]) <= target ){
                    queue.add(new int[]{x-1,y});
                    grid[x-1][y]=0;
                }else{
                    if(grid[x-1][y] > 0){
                        if(!map.containsKey(grid[x-1][y])){
                            map.put(grid[x-1][y],new ArrayList<>());
                        }
                        map.get(grid[x-1][y]).add(new int[]{x-1,y});
                        grid[x-1][y] *= -1;
                    }
                }
            }
            if(y + 1 < grid[0].length && grid[x][y+1]!=0){
                if(Math.abs(grid[x][y+1]) <= target ){
                    queue.add(new int[]{x,y+1});
                    grid[x][y+1]=0;
                }else{
                    if(grid[x][y+1] > 0){
                        if(!map.containsKey(grid[x][y+1])){
                            map.put(grid[x][y+1],new ArrayList<>());
                        }
                        map.get(grid[x][y+1]).add(new int[]{x,y+1});
                        grid[x][y+1] *= -1;
                    }
                }
            }
            if(y - 1 >= 0 && grid[x][y-1]!=0){
                if(Math.abs(grid[x][y-1]) <= target ){
                    queue.add(new int[]{x,y-1});
                    grid[x][y-1]=0;
                }else{
                    if(grid[x][y-1] > 0){
                        if(!map.containsKey(grid[x][y-1])){
                            map.put(grid[x][y-1],new ArrayList<>());
                        }
                        // System.out.println(target+" "+x+" "+y+" "+grid[x][y-1]);
                        map.get(grid[x][y-1]).add(new int[]{x,y-1});
                        grid[x][y-1] *= -1;
                    }
                }
            }
        }
        // System.out.println(count[0]+" "+target);
    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        int len =0;
        for(int i[]:grid)
            for(int j:i)
                len = Math.max(j,len);
        int arr[] = new int[len+1];
        List<int []> points = new ArrayList<>();
        points.add(new int[]{0,0});
        map.put(grid[0][0],points);
        int count[]=new int[1];
        // System.out.println(map);
        // System.out.println(map.firstKey());
        for(int i=1;i<=len;i++){
            // if(!map.isEmpty())
            //     System.out.println(map.firstKey()+" "+(i ==  map.firstKey()));
            arr[i] = count[0];
            if(!map.isEmpty() && i ==  map.firstKey()){
                traverse(grid,map.get(map.firstKey()),count,i,map);
                map.remove(map.firstKey());
            }
            // System.out.println(i+" "+map+" "+count[0]);
            
        }

        int ans[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i] = count[0];
            if(len >=  queries[i])
                ans[i] = arr[queries[i]];
        }
        
        return ans;
    }
}
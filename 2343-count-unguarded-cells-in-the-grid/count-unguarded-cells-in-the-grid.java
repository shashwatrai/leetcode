class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][]arr = new int[m][n];

        for(int i[]:arr)
            Arrays.fill(i,-2);

        for(int i=0;i<walls.length;i++){
            arr[walls[i][0]][walls[i][1]] = -1;
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<guards.length;i++){
            queue.add(new int[]{guards[i][0],guards[i][1],4});
            arr[guards[i][0]][guards[i][1]] = 4;
        }

        while(!queue.isEmpty()){
            int []curr = queue.poll();
            // System.out.println(Arrays.toString(curr));
            int dir[][] = {{0,-1},{1,0},{0,1},{-1,0}};

            if(curr[2] == 4){
                for(int i=0;i<4;i++){
                    int x = curr[0] + dir[i][0];
                    int y = curr[1] + dir[i][1];

                    if(x < 0 || x >=m || y < 0 || y >= n || arr[x][y] == -1 || arr[x][y] == i || arr[x][y] == 4){
                        continue;
                    }
                    arr[x][y] = i;
                    queue.add(new int[]{x,y,i});
                    // System.out.println(x+" "+y+" "+i);
                }
            }else{
                int x = curr[0] + dir[curr[2]][0];
                int y = curr[1] + dir[curr[2]][1];

                if(x < 0 || x >=m || y < 0 || y >= n || arr[x][y] == -1 || arr[x][y] == curr[2] || arr[x][y] == 4){
                    continue;
                }
                arr[x][y] = curr[2];
                queue.add(new int[]{x,y,curr[2]});
            }
        }
        int ans=0;
        for(int i[]:arr){
            // System.out.println(Arrays.toString(i));
            for(int j: i)
                if(j == -2)
                    ans++;
        }
        return ans;
    }
}
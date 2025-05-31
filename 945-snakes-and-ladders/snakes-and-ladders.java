class Solution {
    public int snakesAndLadders(int[][] board) {
        for(int i = board.length-2;i >= 0;i-=2){
            int l = 0, r= board[i].length-1;
            while(l<r){
                int temp = board[i][l];
                board[i][l] = board[i][r];
                board[i][r] = temp;
                l++;
                r--;
            }
        }
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean dist[][] = new boolean[n][n];
        queue.add(1);
        dist[n-1][0] = true;
        int cnt = 0;
        while(  !queue.isEmpty()){
            int l = queue.size();
           
            while(l--  > 0){
                int curr = queue.poll();
                if(curr == n*n)
                    return cnt;
                for(int t = curr+ 1;t<=6+curr && t <= n*n ;t++){
                    
                    int r = n - 1 - (t-1)/n;
                    int c = t - n *((t-1)/n) - 1;
                    
                    
                    // System.out.println(t+" "+r+" "+c);
                    if(board[r][c] != -1){
                        int r1 = n - 1 - (board[r][c]-1)/n;
                        int c1 = board[r][c] - n * ((board[r][c]-1)/n) - 1;
                        // System.out.println(board[r][c]+" "+r1+" "+c1+" "+dist[r1][c1]);
                        if(!dist[r1][c1]){
                            queue.add(board[r][c]);
                            dist[r1][c1]= true;
                        } 
                    }else{
                        if(!dist[r][c] ){
                            queue.add(t);
                            dist[r][c]=true;
                        }
                    }
                    
                }  
            }
            cnt++;
             System.out.println(cnt+":"+queue);
        }
        return -1;
    }
}
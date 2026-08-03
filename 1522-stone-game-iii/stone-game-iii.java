class Node {
    int start,end,turn;

    Node(int start,int end,int turn){
        this.start = start;
        this.end = end;
        this.turn = turn;
    }

    public boolean equals(Object o){
        if(o instanceof Node){
            Node n = (Node)o;
            return this.start == n.start && this.end == n.end && this.turn == n.turn;
        }
        return false;
    }
    
    public int hashCode() {
        return start * 31 + end * 31 + turn;
    }
}

class Solution {

    public int solve(int []stoneValue, int prefixSum[], int start, int end, int turn, Map<Node, Integer> dp){
    

        if(start > end){
            return 0;
        }

        Node node = new Node(start, end, turn);
        if(dp.containsKey(node)){
            return dp.get(node);
        }

        if(start == end){
            dp.put(node, stoneValue[start]);
            return stoneValue[start];
        }

        int sum = prefixSum[end] - (start == 0 ? 0 : prefixSum[start-1]);

        int result = Math.max( sum - solve(stoneValue,prefixSum, start+1, end, 1-turn, dp), 
                                Math.max( start+1 > end ? -1000_000_000 :  sum - solve(stoneValue,prefixSum, start+2, end, 1-turn, dp),
                                start+2 > end ? -1000_000_000 :  sum - solve(stoneValue,prefixSum, start+3, end, 1-turn, dp)));
        dp.put(node, result);
        return result;
    }
                                
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int prefixSum[] = new int[n];
        prefixSum[0] = stoneValue[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + stoneValue[i];
        }

        Map< Node, Integer> dp = new HashMap<>();
       
        int alicScore = solve(stoneValue, prefixSum, 0, n-1, 0, dp);
        if(alicScore * 2 == prefixSum[n-1]){
            return "Tie";
        }
        return alicScore * 2 > prefixSum[n-1] ? "Alice" : "Bob";
    }
}
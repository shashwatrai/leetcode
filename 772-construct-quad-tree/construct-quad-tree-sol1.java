/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node helper(int [][]grid,int r1,int c1, int r2, int c2){
        int cnt0,cnt1;
        cnt0 = cnt1 = 0;
        boolean isLeaf = true;
        
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                if(cnt0 > 0 && cnt1 > 0){
                    isLeaf = false;
                    break;
                }
                if(grid[i][j] == 1)
                    cnt1++;
                else
                    cnt0++;
            }
            if(!isLeaf)
                break;
        }
        boolean val = cnt1 > 0 && cnt0 == 0? true:false;
        Node curr = new Node(val,isLeaf);
        if(!isLeaf){
            curr.topLeft = helper(grid,r1,c1,r1 + (r2-r1+1)/2 -1,c1 + (c2-c1+1)/2 -1);
            curr.topRight = helper(grid,r1,c1 + (c2-c1+1)/2 ,r1 + (r2-r1+1)/2 - 1 ,c2);
            curr.bottomLeft = helper(grid,r1 + (r2-r1+1)/2,c1,r2,c1 + (c2-c1+1)/2 -1);
            curr.bottomRight = helper(grid,r1 + (r2-r1+1)/2 ,c1 + (c2-c1+1)/2 ,r2,c2);
        }
        return curr;
    }
    public Node construct(int[][] grid) {
        return helper(grid,0,0,grid.length-1,grid.length-1);
    }
}

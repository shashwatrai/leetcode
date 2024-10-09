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

        if(r1 == r2){
            return new Node(grid[r1][c1] == 1 ? true:false,true);
        }

        
        Node topLeft = helper(grid,r1,c1,r1 + (r2-r1+1)/2 -1,c1 + (c2-c1+1)/2 -1);
        Node topRight = helper(grid,r1,c1 + (c2-c1+1)/2 ,r1 + (r2-r1+1)/2 - 1 ,c2);
        Node bottomLeft = helper(grid,r1 + (r2-r1+1)/2,c1,r2,c1 + (c2-c1+1)/2 -1);
        Node bottomRight = helper(grid,r1 + (r2-r1+1)/2 ,c1 + (c2-c1+1)/2 ,r2,c2);
    
        if( topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf 
         && !( (topLeft.val ^ topRight.val) || (topLeft.val ^ bottomLeft.val) || (topLeft.val ^ bottomRight.val) )){
            return new Node(topLeft.val , true);
         }else{
            return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
         }
        
    }
    public Node construct(int[][] grid) {
        return helper(grid,0,0,grid.length-1,grid.length-1);
    }
}
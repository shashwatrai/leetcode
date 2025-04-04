/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode ans;
    int d=-1;
}
class Solution {
    public int traverse(TreeNode root, int d,Pair p){
        if(root == null)
            return 0;

        int left = traverse(root.left,d+1,p);
        int right = traverse(root.right,d+1,p);
        // System.out.println(root.val+" "+left+" "+right+" "+(Math.max(left,right)+d));
        if(left == right && left+d > p.d ){
            p.d = d + Math.max(left,right);
            p.ans = root;
        }else if(left == right && left+d == p.d ){
            p.d = -1;
            p.ans = null;
        }
        // if(p.d != -1){
        //     System.out.println(p.ans.val+" "+p.d);
        // }
        return Math.max(left,right)+1;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair ans = new Pair();
        traverse(root,0,ans);
        return ans.ans;
    }
}
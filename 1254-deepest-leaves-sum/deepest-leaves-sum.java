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
class Solution {
    public void solve(TreeNode root, int level,int []sum){
        if(root == null)
            return;

        if(level > sum[0]){
            sum[0] = level;
            sum[1] = root.val;
        }else if(level == sum[0]){
            sum[1] += root.val;
        }
        solve(root.left,level+1,sum);
        solve(root.right,level+1,sum);
    }
    public int deepestLeavesSum(TreeNode root) {
        int sum[] = new int[2];
        sum[0]=sum[1] = -1;
        solve(root,0,sum);
        return sum[1];
    }
}
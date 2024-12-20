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
    public void traverse(TreeNode root,Map<Integer,Stack<Integer>> map,int level ){
        if(root == null)
            return ;
        
        if(level%2 == 1){
            if(!map.containsKey(level)){
                map.put(level,new Stack<>());
            }
            map.get(level).push(root.val);
        }
        traverse(root.left,map,level+1);
        traverse(root.right,map,level+1);
    }
    public void fill(TreeNode root,Map<Integer,Stack<Integer>> map,int level){
        if(root == null)
            return;
        
        if(map.containsKey(level)){
            root.val = map.get(level).pop();
        }
        fill(root.left,map,level+1);
    
        fill(root.right,map,level+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Map<Integer,Stack<Integer>> map = new HashMap<>();

        traverse(root,map,0);
        fill(root,map,0);
        return root;
    }
}
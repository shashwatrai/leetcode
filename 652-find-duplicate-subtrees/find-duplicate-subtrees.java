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

    public String traverse(TreeNode root, Map<String,Integer> freq,Map<String,TreeNode> map){
        if(root == null)
            return "";
        
        String left = traverse(root.left,freq,map);
        String right = traverse(root.right,freq,map);

        String key = left+"_"+right+"_"+Integer.valueOf(root.val).toString();
        freq.put(key,freq.getOrDefault(key,0)+1);
        map.put(key,root);
        return key;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String,Integer> freq = new HashMap<>();
        Map<String,TreeNode> map = new HashMap<>();
        traverse(root,freq,map);
        for(String s: freq.keySet()){
            if(freq.get(s) > 1){
                ans.add(map.get(s));
            }
        }
        return ans;
    }
}
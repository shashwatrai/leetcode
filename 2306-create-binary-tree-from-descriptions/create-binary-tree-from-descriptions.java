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
    public int find(int a, int []parent){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a],parent);
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode []add = new TreeNode[1_000_01];
        int []parent = new int[1_000_01];
        Set<Integer> set = new HashSet<>();
        for(int i[]:descriptions){
            set.add(i[0]);
            set.add(i[1]);
        }

        for(int i:set){
            parent[i] = i;
            add[i] = new TreeNode(i);
        }

        for(int i=0;i<descriptions.length;i++){
            parent[descriptions[i][1]] = descriptions[i][0];
            if(descriptions[i][2] == 1){
                add[descriptions[i][0]].left = add[descriptions[i][1]];
            }else{
                add[descriptions[i][0]].right = add[descriptions[i][1]];
            }
        }

        for(int i:set){
            return add[find(i,parent)];
        }
        return null;
    }
}
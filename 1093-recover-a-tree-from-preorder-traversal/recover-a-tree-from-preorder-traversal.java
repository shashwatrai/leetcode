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
    public TreeNode recoverFromPreorder(String traversal) {
        List<Integer> vals = new ArrayList<>();
        List<Integer> levels = new ArrayList<>();

        StringBuilder stb = new StringBuilder();
        int cnt =0;
        for(int i=0;i<traversal.length();i++){
            if(Character.isDigit(traversal.charAt(i))){
                while(i < traversal.length() && traversal.charAt(i) != '-'){
                    stb.append(traversal.charAt(i++));
                }
                vals.add(Integer.parseInt(stb.toString()));
                levels.add(cnt);
                stb.setLength(0);
                if(i < traversal.length())
                    cnt = 1;
                else
                    cnt =0;
            }else
                cnt++;
        }

        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for(int i=0;i<vals.size();i++){
            while(!st2.isEmpty() && levels.get(st2.peek()) >= levels.get(i)){
                TreeNode temp = st1.pop();
                st2.pop();
                if(st1.peek().left == null)
                    st1.peek().left = temp;
                else
                    st1.peek().right = temp;
            }
            st2.push(i);
            st1.push(new TreeNode(vals.get(i))); 
        }

        while(!st1.isEmpty()){
            TreeNode temp = st1.pop();
            if(st1.isEmpty())
                return temp;
            if(st1.peek().left == null)
                st1.peek().left = temp;
            else
                st1.peek().right = temp;
        }
        return null;
    }
}
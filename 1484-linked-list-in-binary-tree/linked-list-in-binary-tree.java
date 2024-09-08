/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public boolean helper(TreeNode root,int k , int []pi, ListNode[] pattern ){
        if(k+1 == pi.length)
            return true;
        if(root == null)
            return false;

        while(k != -1 && pattern[k+1].val != root.val)
            k = pi[k];
        if(pattern[k+1].val == root.val)
            k++;

        boolean left = helper(root.left,k,pi,pattern);
        
        boolean right = helper(root.right,k,pi,pattern);
        return left || right;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        int size = 0;
        ListNode temp = head;
        while(temp!= null){
            temp = temp.next;
            size++;
        }
        ListNode curr = head;
        int []pi = new int[size];
        ListNode []pattern = new ListNode[size];
        int k = -1;
        pi[0] = -1;
        pattern[0] = curr;
        for(int i=1;i<size;i++){
            curr = curr.next;
            pattern[i] = curr;
            while(k != -1 && pattern[k+1].val != curr.val){
                k = pi[k]; 
            }
            if(pattern[k+1].val == curr.val){
                k++;
            }
            pi[i] = k;
        }
        return helper(root,-1,pi,pattern);
    }
}
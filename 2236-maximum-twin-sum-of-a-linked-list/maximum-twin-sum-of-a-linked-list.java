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
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<Integer> q= new Stack<>();
        while(fast != null){
            q.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        int max = -1;
        while(slow != null){
            max = Math.max(max, slow.val + q.pop());
            slow = slow.next;
        }
        return max;
    }
}
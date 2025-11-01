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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;
        while(head != null){
            if(!set.contains(head.val)){
                curr.next = head;
                curr = head;
            }
            head = head.next;
            
        }
        curr.next = null;
        return newHead.next;
    }
}
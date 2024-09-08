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
        ListNode pHead = new ListNode(-1,head);

        ListNode prev = pHead;
        while(head != null){
            if(set.contains(head.val)){
                prev.next = head.next;
                
            }else{
                prev = head;
            }
            head = head.next;
        }
        return pHead.next;
    }
}
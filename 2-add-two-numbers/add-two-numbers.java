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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp ,head;
        temp = head = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val = (l1 != null ? l1.val : 0) +  (l2 != null ? l2.val : 0);
            
            if(l1 != null){
                if(head == null){
                    temp = head  = l1;
                }else{
                    temp.next = l1;
                    temp = l1;
                }
                
            }else if(l2 != null){
                if(head == null){
                    temp = head  = l2;
                }else{
                    temp.next = l2;
                    temp = l2;
                }
            }else{
                if(head == null){
                    temp = head  = new ListNode(0,null);
                }else{
                    temp.next = new ListNode(0,null);
                    temp = temp.next;
                } 
            }

            temp.val = (val + carry)%10;
            carry = (val+carry)/10;
            if(l1 != null)
                l1= l1.next;

            if(l2!= null)
                l2 = l2.next;
        }
        if(carry != 0){
            temp.next = new ListNode(carry,null);

        }
        return head;
    }
}
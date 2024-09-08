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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode []ans = new ListNode[k];
        if(head == null)
            return ans;
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        int np = size/k;
        int rp = size%k;
        ListNode prev = null;
        temp = head;
        for(int i=0;i<k;i++){
            int rS = np+(rp-- > 0 ? 1:0)  ;
            ans[i] = temp;
            while(rS-- > 0){
                
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }
        return ans;
    }
}
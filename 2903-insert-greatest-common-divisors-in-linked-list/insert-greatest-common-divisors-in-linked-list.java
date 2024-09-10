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
    public int gcd(int a,int b){
        if(b > a)
            return gcd(b,a);
        if(a%b == 0)
            return b;
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        while(curr!= null){
            ListNode temp = new ListNode(gcd(prev.val,curr.val),curr);
            prev.next = temp;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
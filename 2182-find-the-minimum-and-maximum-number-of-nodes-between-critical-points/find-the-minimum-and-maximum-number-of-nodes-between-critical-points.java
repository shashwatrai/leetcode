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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int startPos= -1,  currPos = -1;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        int count =0;
        int minDist = Integer.MAX_VALUE;
        while(curr != null && next != null){
            if(prev != null){
                if((prev.val < curr.val && curr.val > next.val) ||
                    (prev.val > curr.val && curr.val < next.val)){
                    if(startPos == -1)
                        startPos = count;
                    if(currPos != -1)
                        minDist = Math.min(count - currPos,minDist);
                    currPos = count;
                }
            }
            prev = curr;
            curr = next;
            next = next.next;
            count++;
        }

        if(minDist == Integer.MAX_VALUE)
            return new int[]{-1,-1};
        return new int[]{minDist, currPos-startPos};
    }
}
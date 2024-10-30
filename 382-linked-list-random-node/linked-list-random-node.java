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

    
    ListNode head;
    Random r;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        ListNode temp = head.next;
        ListNode random = head;
        Random r = new Random();
        int cnt = 1 ;
        while(temp != null){
            int indx = r.nextInt(1 + cnt++);
            
            if(indx == 0){
                random = temp;
            }
            temp = temp.next;
        }
        return random.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
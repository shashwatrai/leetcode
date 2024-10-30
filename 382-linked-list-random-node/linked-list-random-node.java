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

    
    List<Integer> arr;
    Random r;
    public Solution(ListNode head) {
        arr = new ArrayList<>();
        while(head != null){
            arr.add(head.val);
            head= head.next;
        }
        r = new Random();
    }
    
    public int getRandom() {
        int indx = r.nextInt(arr.size());
        return arr.get(indx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
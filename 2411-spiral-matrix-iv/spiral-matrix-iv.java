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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int matrix[][] = new int[m][n];
        for(int i[] : matrix)
            Arrays.fill(i,-1);
        int r =0 ;
        while(head != null){
            int x = r,y =r;
            while(y < n-r && head != null){
                matrix[x][y++] = head.val;
                head = head.next;
            }
            if(y == n-r){
                y--;
                x++;
            }
            while(x < m-r && head != null){
                matrix[x++][y] = head.val;
                head = head.next;
            }
            if(x == m-r){
                x--;
                y--;
            }
            while(y >= r && head != null){
                matrix[x][y--] = head.val;
                head = head.next;
            }
            if(y == r-1){
                y++;
                x--;
            }
            while(x > r && head != null){
                matrix[x--][y] = head.val;
                head = head.next;
            }
            r++;
        }
        return matrix;
    }
}
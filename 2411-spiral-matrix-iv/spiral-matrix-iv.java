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
        int mat[][] = new int[m][n];
        for(int i[]:mat){
            Arrays.fill(i ,-1);
        }
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int currD = 0;
        int x=0,y=0;
        while(head != null){
            mat[x][y]  =  head.val;
            int i = x+dir[currD][0];
            int j = y+dir[currD][1];
            if(i == m || j == n || i < 0 || j < 0 || mat[i][j] > -1){
                currD = (currD+1)%4;
            }
            x+=dir[currD][0];
            y+=dir[currD][1];
            System.out.println(currD+" "+i+" "+j+" "+x+" "+y);
            head = head.next;
        }
        return mat;
    }
}
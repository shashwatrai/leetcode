class TrieNode{
    TrieNode []childs;
    boolean isEnd;
    TrieNode(){
        this.childs = new TrieNode[10];
    }
}
class Solution {
    public void add(TrieNode root, String s){
        TrieNode curr = root;
        for(int i=0;i<s.length();i++){
            if(curr.childs[s.charAt(i) - '0'] == null){
                curr.childs[s.charAt(i) - '0'] = new TrieNode();
            }
            curr = curr.childs[s.charAt(i) - '0'];
            if(i == s.length()-1)
                curr.isEnd = true;
        }
    }
    public int findPrefix(TrieNode root,String s){

        TrieNode curr = root;
        int count=0;
        for(int i=0;i<s.length();i++){
            // System.out.println(count +" "+curr);
            if(curr == null )
                return count;
            curr = curr.childs[s.charAt(i)-'0'];
            if(curr != null)
                count++;
        }
        return count;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();

        for(int i:arr1){
            add(root,Integer.valueOf(i).toString());
        }

        int min = 0;
        for(int i:arr2){
            min = Math.max(min,findPrefix(root,Integer.valueOf(i).toString()));
        }
        return min;
    }
}
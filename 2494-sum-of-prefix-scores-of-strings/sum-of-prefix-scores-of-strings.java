class TrieNode{
    int count;
    TrieNode childs[] ;

    TrieNode(){
        childs = new TrieNode[26];
    }
}

class Solution {
    public void add(TrieNode root, String s){
        TrieNode curr = root;

        for(int i=0;i<s.length();i++){
            if(curr.childs[s.charAt(i)-'a'] == null){
                curr.childs[s.charAt(i)-'a'] = new TrieNode();
            }
            
            curr = curr.childs[s.charAt(i) - 'a'];
            curr.count +=1;
        }

    }
    public int findPrefix(TrieNode root,String s){
        TrieNode curr = root;
        int prefix =0;
        for(int i=0;i<s.length();i++){
            prefix += curr.childs[s.charAt(i)-'a'].count;
            curr = curr.childs[s.charAt(i)-'a'];
        }
        return prefix;
    }
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();

        for(String i: words){
            add(root,i);
        }
        int ans[] = new int[words.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = findPrefix(root,words[i]);
        } 
        return ans;
    }
}
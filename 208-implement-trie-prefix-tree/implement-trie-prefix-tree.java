class TrieNode{
    TrieNode []childs;
    boolean wordEnd;

    TrieNode(){
        childs = new TrieNode[26];
        wordEnd = false;
    }
}

class Trie {

    TrieNode trie;
    public Trie() {
        trie  = new TrieNode();
    }
    
    public void insert(String word) {
    
        TrieNode root = trie;
        for(char c : word.toCharArray()){
            if(root.childs[c-'a'] == null){
                root.childs[c-'a'] = new TrieNode();
            }
            root = root.childs[c-'a'];
        }
        root.wordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode root = trie;
        for(char c : word.toCharArray()){
            if(root.childs[c-'a'] == null){
                return false;
            }
            root = root.childs[c-'a'];
        }
        return root.wordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode root = trie;
        for(char c : prefix.toCharArray()){
            if(root.childs[c-'a'] == null){
                return false;
            }
            root = root.childs[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
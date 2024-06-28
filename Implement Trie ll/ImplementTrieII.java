import java.util.* ;
import java.io.*; 

class TrieNode{
    TrieNode []childs;
    boolean wordEnd;
    int wordEndCount;

    TrieNode(){
        childs = new TrieNode[26];
        wordEnd  = false;
        wordEndCount = 0;
    }
}
public class Trie {
    TrieNode trie;

    public Trie() {
        // Write your code here.
        trie = new TrieNode();
    }

    public void insert(String word) {
        // Write your code here.

        TrieNode root = trie;

        for(char c: word.toCharArray()){
            if(root.childs[c-'a'] == null){
                root.childs[c-'a'] = new TrieNode();
            }
            root = root.childs[c-'a'];
        }
        root.wordEndCount++;
        root.wordEnd = true;
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        TrieNode root = trie;

        for(char c: word.toCharArray()){
            if(root.childs[c-'a'] == null){
                return 0;
            }
            root = root.childs[c-'a'];
        }
        if(root.wordEnd) 
            return root.wordEndCount;
        return 0;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        TrieNode root = trie;

        for(char c: word.toCharArray()){
            if(root.childs[c-'a'] == null){
                return 0;
            }
            root = root.childs[c-'a'];
        }
        
        return findAns(root);
    }

    private int findAns(TrieNode root){
        
        int sum = root.wordEndCount ;
        for(int i=0;i<26;i++){
            if(root.childs[i] != null){
                sum += findAns(root.childs[i]);
            }
        }
        return sum;
    }
    public void erase(String word) {
        // Write your code here.
        TrieNode root = trie;
        for(char c: word.toCharArray()){
            if(root.childs[c-'a'] == null){
                return;
            }
            root = root.childs[c-'a'];
        }
        root.wordEndCount --;
        if(root.wordEndCount == 0)
            root.wordEnd = false;
        
    }

}

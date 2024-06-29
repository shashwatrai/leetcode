import java.util.* ;
import java.io.*; 

class TrieNode{
  TrieNode []childs;
  boolean wordEnd;

  TrieNode(){
    childs = new TrieNode[26];
    wordEnd = false;

  }
}
class Search{
  TrieNode trie;

  Search(){
    trie = new TrieNode();
  }

  void addWord(String str){
    TrieNode root = trie;

    for(char c: str.toCharArray()){
      if(root.childs[c-'a'] == null){
        root.childs[c-'a'] = new TrieNode();
      }
      root = root.childs[c-'a'];
    }
    root.wordEnd  = true;
  }

  boolean isValid(String str){
    TrieNode root = trie;
    for(char c: str.toCharArray()){
      if(root.childs[c-'a'] == null || !root.childs[c-'a'].wordEnd )
        return false;
      root = root.childs[c-'a'];
    }
    return true;
  }
}
class Solution {

  public static String completeString(int n, String[] a) {
    // Write your code here.
    Search search = new Search();
    for(int i=0;i<n;i++){
      search.addWord(a[i]);
    }

    String ans = "";
    for(int i=0;i<n;i++){
      if(search.isValid(a[i])){
        // System.out.println(ans.compareTo(a[i])+" "+ans+" "+a[i]);
        if(ans.length() < a[i].length() || ans.length() == a[i].length() && ans.compareTo(a[i]) > 0){
          ans = a[i];
        }
      }
    }
    if(ans.isEmpty()){
      ans = "None";
    }
    return ans;
  }
}

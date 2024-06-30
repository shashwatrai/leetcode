
import java.util.ArrayList;



class TrieNode{
	TrieNode childs[];
	boolean wordEnd;

	TrieNode(){
		childs = new TrieNode[26];
		wordEnd = false;
	}
}

class WordSearch{
	TrieNode trie;

	WordSearch(){
		trie = new TrieNode();

	}

	void addWord(String str, int start,int end){
		TrieNode root = trie;
		for(int i= start ;i<=end;i++){
			if(root.childs[str.charAt(i) - 'a'] == null){
				root.childs[str.charAt(i) - 'a'] = new TrieNode();
			}
			root = root.childs[str.charAt(i)-'a'];
		}
	}

}
public class Solution 
{

	
	public static int count(TrieNode root){
		int count = 1;
		for(int i=0;i<26;i++){
			if(root.childs[i] != null){
				count+= count(root.childs[i]);
			}
		}
		return count;
	}
	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		WordSearch search = new WordSearch();
		for(int i=0;i<s.length();i++)
			search.addWord(s, i, s.length()-1);
		return count(search.trie);
	}
}

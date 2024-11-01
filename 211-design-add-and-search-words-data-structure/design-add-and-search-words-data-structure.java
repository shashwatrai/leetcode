class TrieNode{

    TrieNode []childs;
    boolean isEnd;

    TrieNode(){
        childs = new TrieNode[26];
        isEnd = false;
    }
}
class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();

    }
    
    public void addWord(String word) {
        TrieNode  curr = root;

        for(int i=0;i<word.length();i++){
            if(curr.childs[word.charAt(i)-'a'] == null){
                curr.childs[word.charAt(i)-'a'] = new TrieNode();
            }
            curr = curr.childs[word.charAt(i)-'a'] ;
            if(i == word.length() - 1)
                curr.isEnd = true;
        }
    }
    
    public boolean findWord(TrieNode curr,String word,int indx){

        if(curr == null)
            return false;
        if(indx == word.length()){
            return curr.isEnd;
        }


        if(word.charAt(indx) == '.'){
            for(int i=0;i<26;i++){
                if(findWord(curr.childs[i],word,indx+1))
                    return true;
            }
            return false;
        }else
            return findWord(curr.childs[word.charAt(indx) - 'a'],word,indx+1);
        
    }

    public boolean search(String word) {
        return findWord(root,word,0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
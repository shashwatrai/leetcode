class TrieNode{
    boolean isEnd ;
    boolean hasSubDirectory;
    TrieNode []childs;
    TrieNode subDirectories;

    TrieNode(){
        childs = new TrieNode[26];
        hasSubDirectory = false;
        isEnd = false;
        subDirectories = null;
    }
}
class Solution {
    TrieNode root;
    void addFile(String file){
        TrieNode curr = root;
        
        for(int i=0;i < file.length();i++){

            if(file.charAt(i) == '/'){
                if(curr.subDirectories == null)
                    curr.subDirectories = new TrieNode();
                curr.hasSubDirectory = true;
                curr = curr.subDirectories;
            }else{
                if(curr.childs[file.charAt(i) - 'a'] == null){
                    curr.childs[file.charAt(i) - 'a'] = new TrieNode();
                }
                curr  = curr.childs[file.charAt(i) - 'a'];
            }

            if(i == file.length() - 1)
                curr.isEnd = true;
        }
    }
    void addAll(String []files){
        for(String s: files)
            addFile(s);
    }

    public List<String> removeSubfolders(String[] folder) {
        root = new TrieNode();
        addAll(folder);
        Set<String> set = new HashSet<>();
        for(String file: folder){
            TrieNode curr = root;
            StringBuilder stb = new StringBuilder();
            for(int i=0;i<file.length();i++){

                if(file.charAt(i) == '/'){
                    curr = curr.subDirectories;
                }else{
                    curr  = curr.childs[file.charAt(i) - 'a'];
                }
                stb.append(file.charAt(i));
                if((curr.hasSubDirectory && curr.isEnd) || i == file.length()-1 ){
                    set.add(stb.toString());
                    break;
                }   
            }
        }
        return set.stream().toList();
    }
}
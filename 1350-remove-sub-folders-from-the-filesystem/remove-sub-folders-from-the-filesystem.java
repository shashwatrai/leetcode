class TrieNode{
    boolean isEnd ;
    Map<String, TrieNode> childs;

    TrieNode(){
        childs = new HashMap<>();
        isEnd = false;
    }
}
class Solution {
    TrieNode root;
    void addFile(String file){
        TrieNode curr = root;
        String []folders = file.split("/");

        for(int i=0;i < folders.length;i++){
           
            if(!curr.childs.containsKey(folders[i])){
                curr.childs.put(folders[i],new TrieNode());
            }
            curr  = curr.childs.get(folders[i]);
            

            if(i == folders.length - 1)
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
        List<String> set = new ArrayList<>();
        for(String file: folder){
            TrieNode curr = root;
            boolean isSubFolder = false;
            String []folders = file.split("/");
            for(int i=0;i<folders.length;i++){

                curr  = curr.childs.get(folders[i]);
                
                if(curr.isEnd && i != folders.length-1 ){
                    isSubFolder = true;
                    break;
                }   
                
            }
            
            if(!isSubFolder)
                set.add(file);
        }
        return set;
    }
}
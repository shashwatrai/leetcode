class TrieNode{
    TrieNode []childs;
    boolean wordEnd;
    TrieNode(){
        wordEnd = false;
        childs = new TrieNode[26];
    }
}
class Solution {
    public void traverse(char [][]grid, boolean [][]vis, TrieNode root,Set<String> res,StringBuilder stb,int r,int c){
        
        if(root.wordEnd){
            res.add(stb.toString());
        }

        for(char i=0;i<26;i++){
            if(root.childs[i] != null){
                stb.append((char)(i+'a'));
                if(r + 1 < grid.length && !vis[r+1][c] && grid[r+1][c] == (char)(i+'a')){
                    vis[r+1][c] = true;
                    traverse(grid,vis,root.childs[i],res,stb,r+1,c);
                    vis[r+1][c] = false;
                }
                if(c + 1 < grid[0].length && !vis[r][c+1] && grid[r][c+1] == (char)(i+'a')){
                     vis[r][c+1] = true;
                     traverse(grid,vis,root.childs[i],res,stb,r,c+1);
                     vis[r][c+1] = false;
                }
                    
                if(r  - 1 >=0 && !vis[r-1][c] && grid[r-1][c] == (char)(i+'a')){
                    vis[r-1][c] = true;
                    traverse(grid,vis,root.childs[i],res,stb,r-1,c);
                    vis[r-1][c] = false;
                }
                    
                if(c - 1 >= 0 && !vis[r][c-1] &&grid[r][c-1] == (char)(i+'a')) {
                    vis[r][c-1] = true;
                    traverse(grid,vis,root.childs[i],res,stb,r,c-1);
                    vis[r][c-1] = false;   
                }
                stb.setLength(stb.length()-1); 
            }
        }
        
    }
    public void add(TrieNode root, String str){
        TrieNode curr = root;

        for(int i=0;i<str.length();i++){
            if(curr.childs[str.charAt(i) - 'a'] == null){
                curr.childs[str.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.childs[str.charAt(i) - 'a'];
            if(i == str.length()-1)
                curr.wordEnd = true;
        }
        
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String s : words){
            add(root,s);
        }
        boolean [][]vis = new boolean[board.length][board[0].length];
        Set<String> res =new HashSet<>();
        StringBuilder stb = new StringBuilder();
         for(int i=0;i<26;i++){
            if(root.childs[i] != null){
                stb.append((char)(i+'a'));
                for(int r=0;r<board.length;r++){
                    for(int c=0;c<board[r].length;c++){
                        if(board[r][c] == (char)(i+'a')){
                            vis[r][c] = true;
                            traverse(board,vis,root.childs[i],res,stb,r,c);
                            vis[r][c] = false;
                        }
                    }
                }
                stb.setLength(stb.length()-1); 
            }
         }
        return new ArrayList<String>(res);
    }
}
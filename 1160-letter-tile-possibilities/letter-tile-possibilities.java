class Solution {
    public void solve(String s,boolean []vis,int r,StringBuilder stb,Set<String> set){
        if(r == 0){
            set.add(stb.toString());
            return;
        }
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                vis[i] = true;
                stb.append(s.charAt(i));
                solve(s,vis,r-1,stb,set);
                stb.setLength(stb.length()-1);
                solve(s,vis,r-1,stb,set);
                vis[i] = false;
            }
        }
    }
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        solve(tiles,new boolean[tiles.length()],tiles.length(),new StringBuilder(),set);
        return set.size()-1;
    }
}
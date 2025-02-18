class Solution {
    public boolean findAns(String pattern,int indx,char []arr,boolean vis[]){
        // System.out.println(indx+" "+Arrays.toString(arr));
        if(indx == pattern.length()+1){
            return true;
        }
        if(indx == 0){
            for(int i=1;i<vis.length;i++){
                vis[i] = true;
                arr[indx] = (char)('0'+i);
                if(findAns(pattern,indx+1,arr,vis))
                    return true;
                vis[i] = false;
                arr[indx] = '0';
            }
        }else{
            // System.out.println(pattern.charAt(indx-1) +" "+indx+" "+Arrays.toString(vis));
            if(pattern.charAt(indx-1) == 'I'){
                for(int i=arr[indx-1]-'0'+1;i<vis.length;i++){
                    
                    if(!vis[i]){
                        vis[i] = true;
                        arr[indx] = (char)('0'+i);
                        
                        if(findAns(pattern,indx+1,arr,vis))
                            return true;
                        vis[i] = false;
                        arr[indx] = '0';
                    }
                }
            }else{
                for(int i=1;i<arr[indx-1]-'0';i++){
                    if(!vis[i]){
                        vis[i] = true;
                        arr[indx] = (char)('0'+i);
                        if(findAns(pattern,indx+1,arr,vis))
                            return true;
                        vis[i] = false;
                        arr[indx] = '0';
                    }
                }
            }
        }
        return false;
    }
    public String smallestNumber(String pattern) {
        // StringBuilder stb = new StringBuilder();
        // for(int i=0;i<pattern.length();i++){
        //     stb.append(pattern.charAt(i));
        // }
        // String newPattern = stb.reverse();

        boolean []vis = new boolean[10];
        char []arr = new char[pattern.length()+1];
        findAns(pattern,0,arr,vis);
        // System.out.println(Arrays.toString(arr));
        return new String(arr);
        
    }
}
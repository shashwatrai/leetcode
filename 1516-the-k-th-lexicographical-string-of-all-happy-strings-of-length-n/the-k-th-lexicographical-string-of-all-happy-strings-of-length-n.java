class Solution {
    public boolean findAns(StringBuilder stb,char prev,int n,int rank[],int k){
        if(stb.length() == n)
            rank[0]++;
        if(rank[0] == k && stb.length() == n){
            return true;
        }
        if(stb.length() < n){
            if(prev != 'a'){
                stb.append('a');
                if(findAns(stb,'a',n,rank,k))
                    return true;
                stb.setLength(stb.length()-1);
            }
            if(prev != 'b'){
                stb.append('b');
                if(findAns(stb,'b',n,rank,k))
                    return true;
                stb.setLength(stb.length()-1);
            }
            if(prev != 'c'){
                stb.append('c');
                if(findAns(stb,'c',n,rank,k))
                    return true;
                stb.setLength(stb.length()-1);
            }
        }
        return false;
    }
    public String getHappyString(int n, int k) {
        StringBuilder stb = new StringBuilder();
        int []rank = new int[1];
        findAns(stb,' ',n,rank,k);
        // System.out.println(rank[0]+" "+stb.toString());
        return stb.toString();
    }
}
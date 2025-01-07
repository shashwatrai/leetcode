class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();

        for(int i=0;i<words.length;i++){
            boolean found = false;
            for(int j=0;j<words.length;j++){
                if(i!=j){
                    for(int k=0,r=0;k<words[j].length();k++){
                        if(words[j].charAt(k) == words[i].charAt(r))
                            r++;
                        else{
                            k-=r;
                            r=0;

                        }
                        if(r==words[i].length()){
                            found = true;
                            break;
                        }
                    }

                    if(found){
                        ans.add(words[i]);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
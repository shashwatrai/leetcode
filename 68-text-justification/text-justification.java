class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        

        List<String> res = new ArrayList<>();
        int prev = 0;
        int curr=0;
        for(int i=0;i<words.length;i++){
            if(curr + i - prev + words[i].length() <= maxWidth){
                curr += words[i].length();
            }else{
                StringBuilder stb = new StringBuilder();
                int totalSpaces = maxWidth - curr;
                
                for(int j= prev;j < i;j++){
                    stb.append(words[j]);
                    int spacePadding = i-j > 1 ? (int)Math.ceil((double)totalSpaces/(i-j-1)):totalSpaces;
                    for(int x = 0;x<Math.min(totalSpaces,spacePadding);x++)
                        stb.append(' ');
                    totalSpaces = Math.max(0,totalSpaces-spacePadding);
                }
                prev = i;
                curr = words[i].length();
                res.add(stb.toString());
            }
        }
        if(prev < words.length){
                StringBuilder stb = new StringBuilder();
                int totalSpaces = maxWidth - curr;
                int spacePadding = 1;
                for(int j= prev;j < words.length;j++){
                    stb.append(words[j]);
                    for(int x = 0;x<Math.min(totalSpaces,spacePadding);x++)
                        stb.append(' ');
                    totalSpaces = Math.max(0,totalSpaces-spacePadding);
                }
                if(totalSpaces > 0){
                    for(int x = 0;x<totalSpaces;x++)
                        stb.append(' ');
                }
                res.add(stb.toString());
        }
        return res;
    }
}
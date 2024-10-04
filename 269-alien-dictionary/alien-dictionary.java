class Solution {
    public String alienOrder(String[] words) {
        int []inDegree = new int[26];

        Arrays.fill(inDegree,-1);

        Set<Character> charSet = new HashSet<>();

        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++)
                charSet.add(words[i].charAt(j));
        }

        for(char c: charSet){
            inDegree[c-'a']++;
        }

        Map<Character,Set<Character>> adj  = new HashMap<>();

        for(int i=1;i<words.length;i++){
            if(words[i-1].startsWith(words[i]) && words[i-1].length() != words[i].length())
                return "";
            for(int j = 0 ;j<Math.min(words[i].length(),words[i-1].length());j++){
                if(words[i-1].charAt(j)  != words[i].charAt(j)){
                    if(!adj.containsKey(words[i-1].charAt(j))){
                        adj.put(words[i-1].charAt(j) , new HashSet<>());
                    }
                    adj.get(words[i-1].charAt(j)).add(words[i].charAt(j));
                    
                    break;
                }
            }
        }

        for(char c : adj.keySet()){
            for(char z: adj.get(c)){
                inDegree[z-'a']++;
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<26;i++){
            if(inDegree[i] == 0){
                queue.add((char)('a'+i));
            }
        }

        int nodeCount =0 ;
        StringBuilder stb = new StringBuilder();
        while(!queue.isEmpty()){
            char node = queue.poll();
            stb.append(node);
            nodeCount++;
            
            if(adj.containsKey(node)){
                for(char c: adj.get(node)){
                    inDegree[c-'a']--;
                    if(inDegree[c-'a'] == 0){
                        queue.add(c);
                    }
                }
            }
        }
        if(nodeCount == charSet.size())
            return stb.toString();
        return "";
    }
}
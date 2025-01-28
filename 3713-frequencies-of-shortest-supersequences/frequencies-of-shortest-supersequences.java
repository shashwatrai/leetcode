class Solution {
    public List<List<Integer>> supersequences(String[] words) {
       /*
        Since the word in the words are of length 2

        And Let's assume the words array is formed using a,b,c,d 
        So, for the the worst case 
            "abcddcba" can satisfy(contain any subsequence of the 2 charactered word) any word from the words

        --> Observation: any character can occure 2 times atmost;

        Now the question is finding where the use of 1 character would contain all the answers or not.
        This can be verified using the toposort(by removing the self edges), if all the made relation able to traverse all the distinct characters then it is valid
        supersequence.

        For that we will count all the possible subset of distinct characters from the words array
        having atleast 1 occurence and atmost 2 occurence.
       */ 

        int charMap[]  = new int[26];
        char indxToCharMap[] = new char[26];

        Arrays.fill(charMap,-1);
        TreeSet<Character> charSet = new TreeSet<>();
        for(String s: words){
            charSet.add(s.charAt(0));
            charSet.add(s.charAt(1));
        }

        int count = 0;
        for(char c: charSet){
            charMap[c-'a'] = count;
            indxToCharMap[count] = c;
            count++;
        }

        // iterating over all subset
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<(1 << count);i++){
            boolean ones[] = new boolean[26];
            boolean twos[] = new boolean[26];

            for(int j =0 ;j<count;j++){
                if((i & (1 << j)) == 0)
                    ones[j] = true;
                else
                    twos[j] = true;
            }

            // adjacency matrix
            boolean [][]adj = new boolean[count][count];
            int inDegree[] = new int[count];
            for(String s: words){
                int u = charMap[s.charAt(0) - 'a'];
                int v = charMap[s.charAt(1) - 'a'];

                if( ones[u] && ones[v]){
                    adj[u][v] = true;
                    inDegree[v]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int j=0;j<count;j++){
                if(inDegree[j] == 0)
                    queue.add(j);
            }

            int visitedCount=0;
            while(!queue.isEmpty()){
                int curr = queue.poll();
                visitedCount++;

                for(int j=0;j<count;j++){
                    if(adj[curr][j]){
                        inDegree[j]--;
                        if(inDegree[j] == 0)
                            queue.add(j);
                    }
                }
            }
            if(visitedCount == count){
                int temp =0;
                for(int j=0;j<count;j++){
                    if(ones[j])
                        temp+=1;
                    else
                        temp+=2;
                }

                // min would encountered in first time 
                if(min >= temp) {  
                    if(min > temp){
                        res.clear();
                    }
                    min = temp;
                    int freq[] = new int[26];

                    for(int j=0;j<count;j++){
                        if(ones[j]){
                            freq[indxToCharMap[j] -'a']+=1;
                        }else
                            freq[indxToCharMap[j] -'a']+=2;
                    }

                    List<Integer> freqList = new ArrayList<>();
                    for(int j:freq)
                        freqList.add(j);
                    res.add(freqList);
                }
            }
           
        }
         return res;
    }
}
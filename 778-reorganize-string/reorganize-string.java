class Solution {
    public String reorganizeString(String s) {
        char []freq = new char[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> freq[b - 'a']-freq[a-'a']);

        for(int i=0;i<26;i++){
            if(freq[i] == 0)
                continue;
            pq.add((char)('a'+i));
        }
        StringBuilder stb = new StringBuilder();
        char last = '.';
        while(!pq.isEmpty()){
            if(last == pq.peek()){
                char charToBeSkipped = pq.poll();
                if(pq.isEmpty()){
                    return "";
                }
                char curr = pq.poll();
                freq[curr - 'a']--;
                if(freq[curr - 'a'] != 0)
                    pq.add(curr);
                stb.append(curr);
                last =curr;
                pq.add(charToBeSkipped);
            }else{
                char curr = pq.poll();
                freq[curr - 'a']--;
                if(freq[curr - 'a'] != 0)
                    pq.add(curr);
                stb.append(curr);
                last =curr;
            }
        }
        return stb.toString();
    }
}
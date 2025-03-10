class Solution {
    public boolean isVowel(char c){
        return switch(c){ case 'a' -> true;case 'e' -> true;case 'i' -> true;case 'o' -> true; case 'u' -> true;default -> false;};
    }
    public long countOfSubstrings(String word, int k) {
        Map<Character,Deque<Integer>> map = new HashMap<>();
        map.put('a',new ArrayDeque<>());
        map.put('e',new ArrayDeque<>());
        map.put('i',new ArrayDeque<>());
        map.put('o',new ArrayDeque<>());
        map.put('u',new ArrayDeque<>());
        long ans =0L;
        int cnt=0;
        Deque<Integer> consonants = new ArrayDeque<>();
        int start=0;
        int n = word.length();
        for(int i=0;i<n;i++){
            if(isVowel(word.charAt(i))){
                map.get(word.charAt(i)).addLast(i);
            }else{
                consonants.addLast(i);
            }
            if(consonants.size() > k){
                int last = consonants.pollFirst();
                for(char c : map.keySet()){
                    Deque<Integer> dq = map.get(c);
                    while(!dq.isEmpty() && dq.peekFirst() < last){
                        dq.pollFirst();
                    }
                }
            }
            
            if(consonants.size() == k){
                int min = Integer.MAX_VALUE;
                int max = consonants.isEmpty()?i: consonants.peekFirst();
                boolean isAllowed = true;
                for(char c : map.keySet()){
                    Deque<Integer> dq = map.get(c);
                    if(!dq.isEmpty()){
                        min = Math.min(dq.peekFirst(),min);
                        max = Math.min(max,dq.peekLast());
                    }else{
                        isAllowed = false;
                        break;
                    }
                }
                if(isAllowed)
                    ans += (long)(Math.max(0,max-min)+1);
            }
        }
        return ans;
    }
}
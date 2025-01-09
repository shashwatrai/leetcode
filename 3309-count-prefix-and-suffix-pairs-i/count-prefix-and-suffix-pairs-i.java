class TrieNode{
    TrieNode []childs;
    boolean []collection;

    TrieNode(int n){
        childs = new TrieNode[26];
        collection= new boolean[n];
    }

}

class Solution {

    public int[] prepare(String s){
        int n = s.length();
        int k = -1;
        int pi[] = new int[n];

        int i =1;
        pi[0] = -1;
        while(i<n){
            while(k > -1 && s.charAt(i) != s.charAt(k+1)){
                k = pi[k];
            }

            if(s.charAt(i) == s.charAt(k+1))
                k++;
            
            pi[i] = k;
            i++;
        }
        return pi;
    }


    public void add(TrieNode root,String s,int indx,int n){
        TrieNode curr = root;

        for(int i=0;i<s.length();i++){
            if(curr.childs[s.charAt(i) - 'a'] == null){
                curr.childs[s.charAt(i) - 'a'] = new TrieNode(n);
            }
            curr = curr.childs[s.charAt(i) - 'a'];
            curr.collection[indx]=true;
        }
    }
    public boolean[] traverse(TrieNode root,String s){
        int count=0;
        TrieNode curr = root;
        for(int i=0;i<s.length();i++){
            curr = curr.childs[s.charAt(i) - 'a'];
            if(curr == null)
                break;
            System.out.println(s.charAt(i)+" "+Arrays.toString(curr.collection));
        }
        if(curr == null)
            return null;
        return curr.collection;
    }
    public int countPrefixSuffixPairs(String[] words) {
        
        int count=0;
        Map<String,Integer> map= new HashMap<>();
        for(String s: words)
            map.put(s,map.getOrDefault(s,0)+1);
        for(String s: map.keySet()){
            // System.out.println(s+" "+map.get(s));
            count += (map.get(s) * ( map.get(s) - 1 )) /2 ;
        }
        TrieNode frontRoot = new TrieNode(words.length);
        TrieNode reverseRoot = new TrieNode(words.length);
        StringBuilder stb = new StringBuilder();
        for(int i=words.length - 1;i>=0 ;i--){
            stb.append(words[i]);
            boolean f[] = traverse(frontRoot,words[i]);
            boolean r[] = traverse(reverseRoot,stb.reverse().toString());
            if(f != null && r != null){
                System.out.println(Arrays.toString(f)+" "+Arrays.toString(r));
                for(int j=0;j<f.length;j++){
                    if(f[j] && r[j])
                        count++;
                }
            }
            stb.setLength(0);
            int []pi = prepare(words[i]);
            
            stb.append(words[i].substring(0,pi[words[i].length()-1]+1));
            // System.out.println(words[i]+" "+stb.reverse().toString());
            add(frontRoot,words[i],i,words.length);
            add(reverseRoot,stb.reverse().toString(),i,words.length);
            stb.setLength(0);
        }

        return count;
    }
}
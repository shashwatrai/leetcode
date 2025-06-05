class Solution {
    public int findParent(int a, int []arr,int s){
        if(arr[a] == a)
            return arr[a] = Math.min(s,a);
        return arr[a] = findParent(arr[a],arr,Math.min(s,arr[a]));
    }
    public void merge(int a, int b,int []arr){
        
        a = findParent(a,arr,a);
        b = findParent(b,arr,b);

        if(a != b){
            if(a > b)
                arr[a] = b;
            else
                arr[a] = b;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int arr[] = new int[26];
        for(int i=0;i<26;i++)
            arr[i] = i;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == s2.charAt(i))
                continue;
            
            merge(s1.charAt(i)-'a' , s2.charAt(i) - 'a',arr);
        }

        for(int i=0;i<26;i++){
            findParent(i,arr,i);
        }

        StringBuilder stb = new StringBuilder();

        for(int i=0;i<baseStr.length();i++){
            stb.append((char)('a'+arr[baseStr.charAt(i)-'a']));
        }
        return stb.toString();
    }
}
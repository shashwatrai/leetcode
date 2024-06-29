import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int find(String a,String b){
        for(int i =0 ;i<Math.min(a.length(),b.length());i++){
            if(a.charAt(i) != b.charAt(i))
                return i;
        }
        return -1;
    }

    public static void traverse(int [][]edges,boolean []vis,int node,StringBuilder stb){
        vis[node] = true;
        for(int i=0;i<26;i++){
            if(!vis[i] && edges[node][i] == 1){
                traverse(edges, vis, i, stb);
            }
        }
        stb.append((char)(node+'a'));
    }
    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        int edges[][] = new int[26][26];
        int n  = dictionary.length;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<n-1;i++){
            for(char c: dictionary[i].toCharArray()){
                set.add(c);
            }
            int indx = find(dictionary[i], dictionary[i+1]) ;
            if(indx != -1){
                edges[dictionary[i].charAt(indx) - 'a'][dictionary[i+1].charAt(indx)-'a'] = 1;
                
            }
        }
        for(char c: dictionary[n-1].toCharArray()){
                set.add(c);
        }

        StringBuilder stb = new StringBuilder();
        boolean vis[] = new boolean[26];
        for(int i=0;i<26;i++){
            if(!vis[i] && set.contains((char)('a'+i))){
                traverse(edges,vis,i,stb);
                // System.out.println(stb.toString());
            }
        }
        return stb.reverse().toString();
    }
}

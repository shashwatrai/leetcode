class Pair{
    char c;
    int pos;

    Pair(char c,int p){
        pos= p;
        this.c = c;
    }
}
class Solution {
    public String clearStars(String s) {

        int n = s.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.c != b.c ? a.c - b.c : b.pos - a.pos);
        boolean deleted[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '*'){
                Pair curr = pq.poll();
                deleted[curr.pos] = true;
                deleted[i] = true;
            }else{
                pq.add(new Pair(s.charAt(i),i));
            }
        }
        StringBuilder stb = new StringBuilder();

        for(int i=0;i<n;i++){
            if(!deleted[i])
                stb.append(s.charAt(i));
        }
        return stb.toString();
    }
}
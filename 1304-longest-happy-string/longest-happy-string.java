class Pair{
    char c;
    int count;
    Pair(char c,int count){
        this.c = c;
        this.count = count;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder stb = new StringBuilder();


        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) ->  y.count - x.count );

        if(a > 0){
            pq.add(new Pair('a',a));
        }
        if(b > 0){
            pq.add(new Pair('b',b));
        }
        if(c > 0){
            pq.add(new Pair('c',c));
        }

        char prev = 'z';
        int count=0;
        while(!pq.isEmpty()){
            // System.out.println(prev+ " "+ count +" "+stb.toString());
            Pair curr = pq.poll();
            if(prev == curr.c){
                if(count == 2){
                    if(pq.isEmpty()){
                        break;
                    }else{
                        Pair next = pq.poll();
                        stb.append(next.c);
                        next.count--;
                        if(next.count > 0)
                            pq.add(next);
                        prev = next.c;
                        count = 1;
                    }
                }else{
                    stb.append(curr.c);
                    curr.count--;
                    count++;
                }
            }else{
                stb.append(curr.c);
                curr.count--;
                prev = curr.c;
                count=1;
            }
            if(curr.count > 0)
                pq.add(curr);
        }
        return stb.toString();
    }
}
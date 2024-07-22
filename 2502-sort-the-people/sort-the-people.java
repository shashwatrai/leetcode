class Pair{
    String name; 
    int height;
    Pair(String n , int h){
        this.name  = n;
        this.height = h;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            pairs.add(new Pair(names[i],heights[i]));
        }
        Collections.sort(pairs,new Comparator<Pair>(){
            public int compare(Pair a,Pair b){
                return   b.height-a.height;
            }
        });
       String []res  = new String[names.length];
       for(int i=0;i<names.length;i++){
            res[i] = pairs.get(i).name;
       }
       return res;
    }
}
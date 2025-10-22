
class Pair{
    int d;
    int indx;

    Pair(int d, int indx){
        this.d = d;
        this.indx = indx;
    }
}
class Solution {
    public String perform(Pair []arr,int a,int r){
        Pair temp[] = new Pair[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i] = new Pair(arr[i].d,arr[i].indx);
        }

        int min = 10;

        int t = temp[1].d;
        for(int i=0;i<10;i++){
            t = (t+a)%10;
            min = Math.min(min,t);
        }

        while(temp[1].d != min){
            for(int j=1;j<arr.length;j+=2){
                temp[j].d = (temp[j].d  + a)%10;
            }
        }
        if(r == 2){
            min = 10;

            t = temp[0].d;
            for(int i=0;i<10;i++){
                t = (t+a)%10;
                min = Math.min(min,t);
            }

            while(temp[0].d != min){
                for(int j=0;j<arr.length;j+=2){
                    temp[j].d = (temp[j].d  + a)%10;
                }
            }   
        }

        StringBuilder stb = new StringBuilder();
        for(int j=0;j<temp.length;j++){
            stb.append(temp[j].d);
        }
        return stb.toString();
    }
    public void rotate(Pair []arr, int b){
        int n = arr.length;
        Pair temp[] = new Pair[n];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[(i+b)%n];
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }
        
    }
    public String findLexSmallestString(String s, int a, int b) {
        Pair []arr = new Pair[s.length()];
        StringBuilder stb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            stb.append("9");
            arr[i] = new Pair(s.charAt(i) - '0',i);

        }


        String max = stb.toString();
        int r = b%2 == 1 ? 2: 0;
        do{
            String temp = perform(arr,a,r);
            // System.out.println(temp+" "+max);
            if(max.compareTo(temp) > 0)
                max = temp;
            rotate(arr,b);
            // for(int i=0;i<arr.length;i++)
            //     System.out.print("["+arr[i].d+" "+arr[i].indx+"]");
            // System.out.println();
        }while(arr[0].indx != 0);
        return max;
    }
}
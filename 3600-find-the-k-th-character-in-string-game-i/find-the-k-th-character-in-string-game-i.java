class Solution {
    public char kthCharacter(int k) {
        int indx = (int)(Math.ceil(Math.log(k)/Math.log(2)));
        int p = (int)Math.pow(2,indx);
        int ans=0;
        while(indx > 0){
            int h = p/2;

            if(k > h){
                ans++;
                k -= h;
            }
            p = h;
            indx--;
        }
        return (char)(ans%26 + 'a'); 
    }
}
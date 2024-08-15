class Solution {
    public boolean lemonadeChange(int[] bills) {
        int bill1 = 0,bill2=0;

        for(int i=0;i<bills.length;i++){
            if(bills[i] == 10){
                if(bill1 == 0)
                    return false;
                bill1--;
                bill2++;
            }else if(bills[i] == 20){
                if(bill1 == 0 || (bill2 == 0 && bill1 <3))
                    return false;
                if(bill2 ==0)
                    bill1 -=3;
                else{
                    bill1--;
                    bill2--;
                }
            }else
                bill1++;
        }
        return true;
    }
}
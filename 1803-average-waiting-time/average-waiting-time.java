class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time = customers[0][0];
        double wait = 0f;

        for(int i[]:customers){
            wait += Math.max(0,time - i[0]) + i[1];
            time = Math.max(time,i[0])+i[1];
        }
        return  (double)wait/customers.length;
    }
}
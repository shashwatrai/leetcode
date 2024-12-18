class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<prices.length;i++){
            while(!st.isEmpty() && prices[st.peek()] >= prices[i]){
                prices[st.pop()] -= prices[i];
            }
            st.add(i);
        }
        return prices;
    }
}
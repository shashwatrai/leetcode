class Solution {
    public boolean helper(String []list1,String []list2){
        
        for(int i = 0;i<=list1.length;i++){
            boolean front = true;
            for(int j= 0;j<i;j++){
                if(!list1[j].equals(list2[j])){
                    front = false;
                    break;
                }
            }
            if(!front)
                continue;
            boolean  back = true;
            int shift = list2.length - list1.length ; 
            for(int j= i;j<list1.length;j++){
                if(!list1[j].equals(list2[shift + j])){
                    back = false;
                    break;
                }
            }
            if(back)
                return true;
        }
        return false;
    }
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        

        String list1[] = sentence1.split(" ");
        String list2[] = sentence2.split(" ");
        if(list1.length > list2.length)
            return areSentencesSimilar(sentence2,sentence1);
        return helper(list1,list2);
    }
}
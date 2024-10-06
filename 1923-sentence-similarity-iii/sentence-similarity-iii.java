class Solution {
    public boolean helper(String []list1,String []list2){
        
        
        // boolean front = true;
        int indx = 0;
        for(;indx<list1.length;indx++){
            if(!list1[indx].equals(list2[indx])){
                break;
            }
        }

        int shift = list2.length - list1.length ; 
        for(;indx<list1.length;indx++){
            if(!list1[indx].equals(list2[shift + indx])){
                break;
            }
        }        
        return indx == list1.length;
    }
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        

        String list1[] = sentence1.split(" ");
        String list2[] = sentence2.split(" ");
        if(list1.length > list2.length)
            return areSentencesSimilar(sentence2,sentence1);
        return helper(list1,list2);
    }
}
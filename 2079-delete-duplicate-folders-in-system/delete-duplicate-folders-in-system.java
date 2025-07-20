class Node{
    Node parent;
    boolean isDeleted;
    String current;
    Map<String,Node> childs;

    Node(Node p,String c){
        this.parent = p;
        this.current = c;
        this.isDeleted = false;
        childs = new HashMap<>();
    }
}
class Solution {
    public String traverse(Node curr,Map<String,List<Node>> map){

        StringBuilder stb = new StringBuilder();

        for(String child : curr.childs.keySet()){
            stb.append("|"+traverse(curr.childs.get(child),map)+"|");  
        }
        if(!stb.isEmpty()){
            if(!map.containsKey(stb.toString()))
                map.put(stb.toString(),new ArrayList<>());
            map.get(stb.toString()).add(curr);
        }
        stb.append("_"+curr.current+"_");
        return stb.toString();
    }

    public void findAnswer(Node root,List<List<String>> ans,List<String> curr){
        // System.out.println(root.current+" "+root.isDeleted);
        if(root.isDeleted)
            return;
        
        
        
        if(!root.current.isEmpty()){
            curr.add(root.current);
        }
        if(curr.size() > 0){
            ans.add(new ArrayList<>(curr));
        }
        for(String child: root.childs.keySet())
            findAnswer(root.childs.get(child),ans,curr);
        if(!root.current.isEmpty()){
            curr.remove(curr.size()-1);
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        Collections.sort(paths, (a,b) -> a.toString().compareTo(b.toString()));
        Node root = new Node(null,"");

        for(int i=0;i<paths.size();i++){
            List<String> path = paths.get(i);
            Node curr = root;
            for(String p : path){
                Node temp = null;
                if(curr.childs.containsKey(p))
                    temp = curr.childs.get(p);
                else{
                    temp = new Node(curr,p);
                    curr.childs.put(p,temp);
                }
                curr = temp;
            }
        }
        Map<String,List<Node>> map = new HashMap<>();

        traverse(root,map);
        // System.out.println(map);
        for(String s: map.keySet()){
            if(map.get(s).size() > 1){
                for(Node n : map.get(s))
                    n.isDeleted = true;
            }
        }

        List<List<String>> ans = new ArrayList<>();
        findAnswer(root,ans,new ArrayList<String>());
        return ans;
    }
}
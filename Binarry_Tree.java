import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node [] L = new Node[n];
        for(int i=0;i<n;i++){
            int id = sc.nextInt();
            ArrayList<Integer> Child = new ArrayList<>();
            int left = sc.nextInt();
            int right = sc.nextInt();
            if(left!=-1) Child.add(left);
            if(right!=-1) Child.add(right);
            Node v = new Node();
            v.element(id,Child,-1,-1,Child.size(),0,0,"no");
            L[id] = v;
        }
        //finding the parent and slibing
        for(Node v:L){
            if(v.Child.size()==1) L[v.Child.get(0)].parent = v.id;
            else if(v.Child.size()==2){
                L[v.Child.get(0)].parent = v.id;
                L[v.Child.get(1)].parent = v.id;
                L[v.Child.get(0)].slibing = v.Child.get(1);
                L[v.Child.get(1)].slibing = v.Child.get(0);
            }
        }
        //finding the type of each node
        int root_id = 0;
        for(Node v:L){
            if(v.parent!=-1&&v.Child.size()>0) v.type="internal node";
            else if(v.parent!=-1&&v.Child.size()==0) v.type="leaf";
            else{
                v.type = "root";
                root_id = v.id;
            }
        }
        //depth
        depth(L,root_id,0);
        //height
        ArrayList<Integer> leaf = new ArrayList<>();
        for(Node v:L){
            if(v.type.equals("leaf"))height(L,v.id,0);
        }

        //output
        for(Node v:L){
            StringBuilder opt = new StringBuilder();
            opt.append("node "+v.id+": parent = "+v.parent+", sibling = "+v.slibing+", degree = "+v.degree+", depth = "+v.depth+", height = "+v.height+", "+v.type);
            System.out.println(opt);
        }

    }
    public static void depth(Node L[],int id,int depth){
        L[id].depth = depth;
        for(int i:L[id].Child) depth(L,i,depth+1);
    }
    public static void height(Node L[],int id,int height){
        if(L[id].height<height) L[id].height=height;
        if(L[id].parent!=-1)height(L,L[id].parent,height+1);
    }
    public static class Node{
        ArrayList<Integer> Child = new ArrayList<>();
        int id,parent,slibing,degree,depth,height;
        String type;
        public void element(int id,ArrayList<Integer> Child,int parent,int slibing,int degree,int depth,int height,String type){
            this.id = id;
            this.Child = Child;
            this.parent = parent;
            this.slibing = slibing;
            this.degree = degree;
            this.depth = depth;
            this.height = height;
            this.type = type;
        }
    }
}
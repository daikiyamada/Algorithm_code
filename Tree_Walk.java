import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node [] L = new Node[n];
        for(int i=0;i<n;i++){
            int id = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            Node v = new Node();
            v.element(id,-1,left,right);
            L[id] = v;
        }
        for(Node v:L){
            if(v.left!=-1) L[v.left].parent = v.id;
            if(v.right!=-1) L[v.right].parent = v.id;
        }
        for(Node v:L){
            if(v.parent==-1){
                System.out.println("Preorder");
                preorder(L,v.id);
                System.out.println();
                System.out.println("Inorder");
                inorder(L,v.id);
                System.out.println();
                System.out.println("Postorder");
                postorder(L,v.id);
                System.out.println();
                break;
            }
        }
    }
    public static void preorder(Node [] L,int id){
        System.out.print(" "+id);
        if(L[id].left!=-1)preorder(L,L[id].left);
        if(L[id].right!=-1)preorder(L,L[id].right);
    }
    public static void inorder(Node [] L,int id){
        if(L[id].left!=-1)inorder(L,L[id].left);
        System.out.print(" "+id);
        if(L[id].right!=-1)inorder(L,L[id].right);
    }
    public static void postorder(Node []L,int id){
        if(L[id].left!=-1) postorder(L,L[id].left);
        if(L[id].right!=-1) postorder(L,L[id].right);
        System.out.print(" "+id);
    }
    public static class Node{
        int id,parent,left,right;
        public void element(int id,int parent,int left,int right){
            this.id = id;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
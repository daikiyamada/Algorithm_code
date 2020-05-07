import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node [] G = new Node[n];
        for(int i=0;i<n;i++){
            int id = sc.nextInt();
            int k = sc.nextInt();
            int child[] = new int[k];
            if(k!=0) for (int j = 0; j < k; j++) child[j] = sc.nextInt();
            Node node = new Node();
            node.element(id, -1, child, "leaf", 0);
            G[id] = node;
        }
        for(int i=0;i<n;i++) for(int j:G[i].child) G[j].parent = G[i].id;
        int root =0;
        for(Node g:G){
            if(g.child.length==0&&g.parent!=-1) g.type="leaf";
            else if(g.child.length!=0&&g.parent!=-1)g.type="internal node";
            else{
                g.type="root";
                root = g.id;
            }
        }
        int Check [] = new int[n];
        Arrays.fill(Check,0);
        BFS(G,root,Check,0);
        for(Node node :G){
            StringBuilder result = new StringBuilder();
            result.append("node "+node.id+": parent = "+node.parent+", depth = "+node.depth+", "+node.type+", [");
            if(node.child.length!=0) {
                result.append(node.child[0]);
                for (int i = 1; i < node.child.length; i++) result.append(", " + node.child[i]);
            }
            result.append("]");
            System.out.println(result);
        }
    }
    public static void BFS(Node [] G,int id,int [] C,int depth){
        G[id].depth=depth;
        C[id] = 1;
        if(G[id].child.length!=0) for(int i:G[id].child)  if(C[i]==0) BFS(G,i,C,depth+1);
    }
    public static class Node{
        int id;
        int parent;
        int [] child;
        String type;
        int depth;
        public void element(int id,int parent,int []child,String type,int depth){
            this.id = id;
            this.parent = parent;
            this.child = child;
            this.type = type;
            this.depth = depth;
        }
    }
}

import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int cnt = 0,root_value = -1;
        ArrayList<Node> T = new ArrayList<>();
        Map<Integer,Integer> L = new HashMap<>();
        for(int i=0;i<n;i++){
            String s = sc.next();
            if(s.charAt(0)=='i') {
               int value=sc.nextInt();
               if(cnt==0) {
                   root_value=value;
                   Node v = new Node();
                   v.element(value,-100,-100,-100);
                   T.add(v);
                   L.put(value,0);
               }
               else insert(T,L,value,root_value);
               cnt++;
            }
            else if(s.charAt(0)=='f'){
                int value = sc.nextInt();
                boolean check = find(T,L,value,L.get(root_value),false);
                if(check) System.out.println("yes");
                else System.out.println("no");
            }
            else if(s.charAt(0)=='d'){
                int value = sc.nextInt();
                delete(T,L,value,L.get(root_value));
            }
            else{
                StringBuilder P = new StringBuilder();
                StringBuilder I = new StringBuilder();
                Order(T,L,root_value,P,I);
                System.out.println(I);
                System.out.println(P);
            }
        }
    }
    public static void Order(ArrayList<Node> T,Map<Integer,Integer> L,int now,StringBuilder P,StringBuilder I){
        int num = L.get(now);
        P.append(" "+now);
        if(T.get(num).left!=-100) Order(T,L,T.get(num).left,P,I);
        I.append(" "+now);
        if(T.get(num).right!=-100) Order(T,L,T.get(num).right,P,I);
    }
    public static int Inorder(ArrayList<Node> T,Map<Integer,Integer> L,int now){
        int id = L.get(now);
        if(T.get(id).left!=-100) now = Inorder(T,L,T.get(id).left);
        return now;
    }
    public static void insert(ArrayList<Node> T,Map<Integer,Integer> L,int value,int root_value){
        int index = L.get(root_value);
        if(root_value>=value){
            if(T.get(index).left!=-100) insert(T,L,value,T.get(index).left);
            else{
                T.get(index).left = value;
                Node v = new Node();
                v.element(value,root_value,-100,-100);
                T.add(v);
                L.put(value,T.size()-1);
            }
        }
        else{
            if(T.get(index).right!=-100)insert(T,L,value,T.get(index).right);
            else{
                T.get(index).right = value;
                Node v = new Node();
                v.element(value,root_value,-100,-100);
                T.add(v);
                L.put(value,T.size()-1);
            }
        }
    }
    public static boolean find(ArrayList<Node> T,Map<Integer,Integer> L,int value,int now_id,boolean check){
        if(T.get(now_id).value==value) return true;
        else if (T.get(now_id).value>value&&T.get(now_id).left!=-100)  check = find(T,L,value,L.get(T.get(now_id).left),check);
        else if(T.get(now_id).value<value&&T.get(now_id).right!=-100)check = find(T,L,value,L.get(T.get(now_id).right),check);
        return check;
    }
    public static void delete(ArrayList<Node> T,Map<Integer,Integer> L ,int value,int now_id){
        if(T.get(now_id).value==value){
            if(T.get(now_id).right==-100&&T.get(now_id).left==-100){
                int parent_id = L.get(T.get(now_id).parent);
                if(T.get(parent_id).left==T.get(now_id).value) T.get(parent_id).left = -100;
                else T.get(parent_id).right = -100;
            }
            else if(T.get(now_id).right!=-100&&T.get(now_id).left!=-100){
                int next_num = Inorder(T,L,T.get(now_id).right);
                int next_id = L.get(next_num);
                if(T.get(next_id).right==-100&&T.get(next_id).left==-100){
                    int parent_id = L.get(T.get(next_id).parent);
                    if(T.get(parent_id).left==T.get(next_id).value) T.get(parent_id).left = -100;
                    else T.get(parent_id).right = -100;
                }
                else if(T.get(next_id).right!=-100){
                    int right_id = L.get(T.get(next_id).right);
                    int parent_id = L.get(T.get(next_id).parent);
                    T.get(right_id).parent = T.get(next_id).parent;
                    if(T.get(parent_id).left==T.get(next_id).value)T.get(parent_id).left = T.get(right_id).value;
                    else T.get(parent_id).right = T.get(right_id).value;
                }
                T.get(next_id).parent = T.get(now_id).parent;
                if(T.get(next_id).right!=T.get(now_id).right)T.get(next_id).right = T.get(now_id).right;
                if(T.get(next_id).left!=T.get(now_id).left)T.get(next_id).left = T.get(now_id).left;
                if(T.get(now_id).right!=-100){
                    int ri = L.get(T.get(now_id).right);
                    T.get(ri).parent = T.get(next_id).value;
                }
                if(T.get(now_id).left!=-100) {
                    int li = L.get(T.get(now_id).left);
                    T.get(li).parent = T.get(next_id).value;
                }
                int pi = L.get(T.get(now_id).parent);
                if(T.get(pi).left==T.get(now_id).value) T.get(pi).left = T.get(next_id).value;
                else T.get(pi).right = T.get(next_id).value;

            }
            else{
                int p_id = L.get(T.get(now_id).parent);
                int c_id;
                if(T.get(now_id).left!=-100) c_id = L.get(T.get(now_id).left);
                else c_id = L.get(T.get(now_id).right);
                if(T.get(p_id).left==value) T.get(p_id).left=T.get(c_id).value;
                else T.get(p_id).right = T.get(c_id).value;
                T.get(c_id).parent = T.get(p_id).value;
            }
        }
        else if(T.get(now_id).value>value&&T.get(now_id).left!=-100) delete(T,L,value,L.get(T.get(now_id).left));
        else if(T.get(now_id).value<value&&T.get(now_id).right!=-100) delete(T,L,value,L.get(T.get(now_id).right));
    }
    public static class Node{
        int value,parent,left,right;
        public void element(int value,int parent,int left,int right){
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
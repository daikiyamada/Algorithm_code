import java.util.*;
public class Main {
    static int root_value = 0;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        ArrayList<Node> T = new ArrayList<>();
        Map<Integer,Integer> L = new HashMap<>();
        for(int i=0;i<n;i++) {
            String command = sc.next();
            if (command.charAt(0) == 'i') {
                Node v = new Node();
                int value = sc.nextInt();
                int priority = sc.nextInt();
                if (T.size() == 0) {
                    root_value = value;
                    v.element(value, priority, -1, -1, -1);
                    L.put(v.value, T.size());
                    T.add(v);
                } else insert(T, L, value, priority, root_value);
            } else if (command.charAt(0) == 'f') {
                int value = sc.nextInt();
                boolean check = false;
                check = find(T, L, value, root_value, check);
                if (check) System.out.println("yes");
                else System.out.println("no");
            } else if (command.charAt(0) == 'd') {
                int value = sc.nextInt();
                delete(T,L,value,root_value);
            } else {
                StringBuilder P = new StringBuilder();
                StringBuilder I = new StringBuilder();
                //for(Node v:T) System.out.println(v.value+":"+v.parent+"-"+v.left+"-"+v.right);
                print(T, L, root_value, P, I);
                System.out.println(I);
                System.out.println(P);
            }
        }
    }
    public static void print(ArrayList<Node>T,Map<Integer,Integer>L,int value,StringBuilder P,StringBuilder I){
        P.append(" "+value);
        if(T.get(L.get(value)).left!=-1)print(T,L,T.get(L.get(value)).left,P,I);
        I.append(" "+value);
        if(T.get(L.get(value)).right!=-1)print(T,L,T.get(L.get(value)).right,P,I);
    }
    public static void insert(ArrayList<Node>T,Map<Integer,Integer> L,int value,int priority,int now_value){
        if(T.get(L.get(now_value)).value>value){
            if(T.get(L.get(now_value)).left==-1){
                Node v = new Node();
                v.element(value,priority,now_value,-1,-1);
                L.put(value,T.size());
                T.add(v);
                T.get(L.get(now_value)).left=value;
            }
            else insert(T,L,value,priority,T.get(L.get(now_value)).left);
            int left_value = T.get(L.get(now_value)).left;
           if(T.get(L.get(now_value)).priority<T.get(L.get(left_value)).priority) right_rotate(T,L,now_value);
        }
        else if(T.get(L.get(now_value)).value<value){
            if(T.get(L.get(now_value)).right==-1){
                Node v = new Node();
                v.element(value,priority,now_value,-1,-1);
                L.put(value,T.size());
                T.add(v);
                T.get(L.get(now_value)).right=value;
            }
            else insert(T,L,value,priority,T.get(L.get(now_value)).right);
            int right_value = T.get(L.get(now_value)).right;
           if(T.get(L.get(now_value)).priority< T.get(L.get(right_value)).priority) left_rotate(T,L,now_value);
        }
    }
    public static boolean find(ArrayList<Node> T,Map<Integer,Integer>L,int value,int now_value,boolean check){
        if(now_value==value) check =true;
        else if(T.get(L.get(now_value)).left!=-1&&value<now_value)check = find(T,L,value,T.get(L.get(now_value)).left,check);
        else if(T.get(L.get(now_value)).right!=-1&&value>now_value)check = find(T,L,value,T.get(L.get(now_value)).right,check);
        return check;
    }
    public static void delete(ArrayList<Node> T,Map<Integer,Integer>L,int value,int now_value){
        if(value<now_value&&T.get(L.get(now_value)).left!=-1) delete(T,L,value,T.get(L.get(now_value)).left);
        else if(value>now_value&&T.get(L.get(now_value)).right!=-1)delete(T,L,value,T.get(L.get(now_value)).right);
        else if(value==now_value){
            if(T.get(L.get(value)).left==-1&&T.get(L.get(value)).right==-1) delete_node(T,L,value);
            else if(T.get(L.get(value)).left==-1) {
                if(root_value==value)root_value = T.get(L.get(value)).right;
                left_rotate(T,L,value);
                delete(T,L,value,value);
            }
            else if(T.get(L.get(value)).right==-1){
                if(root_value==value)root_value = T.get(L.get(value)).left;
                right_rotate(T,L,value);
                delete(T,L,value,value);
            }
            else{
                int l = T.get(L.get(value)).left;
                int r = T.get(L.get(value)).right;
                if(T.get(L.get(l)).priority<T.get(L.get(r)).priority){
                    if(root_value==value)root_value = T.get(L.get(value)).right;
                    left_rotate(T,L,value);
                    delete(T,L,value,value);
                }
                else {
                    if(root_value==value)root_value = T.get(L.get(value)).left;
                    right_rotate(T,L,value);
                    delete(T,L,value,value);
                }

            }
        }
    }
    public static void delete_node(ArrayList<Node> T,Map<Integer,Integer> L,int value){
        int p = T.get(L.get(value)).parent;
        if(p!=-1) {
            if (T.get(L.get(p)).left == value) T.get(L.get(p)).left = -1;
            else T.get(L.get(p)).right = -1;
        }
        if(T.get(L.get(value)).left!=-1){

        }
        T.get(L.get(value)).parent = -1;
        T.get(L.get(value)).left = -1;
        T.get(L.get(value)).right = -1;
    }
    public static void right_rotate(ArrayList<Node> T,Map<Integer,Integer> L,int p){
        int c = T.get(L.get(p)).left;
        int gc = T.get(L.get(c)).right;
        int pp = T.get(L.get(p)).parent;
        if(pp!=-1) {
            if (T.get(L.get(pp)).left == p) T.get(L.get(pp)).left = c;
            else T.get(L.get(pp)).right = c;
        }
        T.get(L.get(c)).parent = T.get(L.get(p)).parent;
        T.get(L.get(c)).right = p;
        T.get(L.get(p)).parent = c;
        T.get(L.get(p)).left = gc;
        if(gc!=-1) T.get(L.get(gc)).parent = p;
        if(root_value==p) root_value=c;
    }
    public static void left_rotate(ArrayList<Node> T,Map<Integer,Integer> L,int p){
        int c = T.get(L.get(p)).right;
        int gc = T.get(L.get(c)).left;
        int pp = T.get(L.get(p)).parent;
        if(pp!=-1) {
            if (T.get(L.get(pp)).left == p) T.get(L.get(pp)).left = c;
            else T.get(L.get(pp)).right = c;
        }
        T.get(L.get(c)).parent = T.get(L.get(p)).parent;
        T.get(L.get(c)).left = p;
        T.get(L.get(p)).right = gc;
        T.get(L.get(p)).parent = c;
        if(gc!=-1) T.get(L.get(gc)).parent = p;
        if(root_value==p) root_value=c;
    }
    public static class Node{
        int value,priority,parent,left,right;
        private void element(int value,int priority,int parent,int left,int right){
            this.value = value;
            this.priority = priority;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> L = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int w = sc.nextInt();
                if(i<j&&w!=-1){
                    Node N = new Node();
                    N.element(w,i,j);
                    L.add(N);
                }
            }
        }
        Collections.sort(L, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w<o2.w?-1:1;
            }
        });
        ArrayList<Set<Integer>> T = new ArrayList<>();
        int opt = 0;
        while(L.size()!=0){
            Node e = L.remove(0);
            int t1=-1,t2=-1;
            for(int i=0;i<T.size();i++){
                if(T.get(i).contains(e.v1)) t1 = i;
                if(T.get(i).contains(e.v2)) t2 = i;
            }
            if(t1==-1&&t2==-1){
                Set<Integer> t = new HashSet<>();
                t.add(e.v1);
                t.add(e.v2);
                T.add(t);
                opt+=e.w;
            }
            else if(t1!=t2){
                opt+=e.w;
                if(t1==-1) T.get(t2).add(e.v1);
                else if(t2==-1)T.get(t1).add(e.v2);
                else{
                    T.get(t1).addAll(T.get(t2));
                    T.remove(t2);
                }
            }
        }
        System.out.println(opt);
    }
    public static class Node{
        int w,v1,v2;
        public void element(int w,int v1,int v2){
            this.w = w;
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}
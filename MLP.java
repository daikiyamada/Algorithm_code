import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer,ArrayList<Integer>> Edge = new HashMap<>();
        Map<Integer,ArrayList<Integer>> Edge2 = new HashMap<>();
        int DP [] = new int[N+1];
        Arrays.fill(DP,0);
        ArrayList<Integer> S = new ArrayList<>();
        Queue<Integer> L = new ArrayDeque<>();
        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(Edge.get(y)==null){
                ArrayList<Integer> E = new ArrayList<>();
                E.add(x);
                Edge.put(y,E);
            }
            else{
                Edge.get(y).add(x);
            }
            if(Edge2.get(x)==null){
                ArrayList<Integer> E = new ArrayList<>();
                E.add(y);
                Edge2.put(x,E);
            }
            else Edge2.get(x).add(y);
        }
        int max = 0;
        for(int i=1;i<N+1;i++) if(Edge.get(i)==null) L.add(i);
        while(L.size()!=0) {
            int source = L.poll();
            S.add(source);
            if(Edge2.get(source)!=null){
                for(int sink:Edge2.get(source)){
                    Edge.get(sink).remove(Edge.get(sink).indexOf(source));
                    DP[sink] = Math.max(DP[sink],DP[source]+1);
                    if(max<DP[sink])max =DP[sink];
                    if(Edge.get(sink).size()==0) L.add(sink);
                }
            }
        }
        System.out.println(max);
    }
}
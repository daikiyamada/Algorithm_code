import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int [][] List = new int[V][V];
        int [] list = new int[V];
        for(int [] L:List) Arrays.fill(L,0);
        Arrays.fill(list,0);
        for(int i=0;i<E;i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            List[s][t]=1;
            list[t]++;
        }
        ArrayList<Integer> L = new ArrayList<>();
        Deque<Integer> S = new ArrayDeque<>();
        for(int i=0;i<list.length;i++) if(list[i]==0) S.add(i);
        while(S.size()!=0){
            int v = S.poll();
            L.add(v);
            for(int i=0;i<V;i++){
                if(List[v][i]==1){
                    List[v][i]=0;
                    list[i]--;
                    if(list[i]==0)S.add(i);
                }
            }
        }
        for(int i:L) System.out.println(i);
    }
}

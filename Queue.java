import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int time = 0;
        int [] T = new int[n];
        String [] Name = new String[n];
        Queue<Integer> L = new ArrayDeque<>();
        ArrayList<Integer> opt = new ArrayList<>();
        for(int i=0;i<n;i++){
            Name[i] = sc.next();
            T[i] = sc.nextInt();
            L.add(i);
        }
        while(L.size()!=0){
            int p_num = L.poll();
            if(T[p_num]-q>0){
                time+=q;
                T[p_num]-=q;
                L.add(p_num);
            }
            else{
                time+=T[p_num];
                T[p_num]=time;
                opt.add(p_num);
            }
        }
        for(int i:opt) System.out.println(Name[i]+" "+T[i]);
    }
}
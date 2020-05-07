import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] W = new int[n];
        for(int i=0;i<n;i++)W[i] = sc.nextInt();
        System.out.println(minsort(W));
    }
    public static int minsort(int [] W){
        int cost = 0;
        int [] sorted = W.clone();
        Arrays.sort(sorted);
        for(int i=0;i<W.length;i++){
            int cnt = 0;
            int x = getindex(W,sorted[i]);
            while(x>i){
                cnt++;
                int y = getindex(W,sorted[x]);
                cost+=W[y];
                swap(W,x,y);
                x = y;
            }
            cost+=Math.min(sorted[i]*cnt,sorted[i]*2+sorted[0]*(cnt+2));
        }
        return cost;
    }
    public static void swap(int [] W,int i,int j){
        int w = W[i];
        W[i] = W[j];
        W[j] = w;
    }
    public static int getindex(int [] L,int num){
        for(int i=0;i<L.length;i++){
            if(L[i] == num) return i;
        }
        return -1;
    }
}


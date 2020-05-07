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

/*
        int N = sc.nextInt();
        ArrayList<int []> A = new ArrayList<>();
        for(int i=1;i<=N;i++){
            int L [] = new int[2];
            L[0] = sc.nextInt();
            L[1] = i;
            A.add(L);
        }

I問題 Coins
        int N = sc.nextInt();
        double P [] = new double[N+1];
        double DP[][] = new double[N+1][N+1];
        for(int i=1;i<=N;i++){
            P[i]= sc.nextDouble();
            Arrays.fill(DP[i],0);
        }
        DP[0][0]=1;
        for(int i=1;i<=N;i++){
            for(int j=0;j<=i;j++){
                if(j>0)DP[i][j] = DP[i-1][j-1] * P[i]+DP[i-1][j]*(1-P[i]);
                else DP[i][j]=DP[i-1][j]*(1-P[i]);
            }
        }
        double opt = 0;
        for(int i=(N+1)/2;i<=N;i++) opt += DP[N][i];
        System.out.println(opt);
 */
/*
        int N = sc.nextInt();
        StringBuilder S = new StringBuilder();
        S.append("i");
        S.append(sc.next());
        long r =0,g=0,b=0;
        for(int i=1;i<=N;i++){
            if(S.charAt(i)=='R') r++;
            else if(S.charAt(i)=='G')g++;
            else if(S.charAt(i)=='B')b++;
        }
        long opt = r*g*b;
        for(int i=1;i<=N-1;i++){
            for(int j=i+1;j<=(N+i)/2;j++){
                int k = 2*j-i;
                if(S.charAt(i)!=S.charAt(j)&&S.charAt(j)!=S.charAt(k)&&S.charAt(i)!=S.charAt(k))opt--;
            }
        }
        if(opt>=0)System.out.println(opt);
        else System.out.println(0);
 */
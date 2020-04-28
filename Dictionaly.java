import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       Map<String,Integer> S = new HashMap<>();
        for(int i=0;i<n;i++){
            String s = sc.next();
            String t = sc.next();
            if(s.charAt(0)=='i') S.put(t,1);
            else if(S.get(t)==null) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
/*
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
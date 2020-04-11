import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        long [][] DP = new long[H+1][W+1];
        int [][] L = new int[H+1][W+1];
        for(int i=0;i<H+1;i++){
            Arrays.fill(DP[i],0);
            Arrays.fill(L[i],0);
        }
        for(int i=1;i<=H;i++){
            String s = sc.next();
            for(int j=1;j<=W;j++){
                if(s.charAt(j-1)=='.') L[i][j] = 0;
                else L[i][j] = 1;
            }
        }
        DP[1][1]=1;
        for(int i =1;i<=H;i++){
            for(int j=1;j<=W;j++){
                if(L[i-1][j]==0) DP[i][j]=(DP[i][j]+DP[i-1][j])%1000000007;
                if(L[i][j-1]==0)DP[i][j]=(DP[i][j]+DP[i][j-1])%1000000007;
            }
        }
        System.out.println(DP[H][W]);
    }
}
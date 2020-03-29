import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int DP[][] = new int[s.length()+1][t.length()+1];
        int L [][] = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++) {
            Arrays.fill(DP[i],0);
            Arrays.fill(L[i],0);
        }
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<t.length()+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1]+1;
                    L[i][j] = 2;
                }
                else {
                    DP[i][j] = Math.max(DP[i-1][j],DP[i][j-1]);
                    if(DP[i][j]==DP[i-1][j])L[i][j] =1;
                    else L[i][j]=3;
                }
            }
        }
        StringBuilder opt = new StringBuilder();
        int i = s.length(), j = t.length();
        for(int k=0;k<s.length()*t.length();k++){
            if(s.charAt(i-1)==t.charAt(j-1)) opt.insert(0,s.charAt(i-1));
            if(L[i][j]==1) i--;
            else if(L[i][j]==3) j--;
            else if(L[i][j]==2){
                i--;
                j--;
            }
            if(i==0||j==0) break;
        }
        System.out.println(opt);
    }
}
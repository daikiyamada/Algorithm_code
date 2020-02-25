import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int DP [][] = new int[s.length()+1][t.length()+1];
        int List [][] = new int[s.length()+1][t.length()+1];
        StringBuilder opt = new StringBuilder();
        for(int i=0;i<s.length()+1;i++) DP[i][0]=0;
        for(int j=0;j<t.length()+1;j++) DP[0][j]=0;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    DP[i][j]=DP[i-1][j-1]+1;
                    List[i][j] = 2;
                }
                else if(s.charAt(i-1)!=t.charAt(j-1)) {
                    DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j]);
                    if(DP[i][j]==DP[i][j-1])List[i][j]=3;
                    else List[i][j]=1;
                }
            }
        }
       int i = s.length(), j = t.length();
        for(int k=0;k<s.length()*t.length();k++){
            if(s.charAt(i-1)==t.charAt(j-1)) opt.append(s.charAt(i-1));
            if(List[i][j]==1) i--;
            else if(List[i][j]==3) j--;
            else if(List[i][j]==2){
                i--;
                j--;
            }
            if(i==0||j==0) break;
        }
        for(i=opt.length()-1;i>=0;i--)System.out.print(opt.charAt(i));
        System.out.println();
    }
}

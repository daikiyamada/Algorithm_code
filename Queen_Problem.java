import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int L [][] = new int[8][8];
        int k = sc.nextInt();
        for(int i=0;i<8;i++)Arrays.fill(L[i],0);
        for(int i=0;i<k;i++)Check(L,sc.nextInt(),sc.nextInt());
        //探索
        whole:for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                int [][] L2 = deep_copy(L);
                L2=Find(L2,i,j);
                if(check(L2)==8) {
                    L = L2;
                    break whole;
                }
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(L[i][j]==2)System.out.print("Q");
                else System.out.print(".");
            }
            System.out.println();
        }
    }
    //探索関数
    public static int[][] Find(int L[][],int r,int c){
        if(check(L)==8)return L;
        int [][] L2 = new int[8][8];
        whole:for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(L[i][j]==0){
                    Check(L,r,c);
                    L2 = deep_copy(L);
                    L2 = Find(L2,i,j);
                    if(check(L2)==8) break whole;
                }
            }
        }
        return L2;
    }
    //縦横斜めのチェックをする関数
    public static void Check(int L[][],int r,int c){
        L[r][c]=2;
        for(int i=1;i<=7;i++){
            if(r-i>=0)L[r-i][c]=1;
            if(r+i<8)L[r+i][c]=1;
            if(c-i>=0)L[r][c-i]=1;
            if(c+i<8)L[r][c+i]=1;
            if(r+i<8&&c+i<8)L[r+i][c+i]=1;
            if(r-i>=0&&c-i>=0)L[r-i][c-i]=1;
            if(r+i<8&&c-i>=0)L[r+i][c-i]=1;
            if(r-i>=0&&c+i<8)L[r-i][c+i]=1;
        }
    }
    public static int [][] deep_copy(int L[][]){
        int L2 [][] = new int[8][8];
        for(int i=0;i<8;i++)for(int j=0;j<8;j++) L2[i][j] = L [i][j];
        return L2;
    }
    public static int check(int L[][]){
        int num = 0;
        for(int i=0;i<8;i++)for(int j=0;j<8;j++)if(L[i][j]==2)num++;
        return num;
    }
}
import java.util.*;public class Main {    public static void main(String[] args) {        Scanner sc = new Scanner(System.in);        int N = sc.nextInt();        int Q = sc.nextInt();        int [][] L = new int[N+1][2];        for(int i=0;i<N+1;i++) Arrays.fill(L[i],-1);        for(int i=0;i<Q;i++){            int q = sc.nextInt();            int x = sc.nextInt();            int y = 0;            if(q!=3) y = sc.nextInt();            if(q==1){                L[x][1] = y;                L[y][0] = x;            }            else if(q==2){                L[x][1] = -1;                L[y][0] = -1;            }            else if(q==3){                StringBuilder sb = new StringBuilder();                int now = x;                sb.append(x);                //System.out.println("Query 3:"+x);                int cnt = 0;                /**後続列車の出力*/                while(true){                    int next = L[now][1];                    cnt++;                    if(next==-1) break;                    //System.out.println("next:"+now+","+L[now][0]+","+L[now][1]);                    sb.append(" "+next);                    now = next;                }                now = x;                cnt--;                /**前の接続列車の出力*/                while(true){                    int pre = L[now][0];                    cnt++;                    if(pre==-1) break;                    //System.out.println("pre:"+now+","+L[now][0]+","+L[now][1]);                    sb.insert(0,pre+" ");                    now = pre;                }                sb.insert(0,cnt+" ");                System.out.println(sb);            }        }    }}
import java.util.*;public class Main {    public static void main(String[] args) {        Scanner sc = new Scanner(System.in);        int N = sc.nextInt();        int [] L =new int[N];        Arrays.fill(L,999999999);        int cnt = 0;        for(int i=0;i<N;i++){            int now = sc.nextInt();            for(int j=0;j<N;j++){                if(L[j] == 999999999){                    cnt++;                    L[j] = now;                    break;                }                else if(L[j]>=now){                    L[j] = now;                    break;                }            }        }        System.out.println(cnt);    }}
import java.math.BigInteger;import java.util.*;public class Main{    public static void main(String [] args) {        Scanner sc = new Scanner(System.in);        int [] L = new int[64];        Arrays.fill(L,0);        int cnt = 0;        int q = sc.nextInt();        for(int i=0;i<q;i++){            int cmd = sc.nextInt();            if(cmd==0) System.out.println(L[63-sc.nextInt()]);            else if(cmd==1){                int num = sc.nextInt();                if(L[63-num]==0)cnt++;                L[63-num] = 1;            }            else if(cmd==2){                int num = sc.nextInt();                if(L[63-num]==1)cnt--;                L[63-num] = 0;            }            else if(cmd==3){                int num = sc.nextInt();                if(L[63-num]==0){                    L[63-num] = 1;                    cnt++;                }                else{                    L[63-num] = 0;                    cnt--;                }            }            else if(cmd==4){                if(cnt==64) System.out.println(1);                else System.out.println(0);            }            else if(cmd==5){                if(cnt>0) System.out.println(1);                else System.out.println(0);            }            else if(cmd==6){                if(cnt==0) System.out.println(1);                else System.out.println(0);            }            else if(cmd==7) System.out.println(cnt);            else{                StringBuilder sb = new StringBuilder();                for(int j=0;j<64;j++)sb.append(L[j]);                String sb2 = sb.toString();                BigInteger sol = new BigInteger(sb2,2);                System.out.println(sol);            }        }    }}
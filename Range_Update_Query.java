import java.util.*;public class Main {    public static void main(String [] args) {        Scanner sc = new Scanner(System.in);        int n = sc.nextInt();        int q = sc.nextInt();        ArrayList<Node> L = new ArrayList<>();        int cnt = 1;        Node ini = new Node();        ini.element(0,0,n-1,2147483647);        L.add(ini);        StringBuilder sb = new StringBuilder();        for(int i=0;i<q;i++){            int cmd = sc.nextInt();            if(cmd==0){                int s = sc.nextInt();                int t = sc.nextInt();                long x = sc.nextLong();                Node v = new Node();                v.element(cnt,s,t,x);                L.add(v);                cnt++;            }            else {                int j = sc.nextInt();                for(int k = cnt-1;k>=0;k--){                    if(L.get(k).s<=j&&L.get(k).t>=j){                        sb.append(L.get(k).x+"\n");                        break;                    }                }            }        }        System.out.print(sb);    }    public static class Node{        int num,s,t;        long x;        public void element(int num,int s,int t,long x){            this.num = num;            this.s = s;            this.t = t;            this.x = x;        }    }}
import java.util.*;public class Main {    public static void main(String[] args) {        Scanner sc = new Scanner(System.in);        long n = sc.nextLong();        Set<Long> Prime_List = new HashSet<>();        long now = n;        for(long i=2;i<=Math.sqrt(n);i++){            while(true){                if(now%i==0){                    Prime_List.add(i);                    now/=i;                }                else break;            }        }        if(now!=1) Prime_List.add(now);        double opt = 1;        for(long i:Prime_List){            double p = (double)1/i;            p=1-p;            opt*=(p);        }        opt*=n;        opt = Math.round(opt);        long sol = (long)opt;        System.out.println(sol);    }}
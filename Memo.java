import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] L = new int[N+1];
        Arrays.fill(L,-1);
        L[0]=1;
        L[1]=1;
        int opt = fibo(N);
        System.out.println();
        System.out.println(opt);
        int opt2 = fibo2(N,L);
        System.out.println();
        System.out.println(opt2);
    }
    public static int fibo(int i){
        System.out.print("a ");
        if(i==0||i==1)return 1;
        return fibo(i-1)+fibo(i-2);
    }
    public static int fibo2(int i,int L[]){
        System.out.print("b ");
        if(L[i]!=-1) return L[i];
        return L[i]=fibo2(i-1,L)+fibo2(i-2,L);
    }
}

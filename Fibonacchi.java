import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fibo [] = new int[n+1];
        Arrays.fill(fibo,-1);
        fibo[0] = 1;
        fibo[1] = 1;
        int opt = fibonacchi(fibo,n);
        System.out.println(opt);
    }
    public static int fibonacchi(int [] fibo,int i) {
        if(fibo[i]==-1) return fibo[i] = fibonacchi(fibo,i-1)+fibonacchi(fibo,i-2);
        else return fibo[i];
    }
}
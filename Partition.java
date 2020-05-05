import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []  A = new int [n];
        for(int i=0;i<n;i++)A[i] = sc.nextInt();
        int num = partition(A,0,n-1);
        System.out.print(A[0]);
        for(int i=1;i<n;i++){
            if(i!=num) System.out.print(" "+A[i]);
            else System.out.print(" ["+A[i]+"]");
        }
        System.out.println();
    }
    public static int partition(int [] A,int p,int r){
        int x = A[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(A[j]<=x){
                i++;
                A=swap(A,i,j);
            }
        }
        A=swap(A,i+1,r);
        return i+1;
    }
    public static int [] swap(int A[],int i,int j){
        int num = A[i];
        A[i] = A[j];
        A[j] = num;
        return A;
    }
}
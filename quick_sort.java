import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        card [] A  = new card[n];
        for(int i=0;i<n;i++){
            card c = new card();
            c.insert(sc.next(),sc.nextInt(),i);
            A[i] = c;
        }
        quicksort(A,0,n-1);
        boolean check = true;
        for(int i=0;i<n-1;i++) if(A[i].num==A[i+1].num&&A[i].index>A[i+1].index) check = false;
        if(check) System.out.println("Stable");
        else System.out.println("Not stable");
        for(int i=0;i<n;i++) System.out.println(A[i].mark+" "+A[i].num);
    }
    public static void quicksort(card [] A,int p,int r){
        if(p<r){
            int q = partition(A,p,r);
            quicksort(A,p,q-1);
            quicksort(A,q+1,r);
        }
    }
    public static int partition(card [] A ,int p,int r){
        int x = A[r].num;
        int i = p-1;
        for(int j=p;j<r;j++){
            if(A[j].num<=x){
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,r);
        return i+1;
    }
    public static void swap(card [] A,int i,int j){
        String mark = A[i].mark;
        int num = A[i].num;
        int index = A[i].index;
        A[i].mark = A[j].mark;
        A[i].num = A[j].num;
        A[i].index = A[j].index;
        A[j].mark = mark;
        A[j].num = num;
        A[j].index = index;
    }
    public static class card{
        String mark;
        int num;
        int index;
        public void insert(String mark,int num,int index){
            this.mark = mark;
            this.num = num;
            this.index = index;
        }
    }
}
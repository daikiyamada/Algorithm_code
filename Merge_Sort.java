import java.util.Scanner;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] S = new int[n];
        int opt = 0;
        for(int i=0;i<n;i++) S[i] = sc.nextInt();
        opt = mergesort(S,opt,0,n);
        for(int i=0;i<n;i++){
            System.out.print(S[i]);
            if(i!=n-1) System.out.print(" ");
        }
        System.out.println();
        System.out.println(opt);
    }
    public static int  mergesort(int [] S,int sum,int left,int right){
        if(left+1<right){
            int mid = (left+right)/2;
            sum=mergesort(S,sum,left,mid);
            sum=mergesort(S,sum,mid,right);
            sum=merge(S,left,right,mid,sum);
        }
        return sum;
    }
    public static int merge(int [] S,int left,int right,int mid,int sum){
        int n1 = mid-left;
        int n2 = right-mid;
        int L[] = new int[n1+1];
        int R[] = new int[n2+1];
        for(int i=0;i<n1;i++)L[i] = S[left+i];
        for(int i=0;i<n2;i++)R[i] = S[mid+i];
        L[n1]=999999999;
        R[n2]=999999999;
        int i=0,j=0;
        for(int k=left;k<right;k++){
            if(L[i]<=R[j]){
                S[k] = L[i];
                i++;
                sum++;
            }
            else{
                S[k] = R[j];
                j++;
                sum++;
            }
        }
        return sum;
    }
}
/*
選択ソート

        int n = sc.nextInt();
        int [] List = new int[n];
        for(int i=0;i<n;i++) List[i]=sc.nextInt();
        for(int i=0;i<n;i++){
        int v = List[i];
        int j = i-1;

        while(j>=0&&List[j]>v){
        List[j+1] = List[j];
        j--;
        }
        List[j+1]=v;
        for(int k=0;k<n;k++){
        System.out.print(List[k]);
        if(k!=n-1) System.out.print(" ");
        }
        System.out.println();
        }
 */

/*
    public static int GCD(int a,int b){
        if(b==0) return a;
        else return GCD(b,a%b);
    }
 */
/*
        int N = sc.nextInt();
        String [] Mark = new String[N];
        String [] Mark_bubble = new String[N];
        int [] Num = new int[N];
        int [] Num_B = new int[N];
        boolean  check = true;
        for(int i=0;i<N;i++){
            String now = sc.next();
            String mark  = String.valueOf(now.charAt(0));
            Mark[i] = mark;
            Mark_bubble[i] = mark;
            int num = Character.getNumericValue(now.charAt(1));
            Num[i] = num;
            Num_B[i] = num;
        }
        for(int i=0;i<N;i++){
            for(int j=N-1;j>=i+1;j--){
                if(Num_B[j-1]>Num_B[j]){
                    int min = Num_B[j];
                    String min_mark = Mark_bubble[j];
                    Num_B[j] = Num_B[j-1];
                    Mark_bubble[j] = Mark_bubble[j-1];
                    Num_B[j-1] = min;
                    Mark_bubble[j-1] = min_mark;
                }
            }
        }
        for(int i=0;i<N;i++) {
            System.out.print(Mark_bubble[i]+Num_B[i]);
            if(i<N-1) System.out.print(" ");
        }
        System.out.println();
        System.out.println("Stable");
        for(int i=0;i<N-1;i++){
           int min = i;
            for(int j=i+1;j<N;j++) if(Num[min]>Num[j]) min = j;
            int num = Num[min];
            String mark = Mark[min];
            Num[min] = Num[i];
            Mark[min] =Mark[i];
            Num[i] = num;
            Mark[i] = mark;
        }
        for(int i=0;i<N;i++) if(Mark[i]!=Mark_bubble[i]) check = false;
        for(int i=0;i<N;i++) {
            System.out.print(Mark[i]+Num[i]);
            if(i<N-1) System.out.print(" ");
        }
        System.out.println();
        if(check) System.out.println("Stable");
        else System.out.println("Not stable");
 */
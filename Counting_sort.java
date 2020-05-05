import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] input = new int[n];
        int [] output = new int[n];
        int k = 0;
        for(int i=0;i<n;i++){
            input[i] = sc.nextInt();
            if(input[i] > k) k = input[i];
        }
        int [] C = new int[k+1];
        Arrays.fill(C,0);
        for(int i=0;i<n;i++) C[input[i]]++;
        for(int i=1;i<=k;i++) C[i] += C[i-1];
        for(int i=n-1;i>=0;i--){
            output[C[input[i]]-1] = input[i];
            C[input[i]]--;
        }
        StringBuilder ans = new StringBuilder();
        ans.append(output[0]);
        for(int i=1;i<n;i++) ans.append(" "+output[i]);
        System.out.println(ans);
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
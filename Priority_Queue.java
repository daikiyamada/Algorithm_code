import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> A = new PriorityQueue<>(Collections.reverseOrder());
        while(true){
            String cmd = sc.next();
            if(cmd.equals("end")) break;
            else if(cmd.charAt(0)=='i')A.add(sc.nextInt());
            else System.out.println(A.poll());
        }
    }
}
import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        Map<Character,Integer> Result_List = new HashMap<Character,Integer>();
        for(int i=0;i<S.length();i++){
            if(Result_List.containsKey(S.charAt(i))) Result_List.replace(S.charAt(i),Result_List.get(S.charAt(i))+1);
            else Result_List.put(S.charAt(i),1);
        }
        ArrayList<Character> L = new ArrayList<>(Result_List.keySet());
        Collections.sort(L);
        char solution = L.get(0);
        int max = Result_List.get(L.get(0));
        for(int i=1;i<L.size();i++){
            if(Result_List.get(L.get(i))>max){
                max = Result_List.get(L.get(i));
                solution = L.get(i);
            }
        }
        System.out.println(solution);
    }
}

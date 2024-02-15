import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        boolean upper_check = Character.isUpperCase(S.charAt(0));
        boolean lower_check = true;
        for(int i =1;i<S.length();i++){
            if(!Character.isLowerCase(S.charAt(i))){
                lower_check = false;
                break;
            }
        }
        if(upper_check&&lower_check) System.out.println("Yes");
        else System.out.println("No");
    }
}

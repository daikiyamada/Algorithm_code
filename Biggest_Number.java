import com.sun.xml.internal.xsom.XSUnionSimpleType;import java.util.*;public class Main {    public static void main(String[] args) {        Scanner sc = new Scanner(System.in);        String A = sc.next();        String B = sc.next();        StringBuilder str_A = new StringBuilder(A);        str_A = str_A.reverse();        boolean check_A = true;        if(A.contains("-")){            check_A = false;            str_A.deleteCharAt(str_A.length()-1);        }        StringBuilder str_B = new StringBuilder(B);        str_B = str_B.reverse();        boolean check_B = true;        if(B.contains("-")){            check_B = false;            str_B.deleteCharAt(str_B.length()-1);        }        /*１の桁から計算*/        int max = Math.max(str_A.length(),str_B.length());        StringBuilder opt = new StringBuilder();        int c = 0;        /*場合分け        * ①+,+ or -,-が下のバターン*/        if(check_A==check_B){            for(int i =0;i<max;i++){                int a = 0 ,b = 0;                if(str_A.length()>i) a = Character.getNumericValue(str_A.charAt(i));                if(str_B.length()>i) b = Character.getNumericValue(str_B.charAt(i));                int sum = a+b+c;                if(sum>=10){                    String s = String.valueOf(sum);                    opt.insert(0,s.charAt(1));                    c = Character.getNumericValue(s.charAt(0));                }                else{                    opt.insert(0,String.valueOf(sum).charAt(0));                    c = 0;                }            }            if(c!=0) opt.insert(0,String.valueOf(c).charAt(0));            if(!check_A) System.out.println("-"+opt);            else System.out.println(opt);        }        /*        ②+,- or -,+の場合別パターン　→　繰り下げ用         */        else if(!check_A){        }        else{        }    }}
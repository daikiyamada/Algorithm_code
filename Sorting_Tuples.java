import java.util.*;public class Main {    public static void main(String [] args) {        Scanner sc = new Scanner(System.in);        int n = sc.nextInt();        ArrayList<Node> L = new ArrayList<>();        for(int i=0;i<n;i++){            Node v = new Node();            v.element(sc.nextLong(),sc.nextLong(),sc.next(),sc.nextLong(),sc.next());            L.add(v);        }        Sort(L);        for(Node v:L) System.out.println(v.v+" "+v.w+" "+v.t+" "+v.d+" "+v.s);    }    public static void Sort(ArrayList<Node> L){        Collections.sort(L, new Comparator<Node>() {            @Override            public int compare(Node o1, Node o2) {                if(o1.v==o2.v){                    if(o1.w==o2.w) {                        if(o1.t.equals(o2.t)){                            if(o1.d==o2.d) return o1.s.compareTo(o2.s)>=0?1:-1;                            else return o1.d>o2.d?1:-1;                        }                        else return o1.t.compareTo(o2.t)>=0?1:-1;                    }                    else return o1.w>o2.w?1:-1;                }                return o1.v>o2.v?1:-1;            }        });    }    public static class Node{        long v,w,d;        String t,s;        public void element(long v,long w,String t,long d,String s){            this.v = v;            this.w = w;            this.t = t;            this.d = d;            this.s = s;        }    }}
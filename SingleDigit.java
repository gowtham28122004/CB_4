import java.util.*;

class SingleDigit {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        System.out.println(n%9==0?9:n%9);
    }
}

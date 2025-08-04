import java.util.*;

public class Josephus
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = 0;
		int i = 0;
		while(Math.pow(2,i) < n) {
		    m = (int)Math.pow(2,i++);
		}
		int r = n - m;
		int res = r*2+1 > n? r*2+1-n:r*2+1;
		System.out.println(res);
	}
}

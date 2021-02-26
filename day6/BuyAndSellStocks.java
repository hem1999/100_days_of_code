import java.util.*;
import java.lang.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int profit =0;
		Stack<Integer> st = new Stack<>();
		while(n-- >0 ){
			int cur = sc.nextInt();
			if (st.empty()){
				st.push(cur);
			}

			if(st.peek() > cur){
				st.push(cur);
			}else{
				int cur_profit = cur - st.peek();
				profit = Math.max(profit,cur_profit);
			}
		}

		System.out.println(profit)
    }
}
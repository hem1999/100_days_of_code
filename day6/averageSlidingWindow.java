import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        int key = sc.nextInt();
        int sum = 0;
        while(key!=-1){
            sum+=key;
            if(q.size() >= n){
                
                sum-=q.remove();
            }

            q.add(key);
            key = sc.nextInt();
            double average  = (double) sum/q.size();
            System.out.printf("%.4f ",average);
        }
        System.out.println();
    }
}
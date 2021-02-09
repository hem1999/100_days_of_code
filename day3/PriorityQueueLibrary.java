import java.util.PriorityQueue;
import java.util.Collections;

class PriorityQueueLibrary{
    public static void main(String[] args){

        //creates pq as a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //Inserting into min_heap
        pq.add(10);
        pq.add(15);
        pq.add(6);
        //Viewing the top one;
        System.out.println(pq.peek());
        //Removing the top one;
        System.out.println(pq.poll());
        //pq.remove() also does the same 
        //To Create a max_heap
        PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        //Collections.reverseOrder() will help you build a max_heap!
        //we can add contents of any  java collection by mentioning in the constructor!
        
        //To check the pq is empty or not
        System.out.println(pq.isEmpty());
        //to know the length of pq
        System.out.println(pq.size());
    }
}
import java.util.*;

class Practice{
    public static void main(String[] args){

        Integer arr[] = {1,12,5,111,200};
        List<Integer> prices = Arrays.asList(arr);
        System.out.println(purchase_max(prices,10));
    }


    public static int purchase_max(List<Integer> prices, int money){
        //prices contains the price of item 0 at index 0 and so on.
        //money is the total you have.
        //problem is to buy as many as you can. and return count of items that you bought.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(prices);
        int count = 0;
        while (money >0 && !pq.isEmpty() && pq.peek() <= money){
            money -= pq.poll();
            count++;
        }
        return count ;

    }


    public  static int KUniqueString(String s, int k) {
        Map<Character,Integer> m = new HashMap<>();
        for(char c: s.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((x,y)-> m.get(x)-m.get(y));

        pq.addAll(m.keySet());
        int cost = 0;
        while (pq.size() > k){
            char c = pq.remove();
            cost+= m.get(c);
        }

        return cost;
    }


}

class RollingMedian {
    PriorityQueue<Integer> small,great;

    public RollingMedian() {
        this.small = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.great = new PriorityQueue<Integer>();
    }

    public void add(int val) {
        if(this.small.size()==0 && this.great.size()==0){
            this.small.add(val);
        }
        else if(this.small.size() > this.great.size()){
            if(this.small.peek() > val){
                this.great.add(this.small.poll());
                this.small.add(val);
            }else{
                this.great.add(val);
            }

        }else{
            if(this.small.peek() >= val){
                this.small.add(val);
            }else{
                this.great.add(val);
                this.small.add(this.great.remove());
            }

        }
    }

    public double median() {
        if(this.small.size() > this.great.size()){
            return this.small.peek();
        }else{
            
            return (double)(this.small.peek()+this.great.peek())/2;
        }
    }
}
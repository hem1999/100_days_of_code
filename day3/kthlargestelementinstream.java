class KthLargestInStream {
    int k;
    int[] nums;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>();
        this.k = k;
        for(int key:nums){
           if(this.pq.size() < this.k){
                this.pq.add(key);
            }else{
               if(this.pq.peek() < key){
                   this.pq.remove();
                   this.pq.add(key);
               }
           }
        }
        
        
    }
    
    public int add(int key) {
        if(this.pq.size() < this.k){
            this.pq.add(key);
        }
        else{
        if(this.pq.peek() < key){
            this.pq.remove();
            this.pq.add(key);
        }
        }
        return this.pq.peek();
        
    }
}

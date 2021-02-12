class ArrayQueue{
    public int size;
    private int[] arr;
    public int capacity;
    ArrayQueue(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }
    public boolean isFull(){
        return this.capacity == this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public int front(){
        return this.arr[0];
    }

    public int rear(){
        return this.arr[this.size-1];
    }


    public void enqueue(int val){
        if(this.size==this.capacity){
            System.out.println("Stack Overflow!");
            return ;
        }
        this.arr[this.size++] = val;
    }

    public int dequeue(){
        if(this.size==0){
            System.out.println("Stack underflow!");
            return Integer.MAX_VALUE;
        }
        int temp = this.arr[0];
        this.size--;
        for(int i=1;i<=this.size;i++){
            this.arr[i-1] = this.arr[i];
        }
        return temp;
    }

    public void printq(){
        for(int key: this.arr){
            System.out.print(key+" --> ");
        }
        System.out.println();
    }
}

class ArrayCircularQueue{
    int[] arr;
    int front,capacity,size;
    ArrayCircularQueue(int cap){
        this.capacity = cap;
        this.arr = new int[this.capacity];
        this.size =0;
        this.front = 0;
        // rear = (front+size-1)%capacity;
    }

    boolean isFull(){
        return this.capacity == this.size;
    }

    boolean isEmpty(){
        return this.size==0;
    }

    public int getFront(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        }

        return this.front;
    }

    public int getRear(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return (this.front+this.size-1)%this.capacity;
    }
    public void enqueue(int val){
        if(isFull()){
            return ;
        }

        int rear = getRear();
        rear = (rear+1)%this.capacity;
        this.arr[rear] = val;
        this.size++;
    }

    public void dequeue(){
        if(isEmpty()){
            return ;
        }

        this.front = (this.front+1)%this.capacity;
        this.size--;
        
    }
}

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
    }
} 

class ListyQueue{
    ListNode head;
    ListNode tail;
    int size;
    ListyQueue(){
        this.size =0;
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int val){
        if(this.tail==null){
            this.tail = new ListNode(val);
            this.head = this.tail;
            this.size++;
            return ;
        }
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
        this.size++;
    }

    public int dequeue(){
        if(this.head == null){
            return Integer.MAX_VALUE;
        }
        int temp = this.head.data;
        this.head = this.head.next;
        this.size--;
        return temp;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int front(){
        if(this.head == null){
            return Integer.MAX_VALUE;
        }
        return this.head.data;
    }

    public int rear(){
        if(this.tail == null){
            return Integer.MAX_VALUE;
        }

        return this.tail.data;
    }
}


class QueueFromScratch{
    public static void main(String[] args){
        // ListyQueue lq = new ListyQueue();
        // ArrayCircularQueue lq = new ArrayCircularQueue(10);
        ArrayQueue lq = new ArrayQueue(10);
        lq.enqueue(10);
        lq.enqueue(20);
        lq.enqueue(30);
        lq.printq();
        for(int i=0;i<4;i++){
            System.out.println(lq.dequeue()+"  --  "+ lq.isEmpty());
            lq.printq();
        }

    }
}
class ArrayCircularDequeue{
    int front;
    int[] arr;
    int size;
    int capacity;
    ArrayCircularDequeue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public boolean isFull(){
        return this.capacity == this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public int getFront(){
        if(isEmpty()) return -1;
        return this.arr[this.front];
    }

    public int getRear(){
        if(isEmpty()) return -1;
        return this.arr[(this.front+this.size-1)%this.capacity];
    }

    public void EnqueueRear(int val){
        if(isFull()) return ;
        int rear = (this.front+this.size-1)%this.capacity;
        this.arr[(rear+1)%this.capacity] = val;
        this.size++;
    }

    public void EnqueueFront(int val){
        if(isFull()) return ;
        this.front = (this.front-1+this.capacity)%this.capacity;
        this.arr[this.front] = val;
        this.size++;
    }

    public int DequeueFront(){
        if(isEmpty()) return Integer.MAX_VALUE;
        int temp = this.arr[this.front];
        this.front = (this.front+1)%this.capacity;
        this.size--;
        return temp;
    }

    public int DequeueRear(){
        if(isEmpty()) return Integer.MAX_VALUE;
        int rear = (this.front+this.size-1)%this.capacity;
        int temp = this.arr[rear];
        rear = (rear-1+this.capacity)%this.capacity;
        this.size--;
        return temp;
    }

    public void printq(){
        for(int key: this.arr){
            System.out.print(key+" --> ");
        }
        System.out.println();
    }

}

class ListNode{
    int data;
    ListNode next,prev;
    ListNode(int val){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class ListyDequeue{
    ListNode front;
    ListNode rear;
    ListyDequeue(){
        this.front = null;
        this.rear = null;
    }


    public void EnqueueFront(int val){
        if(this.front==null){
            this.front = new ListNode(val);
            if(this.rear==null){
                this.rear = this.front;
            }

            return ;
        }

        ListNode temp = new ListNode(val);
        temp.next = this.front;
        this.front.prev = temp;
        this.front = temp;

    }
    
    public void EnqueueRear(int val){
        if(this.rear == null){
            this.rear = new ListNode(val);
            if(this.front == null){
                this.front = this.rear;
            }
        }

        ListNode temp = new ListNode(val);
        this.rear.next = temp;
        temp.prev = this.rear;
        this.rear = temp;
    }

    public int DequeueFront(){ 
        if(this.front==null){
            return Integer.MAX_VALUE;
        }
        int temp = this.front.data;
        this.front = this.front.next;
        if(this.front==null){
            this.rear = null;
        }else{
            this.front.prev = null;
        }

        return temp;

    }
    public int DequeueRear(){
        if(this.rear==null){
            return Integer.MAX_VALUE;
        }
        int temp = this.rear.data;
        this.rear = this.rear.prev;
        if(this.rear == null){
            this.front = null;
        }else{
            this.rear.next = null;
        }
        return temp;
    }
}

class DequeueFromScratch{
    public static void main(String[] args){
        ArrayCircularDequeue acd = new ArrayCircularDequeue(10);
        acd.EnqueueFront(5);
        acd.printq();
        acd.EnqueueFront(4);
        acd.printq();
        acd.EnqueueRear(6);
        acd.printq();
        acd.EnqueueRear(7);
        acd.printq();
        acd.DequeueFront();
        acd.printq();
        acd.DequeueFront();
        acd.printq();

    }
}
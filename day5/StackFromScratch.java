class ArrayStack{
    private int[] mystack;
    public int size,capacity;

    public ArrayStack(int capacity){
        this.mystack = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void push(int val){
        if(this.size==this.capacity){
            System.out.println("Stack Overflow");
            return ;
        }
        this.mystack[this.size++] = val;
        
    }

    public int pop(){
        if(this.size==0){
            System.out.println("Stack Underflow!");
            return -1;
        }
        int temp = this.mystack[this.size-1];
        this.mystack[this.size-1] = -1;
        this.size--;
        return temp;
    }
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return this.size==0;
    }

    public int peek(){
        if (this.size==0){
            System.out.println("No element in stack!");
            return -1;
        }
        return this.mystack[this.size];
    }
}

class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
    public ListNode(int data,ListNode next){
        this.data = data;
        this.next = next;
    }
}

class ListyStack{
    public int size;
    private ListNode top;
    public ListyStack(){
        this.size = 0;
        this.top = null;
    }

    public void push(int val){
        if(this.top == null){
            this.top = new ListNode(val);
            this.size++;
            return ;
        }
        ListNode temp = new ListNode(val);
        temp.next = this.top;
        this.top = temp;
        this.size++;
    }

    public int pop(){
        if(this.top==null){
            System.out.println("Stack underflow!");
            return Integer.MAX_VALUE;
        }
        ListNode temp = this.top;
        this.top = this.top.next;
        this.size--;
        return temp.data;
    }

    public boolean isEmpty(){
        return this.top == null;
    }

}
class StackFromScratch{
    public static void main(String[] args){
        // ArrayStack as = new ArrayStack(5);
        // as.push(1);
        // as.push(2);
        // as.push(3);
        // as.push(4);
        // as.push(5);
        // as.push(6);
        // System.out.println(as.isEmpty());
        // for(int i=0;i<=5;i++){
        //     System.out.println(as.pop());
        // }
        ListyStack las = new ListyStack();
        las.push(1);
        las.push(2);
        las.push(3);
        las.push(4);
        las.push(5);
        las.push(6);
        System.out.println(las.isEmpty());
        for(int i=0;i<=10;i++){
            System.out.println(las.pop());
        }
    }
}
class MinHeap {
    int[] harr;
    int capacity,heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

   
    int extractMin() {
      
        if(heap_size==0){
            return -1;
        }
        if(heap_size==1){
            int val = harr[0];
            heap_size=0;
            return val;
        }
        int val = harr[0];
        int temp = harr[0];
        harr[0] = harr[heap_size-1];
        harr[heap_size-1] = temp;
        heap_size-=1;
        MinHeapify(0);
        return val;
    }

    void insertKey(int k) {
      
        if(heap_size==capacity){
            return ;
        }
        heap_size++;
        harr[heap_size-1]=k;
        int i = heap_size-1;
        while (i!=0 && harr[parent(i)]>harr[i]){
            int temp = harr[parent(i)];
            harr[parent(i)] = harr[i];
            harr[i] = temp;
            i = parent(i);
        }
    }

    void deleteKey(int i) {
        
        if(heap_size<0 || i>=heap_size){
            return ;
        }
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin();
    }

    // Decrease key operation, helps in deleting the element
    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }


    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}

class ScratchHeap{
    public static void main(String[] args){
        MyHeap h = new MyHeap(10);
        // System.out.println(h.left_child_index(5));
        // System.out.println(h.parent_index(h.right_child_index(5)));
        // h.insert(10);
        // h.insert(20);
        // h.insert(30);
        // h.print_arr();
        // h.insert(5);
        // h.print_arr();
        h.arr = new int[] {40,20,30,35,25,80,32,100,70,60};
        h.print_arr();
        h.minHeapify(0);
        h.print_arr();

    }
}
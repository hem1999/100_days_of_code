def min_heapify(i,heap_size,heap):
    lch = 2*i+1
    rch = 2*i+2
    smallest = i
    if lch < heap_size and heap[lch] < heap[smallest]:
        smallest = lch

    if rch < heap_size and heap[rch] < heap[smallest]:
        smallest = rch
    
    if smallest != i:
        heap[smallest],heap[i] = heap[i],heap[smallest]
        min_heapify(smallest,heap_size,heap)

def max_heapify(i,heap_size,heap):
    lch = 2*i+1
    rch = 2*i+2
    largest = i
    if lch<heap_size and heap[lch] > heap[largest]:
        largest = lch
    if rch < heap_size and heap[rch] > heap[largest]:
        largest = rch
    
    if largest!=i:
        heap[largest],heap[i] = heap[i],heap[largest]
        max_heapify(largest,heap_size,heap)
    
def heapSort(arr,asc=True):
    #For given array first build heap
    n = len(arr)
    for i in range((n-1)//2,-1,-1):
        if asc:
            min_heapify(i,n,arr)
        else:
            max_heapify(i,n,arr)

    for i in range(n-1,-1,-1):
        arr[0],arr[i] = arr[i],arr[0]
        if asc:
           min_heapify(0,i,arr)
           #here the arguments 
           #index at which heapify starts is 0
           #the heap size is i
           #arr is the heap.
        else:
            max_heapify(0,i,arr)
    return arr


def main():
    myarr = [4,1,3,9,7]
    myarr = heapSort(myarr)
    for i in myarr:
        print(i,end=" ")
    print()
    myarr = [4,1,3,9,7]
    myarr = heapSort(myarr,False)
    for i in myarr:
        print(i,end=" ")
    print()
main()

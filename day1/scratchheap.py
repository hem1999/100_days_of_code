import math
class Heap:

    def __init__(self):
        self.arr = list()
        self.size = len(self.arr)
    
    def lchild(self,i):
        return 2*i+1
    
    def rchild(self,i):
        return 2*i+2
    
    def parent(self,i):
        return (i-1)//2;
    
    def insert(self,val):
        self.arr.append(val)
        self.size+=1
        i = self.size-1
        while i!=0 and self.arr[self.parent(i)] > self.arr[i]:
            self.arr[self.parent(i)],self.arr[i] = self.arr[i],self.arr[self.parent(i)]
            i = self.parent(i)
        
    def heapify(self,i):
        lch = self.lchild(i)
        rch = self.rchild(i)
        smallest = i
        if(lch < self.size and self.arr[lch] < self.arr[smallest]):
            smallest = lch
        if rch < self.size and self.arr[rch] < self.arr[smallest] :
            smallest = rch 
        if smallest != i:
            self.arr[i],self.arr[smallest] = self.arr[smallest],self.arr[i]
            self.heapify(smallest)

    def extract_min(self):
        """
            deletes min from heap and returns it
        """
        if(self.size==0):
            return math.inf
        if(self.size==1):
            self.size=0
            val = self.arr.pop()
            return val
        # print(self.arr[0],self.arr[self.size-1])
        self.arr[0],self.arr[self.size-1] = self.arr[self.size-1],self.arr[0]
        # print("INside extract_min")
        # self.print_arr()
        val = self.arr.pop()
        self.size-=1
        self.heapify(0);
        return val
    
    def decrease_key(self,i,x):
        self.arr[i] = x
        while i!=0 and self.arr[self.parent(i)] > self.arr[i]:
            self.arr[self.parent(i)],self.arr[i] = self.arr[i],self.arr[self.parent(i)]
            i = self.parent(i)
        
    def delete(self,i):
        self.decrease_key(i,-math.inf)
        self.extract_min()

    def build_head(self,arr):
        self.arr = arr[:]
        self.size = len(arr)
        # for i in range(self.size-2//2 , -1, -1): 
        i = (self.size-2)//2
        while i>=0:
            self.heapify(i)
            i-=1

    def print_arr(self):
        for i in self.arr:
            print(i,end=" --> ")
        print()

def main():
    h = Heap()
    h.arr = [40,20,30,35,25,80,32,100,70,60]
    h.size = len(h.arr)
    h.print_arr()
    h.heapify(0)
    h.print_arr()
    h.insert(10)
    h.print_arr()
    print("The min is", h.extract_min())
    h.print_arr()
    h.decrease_key(7,10)
    h.print_arr()
    h.delete(6)
    h.delete(7)
    h.print_arr()
    k = Heap()
    k.build_head([9,8,7,6,5,4,3,2,1])
    k.print_arr()
main()


public class SequentialHeap {
    private static int DEFAULT_CAPACITY = 101;
    private int numberOfEntries;
    int[] heap;
    int totalSwaps;


    public SequentialHeap(){
        this(DEFAULT_CAPACITY);
    }

    public SequentialHeap(int capacity){
        @SuppressWarnings("unchecked")
        int[] temp = new int[capacity];
        heap = temp;
        totalSwaps = 0;
        numberOfEntries = 0;




    }

    public int getSwaps(){
        return totalSwaps;
    }

    public void setSwaps(int n){
        totalSwaps = n;
    }

   
    public void addEntry(int number){
    
    int child = numberOfEntries+1;
    int parent = (child) /2;
    heap[numberOfEntries+1] = number;
    while (child>1){
        if (heap[child]>heap[parent]){
            int temp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = temp;
            totalSwaps++;
            child = parent;
            parent = parent/2;
        }
        else {
            break;
        }
        
    }
    numberOfEntries++;


        

        
    }

    public int removeRoot(){
        if (numberOfEntries==0){
            System.out.println("empty heap");
            return -1;
        }
        int lastNode = numberOfEntries;
        int parent = 1;
        int leftChild = parent*2;
        int rightChild = parent*2 + 1;
        int retrieve = heap[parent];
        heap[parent] = heap[lastNode];
        heap[lastNode] = 0;
        numberOfEntries--;
        
       
        while (parent*2<=numberOfEntries){
            if (rightChild<=numberOfEntries && heap[parent]<heap[leftChild] && heap[parent]<heap[rightChild] ){
                int temp = heap[parent];
                if (heap[rightChild] > heap[leftChild] ){
                   
                   heap[parent] = heap[rightChild];
                   heap[rightChild] = temp;
                   totalSwaps++;
                   parent = parent*2 +1;
                   // edit happens either case
                
                }
                
                else {
                    heap[parent] = heap[leftChild];
                    heap[leftChild] = temp;
                    totalSwaps++;
                    parent = parent*2;
                    
                }
                leftChild = parent*2;
                rightChild = parent*2+1;
                continue;

            }

            if(heap[leftChild]>heap[parent]){
                int temp = heap[parent];
                heap[parent] = heap[leftChild];
                heap[leftChild] = temp;
                totalSwaps++;
                parent = parent*2;
                leftChild = parent*2;
                rightChild = parent*2+1;
                continue;
            }

            if (rightChild<=numberOfEntries && heap[rightChild]>heap[parent] ){
                int temp = heap[parent];
                heap[parent] = heap[rightChild];
                heap[rightChild] = temp;
                totalSwaps++;
                parent = parent*2 +1;
                leftChild = parent*2;
                rightChild = parent*2 + 1;
                continue;

            }
           break;
        }
        return retrieve;


    }





 public int[] returnArray(){
    return heap;
 }

 public void clear(){
    int[] tempHeap = new int[heap.length];
    heap = tempHeap;
    numberOfEntries=0;

 }

 

 

    


}
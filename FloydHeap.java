public class FloydHeap {
    private static int DEFAULT_CAPACITY = 101;
    private int numberOfEntries;
    int[] heap;
    int totalSwaps;


    public FloydHeap(){
        this(DEFAULT_CAPACITY);
    }

    public FloydHeap(int capacity){
        @SuppressWarnings("unchecked")
        int[] temp = new int[capacity];
        heap = temp;
        totalSwaps = 0;
        numberOfEntries = 0;




    }

    public int getSwaps(){
        return totalSwaps;
    }

    public void setNumberOfEntries(int number){
        numberOfEntries = number;
    }

    public int getNumberOfEntries(){
        return numberOfEntries;
    }


     public int[] returnArray(){
        return heap;
 }






    public void organizeHeap(int parent){
        

      while (parent*2<=numberOfEntries){

        int largerChild = parent *2;

        if ((parent*2+1 <= numberOfEntries) && (heap[parent*2+1]>heap[parent*2])){
            largerChild = largerChild +1;
        }

        if (heap[parent]<heap[largerChild]){
            int temp = heap[parent];
            heap[parent] = heap[largerChild];
            heap[largerChild] = temp;
            totalSwaps++;
            parent = largerChild;
            
            
        }
        
        else {break;

        }


      }

    }

    public void reheap(int [] array){
        heap = array;
        numberOfEntries = heap.length-1;
        totalSwaps = 0;

        for (int i = numberOfEntries/2; i>=1; i--){
            organizeHeap(i);
        }



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













}

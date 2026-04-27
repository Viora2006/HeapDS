public class runCode {

    public static void main(String[] args){
    FloydHeap newHeap = new FloydHeap();
   int[] test = {0, 47, 12, 89, 34, 61, 5, 73, 28, 95, 16};
   newHeap.setNumberOfEntries(test.length-1);
   newHeap.reheap(test);
   int[] trialArray = newHeap.returnArray();

   for (int i = 1; i<newHeap.getNumberOfEntries()+1;i++){
    System.out.println(trialArray[i]);
   }
  System.out.println();
   System.out.println(newHeap.totalSwaps);






    
        
      
 
    }
    
    
}

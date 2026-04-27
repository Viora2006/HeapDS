import java.util.*; // found this utility through AI usage



public class Project3 {

    public static void main(String[] args){
    boolean endProgram = false;
    Scanner scanner = new Scanner(System.in);
    while(!endProgram){
    
    System.out.println("Choices shown Below to test Program");
    System.out.println("(1) 20 sets of 100 randomly generated numbers");
    System.out.println("(2) Fixed integer values 1 - 100");
    System.out.println("(3) Exit");
    String choice = scanner.nextLine();
    

    if (choice.equals("1")){

        SequentialHeap seqHeap = new SequentialHeap();
        FloydHeap FHeap = new FloydHeap();
        ArrayList<Integer> nums = new ArrayList<>();
        int[] arrayParameter = new int[FHeap.getCapacity()];
        
        
        for (int j = 1; j<=1000; j++){
            nums.add(j);

        }

        for (int i = 0; i<20; i++){
            
            Collections.shuffle(nums);

            for (int k =1; k<101; k++){
                seqHeap.addEntry(nums.get(k));
                arrayParameter[k] = nums.get(k);

            }

            FHeap.reheap(arrayParameter);
            FHeap.clear();
            seqHeap.clear();
        }

        System.out.print("Average swaps for series of insertions: ");
        System.out.println(seqHeap.getSwaps()/20.0);
        System.out.print("Average swaps for optimal Floyd method: ");
        System.out.println(FHeap.getSwaps()/20.0);
        System.out.println();

        FHeap.setSwaps(0);
        seqHeap.setSwaps(0);
        





    }

    else if(choice.equals("2")){

        SequentialHeap seqHeap = new SequentialHeap();
        FloydHeap FHeap = new FloydHeap();
        int[] arrayParameter = new int[FHeap.getCapacity()];

        for (int i =1; i<FHeap.getCapacity();i++){
            arrayParameter[i] = i;
            seqHeap.addEntry(i);

        }
        FHeap.reheap(arrayParameter);
        
        System.out.print("Heap Built using series of insertions: ");
        for (int i = 1; i<11;i++){
            System.out.print(seqHeap.returnArray()[i] + " ");
        }
        System.out.println();
        System.out.println("Number of swaps: " +seqHeap.getSwaps() );
        System.out.print("Heap after 10 removals: ");
        for(int i =1; i <11;i++){
            seqHeap.removeRoot();
        }
        for(int i = 1;i <11;i++){
            System.out.print(seqHeap.returnArray()[i] + " ");
        }
        System.out.println();
        System.out.println();





        System.out.print("Heap Built using optimal Floyd method: ");
        for (int i = 1; i<11;i++){
            System.out.print(FHeap.returnArray()[i]+ " ");
        }
        System.out.println();

        System.out.println("Number of swaps: " +FHeap.getSwaps());
        
        
        System.out.print("Heap after 10 removals: ");
        for(int i =1; i <11;i++){
            FHeap.removeRoot();
        }
        for(int i = 1;i <11;i++){
            System.out.print(FHeap.returnArray()[i] + " ");
        }

    System.out.println(); 
    System.out.println();



    }

    else if(choice.equals("3")){
        System.out.println("Goodbye!");
        endProgram = true;
    }


    else{
        System.out.println("Invalid input, try again");

    }



    
        
      
 
    }
}
    
    
}
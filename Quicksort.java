import java.util.*;

public class Quicksort {
	
	private static int[] theArray;
	public static int arraySize;
	private int pivot_index;
	
	public int[] quicksort(int[] a, String pivot){
		int p = 0;
		arraySize = a.length;
		System.out.println(arraySize);
		

		if (!(pivot.equals("first") | pivot.equals("random") | 
				pivot.equals("median3") | pivot.equals("dqselect"))){
			System.out.println("Invalid pivot selection.");
		} else {
			pivot(pivot);
			int r = pivot_index;
			System.out.println("\n"+ pivot_index+"\n");
			System.out.println("Pivot receives value: " + r);
			qSort(a, p, r);
		}
		
	
		
		
		
		
		//System.out.println("\n a.length: " + a.length);
		
		theArray = new int[a.length];
		//System.out.println("\n a.length: " + a.length);
		for(int i = 0; i < a.length; i++){
			theArray[i] = a[i];
		}
		
		return theArray;
		
	}
	
	int pivot(String string){
		int pivot;
		switch(string){
			case "first": pivot = first();
			case "random": pivot = random();
			case "median3": pivot = median3();
			case "dqselect": pivot = dqselect();
			default: System.out.println("Invalid selection"); 
		}
	}
	
	int first(){
		int pivot = 0;
		return pivot;
		
	}
	int random(){
		int pivot;
		pivot = (int) Math.random() * arraySize;
		return pivot;
		//System.out.println();
		//System.out.println("Pivot[" + rand + "] = " + a[rand]);
		//pivot_index = rand;
		//return rand;
	}
	void median3(){
		//int pivot;
		int[] rand = new int[3];
		rand[0] = (int) (Math.random() * arraySize);
		System.out.println("hi :" +rand[0]);
		rand[1] = (int) (Math.random() * arraySize);
		rand[2] = (int) (Math.random() * arraySize);
	//	System.out.println("Median3 pivot:");
	//	System.out.print("Position[" + rand[0] + "] = " + a[rand[0]]);
	//	System.out.print("  && Position[" + rand[1] + "] = " + a[rand[1]]);
	//	System.out.print("  && Position[" + rand[2] + "] = " + a[rand[2]]);
	//	System.out.println();

		//Below if/else statement is efficient because requires 
		//at least three and at most four comparisons
		
		// 2, 0, x or 2, 1, x or 1, 0, x 
		if (rand[0] > rand[1]) {
			// 2, 1, 0 or 2, 1, 1  or 1, 0, 0
			if (rand[1] >= rand[2]) {
				pivot_index = rand[1];
			    //return a[rand[1]]; 
			}
			// 2, 0, 1
			else if (rand[0] > rand[2]) {
				pivot_index = rand[2];
				//return a[rand[2]];
			} 
			// 2, 2, x 
			else {
				pivot_index = rand[0];
				//return a[rand[0]];
			}
		} 
		// 0, x, x or 1, 1, x or 1, 2, x
		else {
			// 0, 1, 0 or 0, 1, 0 or 1, 2, 0 or 1, 1, 0, or 1, 1, 1
			if (rand[0] >= rand[2]) {
				pivot_index = rand[0];
				//return a[rand[0]];
			} 
			// 0, 2, 1
			else if (rand[1] > rand[2]) {
				pivot_index = rand[2];
				//return a[rand[2]];
			} 
			// 0, 1, 2 or 0, 0 , 2
			else {
				pivot_index = rand[1];
				//return a[rand[1]];
			}
		}
		//return pivot_index;
		
		
		
		
	}
	void dqselect(){
		pivot_index = 0;
	}
	
	
	
	
	public void qSort(int[] a, int p, int r)
    {
        if(p<r)
        {
            int q = Partition(a, p,r);
            qSort(a, p, q-1);
            qSort(a, q+1, r);
        }
     }

     private int Partition(int[] a, int p, int r)
     {
    	 System.out.println("In Partition, int r = " + r);
         int x = a[r];

         int i = p-1;
         int temp=0;

         for(int j=p; j<r-1; j++)
         {
             if(a[j]<=x)
             {
                 i++;
                 temp = a[i];
                 a[i] = a[j];
                 a[j] = temp;
             }
         }

         temp = a[i+1];
         a[i+1] = a[r];
         a[r] = temp;
         return (i+1);
     }

}
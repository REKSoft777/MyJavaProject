
public class Counter implements Comparable<Counter>

{

   private final String name;
   private final int maxCount;
   private int count;

   public Counter(String id, int max) {  
	   name = id; maxCount = max; 
	   if (max<=0) {
           throw new IllegalArgumentException("Negative or null value");
         }
   }

   public int compareTo(Counter that) {
		if(count<that.count) return -1;
		else if(count==that.count) return 0;
		else return 1;
	}

   public void increment() { 
   
	   if (count < maxCount) count++;  
   }


   public int value() {  
	  
	   return count;  
   }


   public String toString() {
	   
	   return name + ": " + count;  
   }


   public static void main(String[] args) {

     
	 int n = Integer.parseInt(args[0]);
     int trials = Integer.parseInt(args[1]);
     Counter[] hits = new Counter[n];
     for (int i = 0; i < n; i++) {
        hits[i] = new Counter(i + "", trials);
     }
     for (int t = 0; t < trials; t++) {
        hits[StdRandom.uniform(n)].increment();
     }
     for (int i = 0; i <n; i++) {
    	 System.out.println(hits[i]);
     }
     Merge.iterativeSort(hits);
     for (int i = 0; i <n; i++) {
    	 System.out.println(hits[i]);
     }
   }




}
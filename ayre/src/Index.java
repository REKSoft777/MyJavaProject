import java.util.TreeMap;

public class Index {
    

	public static void main(String[] args) {
        int minLength     = Integer.parseInt(args[0]);    
        int minOccurrence = Integer.parseInt(args[1]);   

       
        String[] words = {"Johnny","Ralph","Karl","Thea","Cassandra","Manon","Georges","Ralph","Messi",
        		"MacGregor","Khabib","Coby","Jorge","Adesanya","MacGregor","Ralph","Johnny","Messi"};
        
        
       
        BinarySearchST<String, Queue<Integer>> st = new BinarySearchST<String, Queue<Integer>>();
        for (int i = 0; i < words.length; i++) {
            	String s=words[i];
                if (s.length() < minLength) continue;
                if (!st.contains(s)) {
                     st.put(s, new Queue<Integer>());
                }
                Queue<Integer> q = st.get(s);
                q.enqueue(i);
              }
            
        for (String s : st.keySet()) { 
            Queue<Integer> q = st.get(s);
            if (q.size() >= minOccurrence) {
            	System.out.print(s+ ": ");
            	while(!q.isEmpty()) {
            		StdOut.print(q.dequeue()+" ");
            	}
                System.out.println();
            } 
        }
            
    } 
} 




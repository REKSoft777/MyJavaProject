

public class PathFinder {

    private BST<String, String>  prev = new BST<String, String>();
    private BST<String, Integer> dist = new BST<String, Integer>();

    public PathFinder(Graph G, String s) {

        Queue<String> queue = new Queue<String>();
        queue.enqueue(s);
        dist.put(s, 0);
        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (String w : G.adjacentTo(v)) {
                if (!dist.contains(w)) {
                    queue.enqueue(w);
                    dist.put(w, 1 + dist.get(v));
                    prev.put(w, v);
                }
            }
        }
    }

    // is v reachable from the source s?
    public boolean hasPathTo(String v) {
        return dist.contains(v);
    }

    // return the length of the shortest path from v to s
    public int distanceTo(String v) {
        if (!hasPathTo(v)) return Integer.MAX_VALUE;
        return dist.get(v);
    }

    public Iterable<String> pathTo(String v) {
        Stack<String> path = new Stack<String>();
        while (v != null && dist.contains(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }
    
    
    public static void CCFinder(Graph G) {
    	BSSET<String> visited=new BSSET<String>();
    	for(String s: G.vertices()) {
    		if(!visited.contains(s)) CCFinder(G,visited,s);
    	}
    }
    
    public static void CCFinder(Graph G,BSSET<String> visited,String s) {

    	BSSET<String> st=new BSSET<String>();
        Queue<String> queue=new Queue<String>();
        st.add(s);
        visited.add(s);
        queue.enqueue(s);
        while(!queue.isEmpty()) {
        	String v=queue.dequeue();
        	for(String w:G.adjacentTo(v)) {
        		if(!st.contains(w)) {
        			st.add(w);
        			visited.add(w);
            		queue.enqueue(w);
        		}
        	}
        }
        for(String x: st.levelOrder()) {
        	System.out.print(x+" ");
        }
        System.out.println();
    }
    
    public double hollywoodNumber() {
    	double sum=0;
    	for(String x: dist.levelOrder()) {
    		int a=dist.get(x);
    		if(a%2==0) {
    			sum+=a/2;
    		}
    	}
    	return sum/(dist.size()/2);
    }


    public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        Graph G=new Graph(filename,delimiter);
        System.out.println(G.hasEdge("Damon, Craig", "(Yielding to) A Willing Breath (2006)"));
        System.out.println(SmallWorld.averagePathLength(G));
    }


}

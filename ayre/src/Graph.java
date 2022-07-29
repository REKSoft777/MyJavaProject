import java.util.Scanner;

public class Graph {

	private BST<String, BSSET<String>> st;
	private int E;
	
	public Graph() {
		st=new BST<String, BSSET<String>>();
	}
	
	public Graph(String filename, String delimiter) {
        st = new BST<String,BSSET<String>>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                addEdge(names[0], names[i]);
            }
        }
    }
	
	public void addEdge(String v, String w) {
		if(v.equals(w)) return;
		if(!st.contains(v)) {
			st.put(v, new BSSET<String>());
		}
		if(!st.contains(w)) {
			st.put(w, new BSSET<String>());
		}
		if(!st.get(v).contains(w)) {
		   st.get(v).add(w);
		   st.get(w).add(v);
		   E++;
		}
	}
	
	public int E() {
		return E;
	}
	
	public int V() {
		return st.size();
	}
	
	public int degree(String v) {
		if(hasVertex(v)) return st.get(v).size();
		else return 0;
	}
	
	public void addVertex(String v) {
		st.put(v, new BSSET<String>());
	}
	
	public boolean hasVertex(String v) {
		return st.contains(v);
	}
	
	public boolean hasEdge(String v, String w) {
		if(!hasVertex(v)) return false;
		if(!st.get(v).contains(w)) return false;
		return true;
	}
	
	public Graph copy() {
		Graph g=new Graph();
		for(String v: vertices()) {
			for(String w: adjacentTo(v)) {
				g.addEdge(v, w);
			}
		}
		return g;
	}
	
	public void remove(String v,String w) {
		if(!hasVertex(v)) return;
		st.get(v).remove(w);
		st.get(w).remove(v);
		E--;
	}
	
	public void removeVertice(String v) {
		if(!hasVertex(v)) return;
		for(String x: adjacentTo(v)) {
			st.get(x).remove(v);
		}
		st.remove(v);
	}
	
	
	public Iterable<String> adjacentTo(String v) {
		return st.get(v).levelOrder();
	}
	
	public Iterable<String> vertices() {
		return st.levelOrder();
	}
	
	public Graph subGraph(String v) {
		BSSET<String> set=st.get(v);
		if(set==null) return null;
		Graph g=new Graph();
		for(String x: adjacentTo(v)) {
			for(String y: adjacentTo(x)) {
				if (!g.hasEdge(x,y)) g.addEdge(x,y);
			}
		}
		return g;
	}
	
	public void printEdges() {
		
	    BSSET<String> set=new BSSET<String>();	
		for(String v: vertices()) {
			set.add(v);
			for (String w: adjacentTo(v)) {
				if(!set.contains(v)) System.out.println(v+" "+w);
			}
		}
	}
	
	public double averagePathLength() {
        int sum = 0;
        for (String v : vertices()) {
            PathFinder pf = new PathFinder(this, v);
            for (String w : vertices())
                sum += pf.distanceTo(w);
        }
        return (double) sum / (V() * (V() - 1));
    }
 
public void addRandomEdge() {
	if(V()<2) throw new IllegalArgumentException();
	String v=st.getRandom();
	String w=st.getRandom();
	addEdge(v,w);
}

    public String getRandom() {
    	return st.getRandom();
    }

    public void addRandomEdge(int n) {
	   if(n<=0) throw new IllegalArgumentException("can't add less than 1 random Edge");
	   for (int i=0; i<n; i++) {
		   addRandomEdge();
	   }
}


    public static Graph generateGridGraph(int n) {
    	Graph G=new Graph();
    	for (int i=0; i<n; i++) {
    		   for (int j=0; j<n; j++) {
    			   if(i==n-1 && j==n-1);
    			   else if(i==n-1) G.addEdge("a"+i+j, "a"+i+(j+1));
    			   else if(j==n-1) G.addEdge("a"+i+j, "a"+(i+1)+j);
    			   else {
    				   G.addEdge("a"+i+j, "a"+i+(j+1));
    				   G.addEdge("a"+i+j, "a"+(i+1)+j);
    			   }
    		   }
    	}
    	return G;
    }
    
    public static Graph ringGraph(int k) {
    	Graph G=new Graph();
    	if(k<=0) throw new IllegalArgumentException();
    	for(int i=1;i<=1000;i++) {
    		for(int j=1;j<=k;j++) {
               G.addEdge(i+"", ((i+j)%1000)+"");
    		}
    	}
    	return G;
    }
    
    public static Graph generateRandomGraph(double p) {
    	Graph G=new Graph();
    	for(int i=0;i<500;i++) {
    		G.addVertex(i+"");
    	}
    	for(int i=0;i<500;i++) {
    		for(int j=0;j<500;j++) {
    			double r=Math.random();
    			if(r<p) G.addEdge(i+"", j+"");
    		}
    	}
    	return G;
    }


    public static void main(String[] args) {
		Graph G=generateRandomGraph(0.5);
		//System.out.println(SmallWorld.clusteringCoefficient(G));
		double sum=0;
		for(int t=0;t<=500;t++) {
			String v=G.getRandom();
			int possible = G.degree(v) * (G.degree(v) - 1);
            int actual = 0;
            for (String u : G.adjacentTo(v)) {
                for (String w : G.adjacentTo(v)) {
                    if (G.hasEdge(u, w))
                        actual++;
                }
            }
            if (possible > 0) {
                total += 1.0 * actual / possible;
            }
        }
		}
	}
}

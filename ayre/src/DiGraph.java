
public class DiGraph {

    private BST<String, BSSET<String>> st;

    public DiGraph() {
        st = new BST<String, BSSET<String>>();
    }

    public void addEdge(String v, String w) {
        if (!st.contains(v)) addVertex(v);
        if (!st.contains(w)) addVertex(w);
        st.get(v).add(w);
    }

    public void addVertex(String v) {
        if (!st.contains(v)) st.put(v, new BSSET<String>());
    }

    public int degree(String v) {
        if (!st.contains(v)) return 0;
        else                 return st.get(v).size();
    }

    public Iterable<String> adjacentTo(String v) {
        if (!st.contains(v)) return new BSSET<String>().levelOrder();
        else                 return st.get(v).levelOrder();
    }
    
    public Iterable<String> vertices() {
    	return st.levelOrder();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String v : st.levelOrder()) {
            s.append(v + ": ");
            for (String w : st.get(v).levelOrder()) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    public boolean isReachable(String v, String w) {
    	BSSET<String> st= new BSSET<String>();
    	boolean isReachable=false;
    	isReachable(v, w, st,isReachable);
    	return isReachable;
    }
    
    private void isReachable(String v, String w,BSSET<String> st,boolean isReachable) {
    	st.add(v);
    	if(v.equals(w)) {
    		isReachable=true;
    		return;
    	}
    	
    }

    public static void main(String[] args) {
        DiGraph G = new DiGraph();
        G.addEdge("A", "B");
        G.addEdge("A", "C");
        G.addEdge("C", "D");
        G.addEdge("D", "E");
        G.addEdge("D", "G");
        G.addEdge("E", "G");
        G.addVertex("H");
        StdOut.println(G.isReachable("A", "A"));
    }
}
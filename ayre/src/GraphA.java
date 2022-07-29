
public class GraphA {

	private BST<String, Queue<String>> st;
	private int E;
	
	public GraphA() {
		st=new BST<String, Queue<String>>();
	}
	
	public void addEdge(String v, String w) {
		if(!st.contains(v)) {
			st.put(v, new Queue<String>());
		}
		if(!st.contains(w)) {
			st.put(w, new Queue<String>());
		}
		   st.get(v).enqueue(w);;
		   st.get(w).enqueue(v);
		   E++;
		}
	
	public void addVertex(String v) {
		if(st.contains(v)) return;
		st.put(v, new Queue<String>());
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
	
	public boolean hasVertex(String v) {
		return st.contains(v);
	}
	
	public boolean hasEdge(String v, String w) {
		if(!hasVertex(v)) return false;
		if(!st.get(v).find(w)) return false;
		return true;
	}
	
	
	public Iterable<String> adjacentTo(String v) {
		return st.get(v);
	}
	
	public Iterable<String> vertices() {
		return st.keys();
	}
	
	
	
	
	public static void main(String[] args) {

		
	}

}

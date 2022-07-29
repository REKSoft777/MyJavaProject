
public class GGraph<Item extends Comparable<Item>> {

	private BST<Item, BSSET<Item>> st;
	private int E;
	
	public GGraph() {
		st=new BST<Item, BSSET<Item>>();
	}
	
	public void addEdge(Item v, Item w) {
		if(!st.contains(v)) {
			st.put(v, new BSSET<Item>());
		}
		if(!st.contains(w)) {
			st.put(w, new BSSET<Item>());
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
	
	public int degree(Item v) {
		if(hasVertex(v)) return st.get(v).size();
		else return 0;
	}
	
	
	
	public boolean hasVertex(Item v) {
		return st.contains(v);
	}
	
	public boolean hasEdge(Item v, Item w) {
		if(!hasVertex(v)) return false;
		if(!st.get(v).contains(w)) return false;
		return true;
	}
	
	
	public void remove(Item v,Item w) {
		if(!hasVertex(v)) return;
		st.get(v).remove(w);
		st.get(w).remove(v);
		E--;
	}
	
	
	public Iterable<Item> adjacentTo(Item v) {
		return st.get(v).keys();
	}
	
	public Iterable<Item> vertices() {
		return st.keys();
	}
	
	
	
	public static void main(String[] args) {

		
	}

}


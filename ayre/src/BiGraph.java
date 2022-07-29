
public class BiGraph<Item1 extends Comparable<Item1>, Item2 extends Comparable<Item2>> {
	
	private BST<Item1, BSSET<Item2>> st1;
	private BST<Item2, BSSET<Item1>> st2;
	private int E;
	
	public BiGraph() {
		st1=new BST<Item1, BSSET<Item2>>();
		st2=new BST<Item2, BSSET<Item1>>();
	}

	public void addEdge(Item1 v, Item2 w) {
		if(!st1.contains(v)) {
			st1.put(v, new BSSET<Item2>());
		}
		if(!st2.contains(w)) {
			st2.put(w, new BSSET<Item1>());
		}
		if(!st1.get(v).contains(w)) {
		   st1.get(v).add(w);
		   st2.get(w).add(v);
		   E++;
		}
	}
	
	public boolean hasVertexA(Item1 v) {
		return st1.contains(v);
	}
	
	public boolean hasVertexB(Item2 w) {
		return st2.contains(w);
	}
	
	public int E() {
		return E;
	}
	
	public int V() {
		return st1.size()+ st2.size();
	}
	
	
	public int degreeA(Item1 v) {
		if(hasVertexA(v)) return st1.get(v).size();
		else return 0;
	}
	
	public int degreeB(Item2 v) {
		if(hasVertexB(v)) return st2.get(v).size();
		else return 0;
	}
	
	public boolean hasEdge(Item1 v, Item2 w) {
		if(!hasVertexA(v)) return false;
		if(!st1.get(v).contains(w)) return false;
		return true;
	}
	
	public void remove(Item1 v,Item2 w) {
		if(!hasVertexA(v)) return;
		st1.get(v).remove(w);
		st2.get(w).remove(v);
		E--;
	}
	
	public Iterable<Item2> adjacentToA(Item1 v) {
		return st1.get(v).keys();
	}
	
	public Iterable<Item1> adjacentToB(Item2 v) {
		return st2.get(v).keys();
	}
	
	public Iterable<Item1> verticesA() {
		return st1.keys();
	}
	
	public Iterable<Item2> verticesB() {
		return st2.keys();
	}
	
	public static void main(String[] args) {
		

	}

}

import BST.Node;

public class BSSET<Key extends Comparable<Key>> {
	
	private Node root;
	private int n;
	
	private class Node {
		
		private Key key;
		private Node left,right;
		
		public Node(Key key) {
			this.key=key;
		}
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public int size() {
		return n;
	}
	
	public void add(Key key) {
		if (key==null) throw new IllegalArgumentException("Key is null");
		root=add(root,key);
	}
	
	private Node add(Node x, Key key) {
		if(x==null) {
			n++;
			return new Node(key);
		}
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=add(x.left,key);
		else if(cmp==0) {}
		else x.right=add(x.right,key);
		return x;
	}
	
	public boolean contains(Key key) {
		if(key==null) throw new IllegalArgumentException("Key is null");
		if(isEmpty()) return false;
		return contains(root,key);
	}
	
	private boolean contains(Node x, Key key) {
		
		if (x==null) return false;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return contains(x.left,key);
		else if(cmp==0) return true;
		else return contains(x.right,key);
	}
	
	public void remove(Key key) {
		if(key==null) throw new IllegalArgumentException("Key is null");
		if(isEmpty()) return;
		root=remove(root,key);
	}
	
	private Node remove(Node x, Key key) {
		if(x==null) return x;
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=remove(x.left,key);
		else if(cmp>0) x.right=remove(x.right,key);
		else {
			if (x.right == null) {
				n--;
				return x.left;
			}
            if (x.left  == null) {
            	n--;
            	return x.right;
            }
			Node t=x;
			x=min(t.right);
			x.left=t.left;
			x.right=deleteMin(t.right);
		}
		return x;
	}
	
	public Key min() {
		if(isEmpty()) throw new IllegalArgumentException("Set is empty");
		return min(root).key;
	}
	
	private Node min(Node x) {
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public Key max() {
		if(isEmpty()) throw new IllegalArgumentException("Set is empty");
		return max(root).key;
	}
	
	private Node max(Node x) {
		if(x.right==null) return x;
		return min(x.right);
	}
	
	public void deleteMin() {
		if(isEmpty()) throw new IllegalArgumentException("Set is empty");
		root=deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if(x.left==null) {
			n--;
			return x.right;
		}
		x.left=deleteMin(x.left);
		return x;
	}
	
	public Iterable<Key> keys() {
        return rangeSearch(min(), max());
    }
    
    public Iterable<Key> rangeSearch(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 
    
    private void keys(Node x, Queue<Key> queue,Key lo,Key hi) {
    	
    	if(x==null) return;
    	int cmplo=lo.compareTo(x.key);
    	int cmphi=hi.compareTo(x.key);
    	if(cmplo<0) keys(x.left,queue,lo,hi);
    	if(cmplo<=0 && 0<=cmphi) queue.enqueue(x.key);
    	if(0<cmphi) keys(x.right,queue,lo,hi);
    }
    
    public BSSET<Key> intersection(BSSET<Key> set)  {
    	BSSET<Key> st=new BSSET<Key>();
    	if(isEmpty() || set.isEmpty()) return null;
    	if(this.size()<=set.size()) intersection(root,set,st);
    	else intersection(set.root,this,st);
    	return st;
    }
    
    private void intersection(Node x,BSSET<Key> set,BSSET<Key> st) {
    	if(x==null) return;
    	Key key=x.key;
    	if (set.contains(key)) st.add(key);
    	intersection(x.left,set,st);
    	intersection(x.right,set,st);
    }
    
    public BSSET<Key> union(BSSET<Key> set)  {
    	BSSET<Key> st=new BSSET<Key>();
    	if(isEmpty() || set.isEmpty()) return null;
    	union(root,set,st);
    	union(set.root,this,st);
    	return st;
    }
    
    private void union(Node x,BSSET<Key> set,BSSET<Key> st) {
    	if(x==null) return;
    	Key key=x.key;
    	st.add(key);
    	union(x.left,set,st);
    	union(x.right,set,st);
    } 
    
    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }
	
	public static void main(String[] args) {

		BSSET<String> st=new BSSET<String>();
		BSSET<String> st2=new BSSET<String>();
		st.add("Ralph");
		st.add("Johnny");
		st.add("Elie");
		st.add("Joe");
		st.add("Cedric");
		st.add("Ralph");
		st.remove("Cedric");
		st.add("Farid");
		st.add("Karl");
		st2.add("Emile");
		st2.add("Tanios");
		st2.add("Samuel");
		st2.add("Elie");
		System.out.println(st.size());
		BSSET<String> set=st.union(st2);
		System.out.println(set.size());
	}
}

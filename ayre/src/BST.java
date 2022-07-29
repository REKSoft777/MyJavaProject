import java.util.NoSuchElementException;


public class BST<Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	private class Node {
		
		private Key key;
		private Value val;
		private Node left,right;
		private int size;
		
		public Node(Key key, Value val,int size) {
			this.key=key;
			this.val=val;
			this.size=size;
			}
	}
	
	
	public void put(Key key,Value val) {
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");
		root=put(root,key,val);
	}
	
	private Node put(Node x,Key key, Value val) {
		if(x==null) {
			return new Node(key,val,1);
		}
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=put(x.left,key,val);
		else if(cmp==0) x.val=val;
		else x.right=put(x.right,key,val);
		x.size=1+size(x.left)+size(x.right);
		return x;
	}
	
	public void remove(Key key) {
		
		if(isEmpty())throw new IllegalArgumentException("Tree is Empty");
		if(key==null) throw new IllegalArgumentException("Key is null");
		root=remove(root,key);
		return;
	}
	
	private Node remove(Node x, Key key) {
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=remove(x.left,key);
		else if(cmp>0) x.right=remove(x.right,key);
		else {
			if (x.right == null) {
				return x.left;
			}
            if (x.left  == null) {
            	return x.right;
            }
			Node t=x;
			x=min(t.right);
			x.left=t.left;
			x.right=deleteMin(t.right);
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
	
	public boolean contains(Key key) {
		if(key==null) throw new IllegalArgumentException("Key is null");
		return contains(root,key);
	}
	
	private boolean contains(Node x, Key key) {
		
		if(x==null) return false;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return contains(x.left,key);
		else if(cmp==0) return true;
		else return contains(x.right,key);
	}
	
	public Value get(Key key) {
		if(key==null) throw new IllegalArgumentException("Key is null");
		return get(root,key);
	}
	
	private Value get(Node x,Key key) {
		
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp==0) return x.val;
		else return get(x.right,key);
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x==null) return 0;
		return x.size;
	}
	
	
	public Key floor(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to floor() is null");
		if (size()==0) throw new NoSuchElementException("list is empty");
		Node x=floor(root,key,null);
		if(x==null) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key,Node current) {
		if(x==null) return current;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return floor(x.left,key,current);
		else if(cmp==0) return x;
		else {
			if(x.right==null) return x;
			return floor(x.right,key,x);
		}
	}
	
	public Key ceiling(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to floor() is null");
		if (size()==0) throw new NoSuchElementException("list is empty");
		Node x=ceiling(root,key,null);
		if(x==null) return null;
		return x.key;
	}
	
	private Node ceiling(Node x, Key key,Node current) {
		if(x==null) return current;
		int cmp=key.compareTo(x.key);
		if(cmp<0) {
			if(x.left==null) return x;
			return ceiling(x.left,key,x);
		}
		else if(cmp==0) return x;
		else return ceiling(x.right,key,current); 
	}
	
	public Key min() {
		if (size()==0) throw new NoSuchElementException("list is empty");
		return min(root).key;
	}
	
	private Node min(Node x) {
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public Key max() {
		if (size()==0) throw new NoSuchElementException("list is empty");
		return max(root).key;
	}
	
	private Node max(Node x) {
		if(x.right==null) return x;
		return min(x.right);
	}
	
	
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public String toString() {
	    return traverse(root);
	}
	
	private String traverse(Node x) {
		if(x==null) return "";
		return traverse(x.left)+" "+x.key.toString()+" "+traverse(x.right);
		
	}
	
	public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    
    public boolean isBalanced() {
    	if(isEmpty()) return true;
    	return isBalanced(root);
    }
    
    private boolean isBalanced(Node x) {
    	if(x.left==null && x.right==null) return true;
    	if(x.left==null) {
    		if(x.right.left==null && x.right.right==null) return true;
    		else return false;
    	}
    	if(x.right==null) {
    		if(x.left.left==null && x.left.right==null) return true;
    		else return false;
    	}
    	return isBalanced(x.left) && isBalanced(x.right);
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

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    }
    
    public int rangeCount(Key lo,Key hi) {
    	if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue.size();
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
    
    public boolean isBST() {
    	return isBST(root,null,null);
    }
    
    private boolean isBST(Node x,Key min,Key max) {
    	if(x==null) return true;
    	if(min!=null && x.key.compareTo(min) <=0) return false;
    	if(max!=null && x.key.compareTo(max)>=0) return false;
    	return isBST(x.left,min,x.key) && isBST(x.right,x.key,max);
    }
    
    public Key getRandom() {
    	if(isEmpty()) throw new IllegalArgumentException("Tree is Empty");
    	int r=(int)(Math.random()*size());
    	return select(root,r).key;
    }
    
    public Key select(int k) {
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        if (isEmpty()) return null;
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 
    
    public int rank(Key key) {
    	if(key==null) throw new IllegalArgumentException("Key is null");
    	if(isEmpty()) throw new IllegalArgumentException("list is Empty");
    	return rank(root,key);
    }
    
    private int rank(Node x,Key key) {
    	if(x==null) return 0;
    	int cmp=key.compareTo(x.key);
    	if(cmp<0) return rank(x.left,key);
    	else if(cmp==0) return size(x.left);
    	else return 1+size(x.left)+rank(x.right,key);
    }


	

	public static void main(String[] args) {

		BST<String, Integer> st=new BST<String, Integer>();
		st.put("Ralph", 177);
		st.put("Johnny", 175);
		st.put("Elie", 173);
		st.put("Zgheib", 171);
		st.put("Cedric", 177);
		st.put("Raul", 175);
		//st.remove("Cedric");
		st.put("Samuel", 170);
		st.put("Zoughaib", 185);
		st.put("Karl", 186);
		st.put("Suzanne", 199);
		System.out.println(st.size(st.root));
		/*System.out.println(st.get("Karl"));
		System.out.println(st.get("Ralph"));
		System.out.println(st.get("Maya"));
		System.out.println(st.size());
		System.out.println(st.max());
		System.out.println(st.min());
		System.out.println(st.floor("Doctor"));
		System.out.println(st.ceiling("Doctor"));
		System.out.println(st);*/
		/*for(String x:st.levelOrder()) {
			System.out.print(x+" ");
		}
		for(String x:st.rangeSearch("Karl", "Ralph")) {
			System.out.print(x+" ");
		}
		System.out.println(st.rangeCount("Anthony", "Anthony"));*/
	}

}

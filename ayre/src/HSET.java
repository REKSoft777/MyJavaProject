import java.util.Iterator;
import java.util.NoSuchElementException;

public class HSET<Key> implements Iterable<Key> {
	
	private int m;	
	private Node[] st;
	private int n;
	
	
    private class Node<Key, Value>  {
		
		private Node next;
		private Object key;
	    
	    public Node(Object key, Node next) {
	    	this.key=key;
	    	this.next=next;
	    }
	
	}
    
    public HSET() {
        this(4);
    } 

    @SuppressWarnings("unchecked")
	private HSET(int capacity) {
        this.m = capacity;
        st=new Node[m];
    }
    
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    
    public void put(Key key) {
		if(key==null) throw new IllegalArgumentException("Key is Empty");
		int i=hash(key);
		for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return;
            }
        }
		if (n >= 8*m) resize(2*m);
        n++;
        st[i] = new Node(key, st[i]);
    }
    
    public int size() {
        return n;
    } 
	
	public boolean isEmpty() {
        return size() == 0;
    }
	
   public boolean contains(Key key) {
		
		if(key==null) throw new IllegalArgumentException("Key is Empty");
		int i=hash(key);
		for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return true;
            }
        }
		return false;
	}
    
    public void resize(int chain) {
    	
    	HSET<Key> temp=new HSET<Key>(chain);
    	for (int i=0; i<m; i++) {
    		for (Node x=st[i]; x!=null; x=x.next) {
    			temp.put((Key) x.key);
    		}
    	}
    	this.m=temp.m;
    	this.n=temp.n;
    	this.st=temp.st;
    }
    
   public void remove(Key key) {
		
		if(key==null) throw new IllegalArgumentException("Key is null");
		if(isEmpty()) throw new IllegalArgumentException("List is Empty");
		int i=hash(key);
		st[i] = remove(st[i], key);
	}
	
	private Node remove(Node x, Key key)  {
		if(x==null) return null;
		if(key.equals(x.key)) {
		  if (m > 4 && n <= m) {
			  resize(m/2);
		  }
	      n--;
		  return x.next;
		}
		else x.next=remove(x.next,key);
		return x;
	}
	
	@Override
	public Iterator<Key> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Key> {
    	private int i=0;
        private Node current = st[i];  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            Key key=(Key)current.key;
            if(i < m-1) {
            	if(current.next!=null) {
            		current=current.next;
            	}
            	else {
            		i++;
            		current=st[i];
            	}
            }
            else { current=current.next;}
            return key;
            }
            
        }
    
    
    
    

	public static void main(String[] args) {

		HSET<String> st = new HSET<String>();
        for (int i = 0; i< 10; i++) {
            String key = StdIn.readString();
            st.put(key);
        }
        st.remove("Joseph");
       for (String s : st) 
            StdOut.print(s + " "); 
	}
}

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int n;
	
	private class Node {
		
		private Item item;
		private Node next;
		
		
	}
	
	public void removeAfter(Node node) {
		if(node==null) return;
		if(node.next==null) return;
		node.next=node.next.next;
	}
	
	public Queue() {
		
		first=null;
		last=null;
		n=0;
	}
	
	public void enqueue(Item item) {
		
		n++;
		Node oldLast=last;
		last=new Node();
		last.next=null;
		last.item=item;
		if(isEmpty()) first=last;
		else oldLast.next=last;
	}
	
	public Item dequeue() {
		
		if(isEmpty()) throw new IllegalArgumentException("Queue underflow");
		n--;
		Item item=first.item;
		first=first.next;
		if(isEmpty()) last=null;
		return item;
		
	}
	
    public Item peek() {
		
		if(isEmpty()) throw new IllegalArgumentException("Queue underflow");
		return first.item;
		
	}
	
	public boolean find(Item key) {
		if(isEmpty()) return false;
		Node current=first;
		for (int i=0; i<n; i++) {
			if(current.item.equals(key)) return true;
			current=current.next;
		}
		return false;
	}
	
	
	
	public void delete(int k) {
		if(k<=0) throw new IllegalArgumentException("Invalid index");
		if(isEmpty()) return;
		if(k==1) {
			first=first.next;
			n--;
			return;
		}
		Node temp = first;
	    for (int i = 2; i < k; i++) {
	        temp = temp.next;
	        if (temp == null) return;   
	    }
	    if (temp.next == null) return; 
	    temp.next = temp.next.next;
	    n--;
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    public String toString() {
    	StringBuilder sb=new StringBuilder();
    	for(Item x: this) {
    		sb.append(x.toString());
    	}
    	return sb.toString();
    }
	
	public static void main(String[] args) {
		
		Queue<Integer> queue= new Queue<Integer>();
		int m=Integer.parseInt(args[0]);
		int n=Integer.parseInt(args[1]);
		for (int i=1; i<=n; i++) {
			queue.enqueue(i);
		}
		while(!queue.isEmpty()) {
			for (int i=0; i<m-1; i++) {
				queue.enqueue(queue.dequeue());
			}
			System.out.print(queue.dequeue()+" ");
		}
	}

}

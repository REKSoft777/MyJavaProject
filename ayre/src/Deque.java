
public class Deque<Item> {
	
	private Node first;
	private Node last;
	private int size;
	
	private class Node {
		
		private Item item;
		private Node next;
		private Node prev;
	}
	
	public Deque() {
		first=null;
		last=null;
		size=0;
	}
	
	public boolean isEmpty() {
		if (first==null) return true;
		return false;
	}
	
	public void push(Item item) {
		
		Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
		if(size==0) last=first;
		if(size!=0) oldFirst.prev=first;
		size++;
	}
	
    public Item pop() {
		
		if(isEmpty()) throw new IllegalArgumentException("Deque underflow");
		Node oldFirst= first;
		first=first.next;
		return oldFirst.item;
	}
	
	public void queue(Item item) {
		
		Node oldLast=last;
		Node last=new Node();
		last.item=item;
		oldLast.next=last;
		last.prev=oldLast;
	}
	
	public Item dequeue() {
		
		if(isEmpty()) throw new IllegalArgumentException("Deque underflow");
		Node oldLast=last;
		last=new Node();
		last=oldLast.prev;
		//last.next=null;
		return oldLast.item;
	}

	public static void main(String[] args) {

		Deque<String> deque=new Deque<String>();
		deque.push("ralph");
		deque.push("elie");
		deque.push("tony");
		while(!deque.isEmpty()) {
			System.out.print(deque.pop()+" ");
		}
	}

}

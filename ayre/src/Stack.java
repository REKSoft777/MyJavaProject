import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	
	private Node first;
	private int n;
	
	private class Node {
		private Item item;
		private Node next;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item> {
		private Node current;
		
		public StackIterator() {
			
			current=first;
		}
		
		public boolean hasNext() {
			return current!=null;
		}
		public Item next() {
			Item a=current.item;
			current=current.next;
			return a;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	public Stack() {
		
		first=null;
		n=0;
	}
	
	public boolean isEmpty() {
		
		return first==null;
	}
	
	public static Stack<String> copy(Stack<String> stack) {
		
		Stack<String> mid= new Stack<>();
		Stack<String> end= new Stack<>();
		for(String S: stack) {
			mid.push(S);
		}
		for(String S: mid) {
			end.push(S);
		}
		return end;
	}
	
	public void push(Item item)  {
		
		Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
		n++;
	}
	
	public Item pop() {
		
		if(isEmpty()) throw new IllegalArgumentException("Stack underflow");
		Item item= first.item;
		first=first.next;
		n--;
		return item;
	}
	
	public Item peek() {
		
		if(isEmpty()) throw new IllegalArgumentException("Stack underflow");
		return first.item;
	}
	
	public int size() {
		return n;
	}

	public static void main(String[] args) {
		
	   Stack<String> stack=new Stack<>();
	   stack.push("ralph");
	   stack.push("karl");
	   stack.push("lea");
	   Stack<String> stacky=copy(stack);
	   for(String x: stacky) {
	      System.out.print(x+ " ");
	   }
	}


}

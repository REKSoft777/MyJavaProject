import java.util.Scanner;

public class GeneralizeQueue<Item> {

	private int size;
	private Node first;
	private Node last;
	
	public GeneralizeQueue() {
		size=0;
		first=null;
		last=null;
	}
	
	private class Node {
		
		private Item item;
		private Node next;
	}
	
	public void add(Item item) {
		
		size++;
		Node oldLast=last;
		last=new Node();
		last.next=null;
		last.item=item;
		if(isEmpty()) first=last;
		else oldLast.next=last;
	}
	
	public boolean isEmpty() {
		if(first==null) return true;
		return false;
	}
	
	public Item remove(int i) {
		
		if(i<=0 || size<i) throw new IllegalArgumentException("Invalid index");
    	if(size==0) throw new IllegalArgumentException("Queue underflow");
    	if(i==1) {
    		size--;
    		Item temp=first.item;
    		first=first.next;
    		return temp;
    	}
    	Node current=first;
    	Node prev=first;
    	for (int j=1; j<i; j++) {
    		prev=current;
    		current=current.next;
    	}
    	Item temp=current.item;
    	prev.next=prev.next.next;
    	size--;
    	return temp;
	}
	
	public int size() { return size; }
	
	
    
    

	public static void main(String[] args) {

		GeneralizeQueue<String> queue= new GeneralizeQueue<String>();
		Scanner myInput=new Scanner(System.in);
		while(!myInput.hasNext("stop")) {
			queue.add(myInput.next());
		}
		System.out.println(queue.remove(1));
		System.out.println(queue.remove(2));
		System.out.println(queue.remove(queue.size()));
		System.out.println(queue.remove(1));
	}

}

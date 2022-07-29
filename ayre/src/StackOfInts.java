

public class StackOfInts {

	private Node first;
	private int n;
	
	private class Node {
		private int a;
		private Node next;
	}
	
	public StackOfInts() {
		
		first=null;
		n=0;
	}
	
	public boolean isEmpty() {
		
		return first==null;
	}
	
	public void push(int b)  {
		
		Node oldFirst=first;
		first=new Node();
		first.a=b;
		first.next=oldFirst;
		n++;
	}
	
	public int pop() {
		
		if(isEmpty()) throw new IllegalArgumentException("Stack underflow");
		int b= first.a;
		first=first.next;
		n--;
		return b;
	}
	
	public int peek() {
		
		if(isEmpty()) throw new IllegalArgumentException("Stack underflow");
		return first.a;
	}
	
	public int size() {
		return n;
	}
	
	public int max() {
		
		int max=0;
		if(isEmpty()) return 0;
		Node current=first;
		while(current.a<max) {
			current=current.next;
			if (current==null) return max;
		}
		max=current.a;
		return max(current,max);
	}
	
	private int max(Node current, int m) {
		if(current.next==null) return m;
		current=current.next;
		int max=m;
		System.out.println(max);
		while(current.a<max) {
			current=current.next;
			if (current==null) return max;
		}
		max=current.a;
		return max(current,max);
	}

	public static void main(String[] args) {
		
	   Stack<Integer> stack=new Stack<>();
	   SStopWatch timer=new SStopWatch();
	   for (int i=0; i<100000000; i++) {
		   int a =5;
		   stack.push(a);
		   stack.pop();
	   }
	   System.out.println(timer.elapsedTime());
	   timer.restart();
	   StackOfInts stacks=new  StackOfInts();
	   for (int i=0; i<100000000; i++) {
		   int b=5;
		   stacks.push(b);
		   stacks.pop();
	   }
	   System.out.println(timer.elapsedTime());
	}

}

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item> {

	private int capacity=1;
	private  Item[] item=(Item[]) new Object[capacity];
	private int size=0;
	
	public boolean isEmpty() {
		
		if(size==0) return true;
		return false;
	}
	
	private void resizeArray(int capacity) {
		
		Item[] a=(Item[]) new Object[capacity];
		for (int i=0; i<size; i++) {
			a[i]=item[i];
		}
		item=a;	
	}
	
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item> {
		private int i;
		private  Item[] counter=(Item[]) new Object[capacity];
		
		public ArrayIterator() {
			counter=item;
			for (int j=0; j<size; j++) {
				int r= j+(int)((size-j)*Math.random());
				Item temp=counter[j];
				counter[j]=counter[r];
				counter[r]=temp;
			}
            i=0;
            
        }
		
		public boolean hasNext() {
			return i<size;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
            if (!hasNext()) throw new IllegalArgumentException();
            return counter[i++];
        }
	}
	
	public void enqueue(Item a) {
		
		if(size==capacity) {
			capacity*=2;
			resizeArray(capacity);
		}
		item[size++]=a;
	}
	
	public Item sample() {
		if(size==0) throw new IllegalArgumentException("Queue underflow");
		return item[(int)(size*Math.random())];
	}
	
	public Item dequeue() {
		
		if(size==0) throw new IllegalArgumentException("Queue underflow");
		if(size<=capacity/4) {
    		capacity=capacity/2;
    		resizeArray(capacity);
    	}
		int a=(int)(size*Math.random());
		Item temp=item[a];
		item[a]=item[size-1];
		item[size-1]=temp;
		item[size-1]=null;
		size--;
		return temp;
	}
	
	public static void main(String[] args) {

		RandomQueue<String> randomQueue=new RandomQueue<String>();
		String[] deck= {"2 of Heart","3 of Heart", "4 of Heart", "5 of Heart","7 of heart"};
		for (String S: deck) {
			randomQueue.enqueue(S);
		}
		for(String S: randomQueue) {
			System.out.println(S+ " ");
		}
		System.out.println();
		for(String S: randomQueue) {
			System.out.println(S+ " ");
		}
	}

	
	
	
}

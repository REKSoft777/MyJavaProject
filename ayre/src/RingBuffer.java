
	public class RingBuffer {

		private int capacity = 0;
		private int size = 0;
		private int head = 0;
		private int tail = 0;
		private Object[] array;
		
        
		public RingBuffer(int capacity)
		{
			this.capacity = capacity;
			array = new Object[capacity];
		}
		
		public void qeue(Object element) throws Exception
		{
			int index = (tail) % capacity;
            if (size < capacity) size++;
			array[index] = element;
			if(tail%capacity==head%capacity) head++;
			tail++;
		}
		
		public Object deqeue() throws Exception
		{
			if (size == 0) {
				throw new Exception("Empty Buffer");
			}
			int index = head % capacity;
			Object element = array[index];
			head++;
			size--;
			return element;
		}

		public Object peek() throws Exception
		{
			if (size == 0) {
				throw new Exception("Empty Buffer");
			}
			int index = head % capacity;
			Object element = array[index];
			return element;
		}

		public boolean isEmpty() { return size == 0; }

		public int size() { return size; }
	

	
		public static void main(String[] args) throws Exception
		{
			RingBuffer cb = new RingBuffer(4);
			cb.qeue(5);
			cb.qeue(6);
			cb.qeue(7);
			cb.qeue(1);
			cb.qeue(4);
			System.out.println(
				"The elements are printed in the order :");
			System.out.println(cb.deqeue());
			System.out.println(cb.deqeue());
			System.out.println(cb.deqeue());
			System.out.println(cb.deqeue());
			System.out.println(cb.deqeue());
		}
	}



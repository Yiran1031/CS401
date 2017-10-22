
public class FixedFront<T> implements QueueInterface<T> {
	protected final int DEFCAP = 100;
	protected T[] elements;
	protected int origCap;
	protected int numElements = 0;
	protected int front = 0;
	protected int rear;
	public FixedFront() 
	{
		elements = (T[]) new Object[DEFCAP];
		rear = DEFCAP - 1;
		origCap = DEFCAP;
	}
	public FixedFront(int origCap) 
	{
		elements = (T[]) new Object[origCap];
		rear = origCap - 1;
		this.origCap = origCap;
	}
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if(isFull())
			throw new  QueueOverflowException("the queue is full");
		rear = (rear + 1) % elements.length;
		elements[rear] = element;
		numElements = numElements + 1;
		
	}
	public T peek() 
	{
		return elements[front];
	}
	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new QueueUnderflowException("The Queue is empty");
		T element;
		element = elements[0];
		T[] temp = (T[]) new Object[origCap];	
		for(int i = 1; i < temp.length; i++) 
		{
			temp[i-1] = elements[i];
		}
		front = 0;
		rear = rear-1;
		elements = temp;
		numElements = numElements - 1;
		return element;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(numElements == elements.length)
			return true;
		else 
			return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(numElements == 0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElements;
	}

}

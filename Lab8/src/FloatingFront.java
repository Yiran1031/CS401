
public class FloatingFront<T> implements QueueInterface<T> {
	protected final int DEFCAP = 100;
	protected T[] elements;
	protected int origCap;
	protected int numElements = 0;
	protected int front = 0;
	protected int rear;
	public FloatingFront() 
	{
		elements = (T[]) new Object[DEFCAP];
		rear = DEFCAP - 1;
		origCap = DEFCAP;
	}
	public FloatingFront(int origCap) 
	{
		elements = (T[]) new Object[origCap];
		rear = origCap - 1;
		this.origCap = origCap;
	}
	private void enlarge() 
	{
		T[] larger = (T[]) new Object[elements.length + origCap];
		int currSmaller = front;
		for(int currLarger = 0; currLarger < numElements; currLarger++) 
		{
			larger[currLarger] = elements[currSmaller];
			currSmaller = (currSmaller + 1) %  elements.length;
		}
		elements = larger;
		front = 0;
		rear = numElements - 1;
	}
	
	public T peek() 
	{
		return elements[front];
	}
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if(numElements == elements.length)
			enlarge();
		rear = (rear + 1) % elements.length;
		elements[rear] = element;
		numElements = numElements + 1;
	}
	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue");
		else 
		{
			T element;
			element = elements[front];
			front = (front+1) % elements.length;
			numElements--;
			return element;
		}
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
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

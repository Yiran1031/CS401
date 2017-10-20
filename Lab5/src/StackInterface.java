
public interface StackInterface<T> {
	void push(T element) throws StackOverflowException;
	
	void pop() throws StackUnderflowException;
	
	T Peek() throws StackUnderflowException;
	
	boolean isFull();
	
	boolean isEmpty();
}

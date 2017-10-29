package lab9;

public interface ListInterface<T> {
	public int size();
	public boolean contains(T element);
	public boolean remove(T element);
	public T get();
	public String toString();
	public void reset();
	public T getNext();
}

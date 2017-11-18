
public interface CollectionInterface<T> {
	//attempts to add element to this collection
	//return true if successful, false otherwise.
	boolean add(T element);
	
	//return an element e from this collection such that e.equals(target)
	//If no such element exists, returns null
	T get(T target);
	
	//Return true if this collection contains an element e such that
	//e.equals(target); otherwise returns false
	boolean contains(T target);
	
	//remove an element e from this collection such that e.equals(target)
	//and returns true, If no such element exits, returns false
	boolean remove(T target);
	
	//if the collection is full, return true
	boolean isFull();
	
	//if the collection is empty, return true
	boolean isEmpty();
	
	//return the number of elements in this collection
	int size();
}

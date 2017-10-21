### Queue
##### what is queue?
Queue is a structure in which elements are **added to the rear** and **removed from the front**; a "first in, first out "(FIFO) structure
##### Operation on queues
* Constructor: creates an empty queue
* Transformers
  * enqueue: adds an element to the rear of a queue
  * dequeue: removes add returns the front element of the queue

##### Queue interface
```
public interface QueueInterface<T>
{
  void enqueue(T element) throws QueueOverflowException;
  //if queue is full, throws`` QueueOverflowException.
  //otherwise, adds element to the rear of the queue.

  T dequeue() throws QueueUnderflowException;
  //throws QueueUnderflowException if this queue is empty;
  //otherwise, removes front element from this queue and returns it.

  boolean isFull();
  // return true if the queue is full;
  // otherwise return false;
  boolean isEmpty();
  //if the queue is empty, return true;
  // otherwise return false;

  int size();
  //return the number of elements in this queue;
}
```

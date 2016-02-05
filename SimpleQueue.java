
public class SimpleQueue<E> implements QueueADT<E> {

	private E items[];
	private E shadow[];
	private int numItems;
	private int frontIndex;
	private int rearIndex;
	private static final int INITSIZE = 10;
	
	public SimpleQueue(){
		numItems = 0;
		items = (E[])(new Object[INITSIZE]);
		frontIndex = 0;
		rearIndex = 0;
	}
	/**
     * Checks if the queue is empty.
     * @return true if queue is empty; otherwise false.
     */
	public boolean isEmpty() {
		return numItems==0;
	}

	 /**
     * removes and returns the front item of the queue.
     * @return the front item of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
	public E dequeue() throws EmptyQueueException {
		if(numItems == 0)
			throw new EmptyQueueException();
		else{
			numItems --;
			rearIndex --; 
			return items[rearIndex];
		}
	}

	/**
     * Adds an item to the rear of the queue.
     * @param item the item to add to the queue.
     * @throws IllegalArgumentException if item is null.
     */
	public void enqueue(E item) {
		if (items.length == numItems) {
	        E[] tmp = (E[])(new Object[items.length*2]);
	        System.arraycopy(items, frontIndex, tmp, frontIndex,
		                 items.length-frontIndex);
	        if (frontIndex != 0) {
	            System.arraycopy(items, 0, tmp, items.length, frontIndex);
	        }
	        items = tmp;
		    rearIndex = frontIndex + numItems - 1;
	    }
	    // use auxiliary method to increment rear index with wraparound
	    rearIndex = (rearIndex + 1) % items.length;

	    // insert new item at rear of queue
	    items[rearIndex] = item;
	    numItems++;
	}

	/**
     * Returns (but does not remove) the front item of the queue.
     * @return the front item of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
	public E peek() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return items[frontIndex];
	}

	/**
     * Returns the size of the queue.
     * @return the size of the queue
     */
	public int size() {
		// TODO Auto-generated method stub
		return numItems;
	}

}

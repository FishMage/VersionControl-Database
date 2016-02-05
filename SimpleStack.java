


public class SimpleStack<E> implements StackADT<E> {

	private E items[];
	private E shadow[];
	private int numItems;
	private static int curr;
	private static final int INITSIZE = 10;
	
	public SimpleStack(){
		numItems = 0;
		items = (E[])(new Object[INITSIZE]);
		shadow=(E[])(new Object[INITSIZE*2]);
		curr = 0;
		
	}
	/**
     * Checks if the stack is empty.
     * @return true if stack is empty; otherwise false
     */
	public boolean isEmpty() {
		return numItems == 0;
	}

    /**
     * Returns (but does not remove) the top item of the stack.
     * @return the top item of the stack
     * @throws EmptyStackException if the stack is empty
     */
    
	public E peek() throws EmptyStackException {
		if(numItems==0)
			throw new EmptyStackException();
		
		return items[numItems-1];
	}

    /**
     * Pops the top item off the stack and returns it. 
     * @return the top item of the stack
     * @throws EmptyStackException if the stack is empty
     */
	public E pop() throws EmptyStackException {  //////?
		 if (numItems == 0) {
		        throw new EmptyStackException();
		    }
		    else {
		        numItems--;
		        return items[numItems];
		    }
	}

	/**
     * Pushes the given item onto the top of the stack.
     * @param item the item to push onto the stack
     * @throws IllegalArgumentException if item is null.
     */
	public void push(E item) {
		if(numItems==items.length){   //Array Expansion is needed
			E newItems[] = (E[])(new Object[items.length*2]);
			items = shadow;
			shadow = newItems;
			// add the items and copy to the shadow array
			items[numItems-1]= item;
			shadow[curr] = items[curr];
			curr++;
		}
		if (numItems == 0){
			items[0] = item;
            shadow[0] = item;}
		else{
			items[numItems-1]= item;
			shadow[curr] = items[curr];
			curr++;
		} 
	    numItems++;
	}

	/**
     * Returns the size of the stack.
     * @return the size of the stack
     */
	public int size() {
		
		return numItems;
	}

}

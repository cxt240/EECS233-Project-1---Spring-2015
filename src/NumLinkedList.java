/**
 * @author Chris
 * the NumList class using LinkedList
 * part of Project 1 of EECS 233
 */
public class NumLinkedList extends NumList{

	/**
	 * List is the list holding all of the values
	 * size is how many values there are stored
	 */
	private LLNode list = new LLNode(0, null);
	private int size = 0;
	/**
	 * returns the size of the sequence
	 * worst-case runtime: O as it looks at a field
	 * @return the size of the sequence
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * inserts a new component at the given position
	 * Worst-case runtime: On as the worst possibility is if i points to the end
	 * @param i the position of the insert
	 * @param value the value to be inserted
	 */
	@Override
	public void insert(int i, double value) {
		//if i is pointing to the middle of the list
		if(i < size){
			LLNode nptr = list;
			for(int k = 0; k < i - 1; k++) {
				nptr = nptr.getNext();
			}
			LLNode next = nptr.getNext();
			LLNode current = new LLNode(value, next);
			nptr.setNext(current);
		}
		// if i is pointing at the end, or to empty space 
		else {
			LLNode nptr = list;
			for(int k = 0 ; k < size; k++) {
				nptr = nptr.getNext();
			}
			nptr.setNext(new LLNode(value, null));
		}
		
		size++;
		sum += value;
	}
	
	/**
	 * removes the value at the given position
	 * Worst-case runtime: On if i is at the end of the linkedlist
	 * @param i the address of the value to be removed
	 */
	@Override
	public void remove(int i) {
		//does nothing if i is pointing at empty space
		if (i > size) {
		}
		else {
			//goes through the list and alters the pointers
			LLNode nptr = list;
			for(int k = 0; k < i -1; k++) {
				nptr = nptr.getNext();
			}

			sum = sum - nptr.getNext().getElement();
			if(i == size) {
				nptr.setNext(null);
			}
			else {
				nptr.setNext(nptr.getNext().getNext());
			}
			size--;
		}
	}
	
	/**
	 * looks up the value at the given position
	 * Worst-case runtime: On if i is at the end of the linkedlist
	 * @param i the address of the value to be looked up
	 * @return the value of that address
	 */
	@Override
	public double lookup(int i) {
		//if i doesn't exist in the list
		if (i > size) {
			throw new IndexOutOfBoundsException("Position doesn't exist");
		}
		
		// if i exists
		else {
			LLNode nptr = list;
			for(int k = 0; k < i; k++) {
				nptr = nptr.getNext();
			}
			return nptr.getElement();
		}
	}
}
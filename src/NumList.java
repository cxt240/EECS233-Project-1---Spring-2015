/**
 * @author Chris Tsuei
 * Numlist is an abstract class used in NumArrayList and NumLinkedList
 * Assignment for Project 1 of EECS 233
 */
public abstract class NumList {

	/**
	 * sum is the total of all of the values in this program
	 */
	public double sum = 0;

	/**
	 * returns the size of the sequence
	 * @return the size of the sequence
	 */
	public int size() {
		return -1;
	}
	
	/**
	 * inserts a new component at the given position
	 * @param i the position of the insert
	 * @param value the value to be inserted
	 */
	public void insert(int i, double value) {
		
	}
	
	/**
	 * removes the value at the given position
	 * @param i the address of the value to be removed
	 */
	public void remove(int i) {
		
	}
	
	/**
	 * looks up the value at the given position
	 * @param i the address of the value to be looked up
	 * @return the value of that address
	 */
	public double lookup(int i) {
		return -1;
	}
}

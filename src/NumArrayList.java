/**
 * @author Chris
 * the NumList class using arrays
 * part of Project 1 of EECS 233
 */
public class NumArrayList extends NumList{

	/**
	 * array holds all of the value of this NumArrayList
	 * pointer is the current index of the array
	 */
	private double[] array = new double[100];
	private int pointer = 0;
	
	/**
	 * worst-case runtime:O just looks at a single field
	 * returns the size of the sequence
	 * @return the size of the sequence
	 */
	@Override
	public int size() {
		return pointer;
	}
	
	/**
	 * inserts a new component at the given position
	 * Worst-case runtime On^2 as if the insert is the last possible value of the array
	 * the array has to be copied twice
	 * @param i the position of the insert
	 * @param value the value to be inserted
	 */
	@Override
	public void insert(int i, double value) {
		this.sum += value;
		double holder = array[i - 1];
		array[i - 1] = value;
		
		for(int k = i; k < size() + 1; k++) {
			double hold2 = array[k];
			array[k] = holder;
			holder = hold2;
		}
		
		//if the just inserted value is the last value, expands the array
		if(i + 2 == this.array.length) {
			double[] hold = new double[this.array.length];
			for (int j = 0; j < this.array.length; j++) {
				hold[j] = this.array[j];
			}
			
			this.array = new double[this.array.length + 100];
			for(int k = 0; k < hold.length; k++) {
				this.array[k] = hold[k];
			}
		}
		this.pointer++;
	}
	
	/**
	 * removes the value at the given position
	 * worst-case runtime: On^3 as if the index to be removed is the first value (On)
	 * and if the array is smaller than the numb0er of values that it contains  (On^2)
	 * @param i the address of the value to be removed
	 */
	@Override
	public void remove(int i) {
		i--;
		// if the point where i is point to doesn't exist yet
		if(i >= pointer) {
			throw new IndexOutOfBoundsException("Position doesn't exist");
		}
		else {
			// shifts all elements up
			sum = sum - array[i];
			for(int j = i; j < size(); j++){
				double filler = this.array[j+1];
				this.array[j] = filler;
			}
			this.array[size() - 1] = 0;
			pointer--;
			
			// if the number of elements is more than 2 times smaller than the length of the array
			if (pointer * 2 < this.array.length) {
				double[] hold = new double[size()];
				for (int j = 0; j < pointer; j++) {
					hold[j] = this.array[j];
				}
				this.array = new double[(int) (this.array.length * .65)];
				for (int k = 0; k < hold.length; k++) {
					double filler2 = hold[k];
					this.array[k] = filler2;
				}
			}
		}
	}

	/**
	 * looks up the value at the given position
	 * worst-case runtime: O as the method just looks up the value at an index
	 * @param i the address of the value to be looked up
	 * @return the value of that address
	 */
	@Override
	public double lookup(int i) {
		i--;
		//if i doesn't exist
		if(i > pointer) {
			throw new IndexOutOfBoundsException("Position doesn't exist");
		}
		else {
			return array[i];
		}
	}
}

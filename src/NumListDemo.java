/**
 * Runs examples of the NumArrayList and NumLinkedList
 * @author Chris Tsuei
 * part of project1 of project 1 for EECS 233
 */
public class NumListDemo {
	
	/**
	 * method that finds the mean of the entire sequence
	 * Worst case runtime: O, as the amount of methods it calls and the calculations used are constants
	 * @param list the list in which the average is to be calculated in
	 * @return the average of all values of the list
	 */
	public static double meanSequence(NumList list) {
		
		double average = list.sum / list.size();
		return average;
	}

	/**
	 * the main method of the project
	 * @param args the arguments used in this method
	 */
	public static void main(String[] args) {
		NumArrayList a = new NumArrayList();
		for (int i = 1; i < 11; i++) {
			a.insert(i, i);
		}
		System.out.println(meanSequence(a));

		NumLinkedList b = new NumLinkedList();
		for(int i = 1; i < 11; i++) {
			b.insert(i, (double)i);
		}
		System.out.println(meanSequence(b));
	}
}

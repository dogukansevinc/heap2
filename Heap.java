
public class Heap {
	private int currentSize;
	private int[] heapArray;

	// Constructors
	public Heap() {
		setCurrentSize(0);
		heapArray = new int[1];
	}

	public Heap(int capacity) {
		setCurrentSize(0);
		heapArray = new int[capacity + 1];
	}

	// Heap Operations
	public int[] buildHeap(int[] array) {
		// Builds the heap from an array that you have provided
		currentSize = array.length;
		heapArray = new int[(currentSize + 1)];

		for (int i = 0; i < array.length; i++) {
			heapArray[i + 1] = array[i];
		}

		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
		}

		return heapArray;
	}

	private void percolateDown(int hole) {
		// Organizes the elements of the heap and percolate down the elements for not
		// violating heap properties
		int child;
		int tmp = heapArray[hole];

		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;

			if (child != currentSize && Integer.compare(heapArray[child + 1], heapArray[child]) < 0) {
				child++;
			}

			if (Integer.compare(heapArray[child], tmp) < 0) {
				heapArray[hole] = heapArray[child];
			} else
				break;
		}

		heapArray[hole] = tmp;
	}

	public int getMinValue() {
		// Returns the min (root) of the binary min heap

		// IMPLEMENT THIS METHOD
		// ...
		return heapArray[0];
	}

	public int getHeight() {
		// Returns the height of the binary min heap

		// IMPLEMENT THIS METHOD
		// ...

		return (int) Math.ceil(Math.log(currentSize + 1) / Math.log(2)) - 1;
	}

	public void insert(int value) {
		// Inserts an integer element to the binary min heap

		// IMPLEMENT THIS METHOD
		// ...

		// Insert a new item to the end of the array
		if (currentSize == heapArray.length - 1)
			enlargeArray(currentSize * 2);

		int pos = ++currentSize;
		percolateUp(value, pos);
		heapArray[pos] = value;
	}

	private void percolateUp(int value, int hole) {
		// Organizes the elements of the heap and percolate up the elements for not
		// violating heap properties
		for (; hole > 1 && Integer.compare(value, heapArray[hole / 2]) < 0; hole = hole / 2)
			heapArray[hole] = heapArray[hole / 2];
		// IMPLEMENT THIS METHOD
		// ...
	}

	public boolean search(int index, int value) {
		if (heapArray[index] == value)
			return true;
		if (heapArray[index] < value)
			return search(index * 2 + 2, value);

		return search(index * 2 + 1, value);
	}

	public boolean search(int value) {
		// Searches the heap for if the given value is present or not, returns TRUE if
		// value is present, FALSE otherwise

		// Base Cases: root is null or key is present at root
		if (heapArray[0] == value)
			return true;

		if (heapArray[0] < value)
			return search(2 * 0 + 2, value);

		return search(2 * 0 + 1, value);

		// IMPLEMENT THIS METHOD
		// ...
	}

	// Helper Methods
	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void makeEmpty() {
		currentSize = 0;
	}

	private void enlargeArray(int newSize) {
		// Enlarges array to the new size
		int[] old = heapArray;
		heapArray = new int[newSize];

		for (int i = 1; i < old.length; i++)
			heapArray[i] = old[i];
	}

	public void printHeap() {
		// Prints the heap elements one by one
		int level = 0;

		for (int i = 1; i < heapArray.length; i++) {
			System.out.print(heapArray[i] + " ");

			if ((i + 1) % Math.pow(2, level) == 0) {
				System.out.println();
				level++;
			}
		}

		System.out.println("\n---------------------------");
	}

	// Getters and Setters
	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public int[] getHeapArray() {
		return heapArray;
	}

	public void setHeapArray(int[] heapArray) {
		this.heapArray = heapArray;
	}

}

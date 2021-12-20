
public class Main {

	public static void main(String[] args) {
		int[] arrayA = { 25, 35, 10, 15, 150, 64, 48, 105, 149, 148, 130, 22, 67, 56, 43 };

		// Instantiate a heap
		// ...
		Heap heapObject = new Heap();
		// Build the heap from given array arrayA[] with buildHeap() method and print it
		// ...
		heapObject.buildHeap(arrayA);
		heapObject.printHeap();
		// Get min value of the heap
		// ...
		System.out.println("Minimum value in the heap: " + heapObject.getMinValue());
		// Get height of the heap
		// ...
		System.out.println("Height of the heap: " + heapObject.getHeight());
		// Insert random numbers one by one to test whether the insert() method works or
		// not
		// ...
		// insert(52);
		heapObject.insert(52);
		System.out.println("Inserted 52, updated heap; ");
		heapObject.printHeap();
		heapObject.insert(32);
		System.out.println("Inserted 32, updated heap; ");
		heapObject.printHeap();
		heapObject.insert(44);
		System.out.println("Inserted 44, updated heap; ");
		heapObject.printHeap();
		// Search a number for if the heap includes it or not
		// ...
		// search(52);
		heapObject.search(52);
	}

}
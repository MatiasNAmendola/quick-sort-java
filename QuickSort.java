/**
 *	QuickSort.java
 *	Quick sort implementation in java for an integer array, in place sort
 *	Runtime: Average case - O(nlogn)	Worst case - O(n^2)
 *	Memory: O(logn)
 *
 *	@author Mandeep Condle
 */
 
 class QuickSort {
 	public static void main(String[] args) {
 		QuickSort quick = new QuickSort();
 		int[] test = {3, 5, 6, 4, 8, 7, 2, 1};
 		System.out.println("unsorted array: " + QuickSort.printarray(test));

 		quick.quicksort(test, 0, 7);
 		System.out.println("after quick sort: " + QuickSort.printarray(test));
 	}

 	/**
 	 *	Recursively sorts the int array
 	 *	@param	int array
 	 *	@param	index of left most element
	 *	@param	index of right most element
 	 */
 	public void quicksort(int[] array, int left, int right) {
 		int index = partition(array, left, right);

 		if (left < index-1) {
 			quicksort(array, left, index-1);
 		} 
 		if (index < right) {
 			quicksort(array, index, right);
 		}
 	}

 	/**
 	 *	Returns the index of the partition element
 	 *	For an integer array - a[i], index of partition element k is such that:
 	 *	a[k] is greater than all elements before it and lesser than all elements after it
 	 * 	@param	int array
 	 *	@param	index of left most element
 	 *	@param	index of right most element
 	 *	@return index of partition element
 	 */	
 	public int partition(int[] array, int left, int right) {
 		//choose the middle element as the pivot
 		int pivot = array[(left+right)/2];

 		while (left <= right) {
 			//find elements to swap
 			while (array[left] < pivot) { left++; }
 			while (array[right] > pivot) { right--; }

 			if (left <= right) {
 				swap(array, left, right);
 				left++;
 				right--;
 			}
 		}
 		return left;
 	}


 	/**
 	 *	Swaps 2 elements in an int array
 	 *	@param	int array
 	 *	@param	index a
 	 *	@param	index b
 	 */
 	public void swap(int[] array, int a, int b) {
 		int temp = array[a];
 		array[a] = array[b];
 		array[b] = temp;
 	}


 	/**
	 *	prints out an int array as a string
	 *	@param	int array to be printed
	 */
	public static String printarray(int[] array) {
		String str = "{ ";
		for (int i=0; i<array.length; i++) {
			str += array[i] + " ";
		}
		str += "}";

		return str;
	}


 }
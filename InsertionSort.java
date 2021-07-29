package sorting.simpleSorting;

import sorting.AbstractSorting;

import static util.Util.swap;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int n = rightIndex;
         
			for (int j = leftIndex; j < n; j++) {  
                int i = j+1;  
                while ( (i > leftIndex) && (array[i].compareTo(array[i-1]) < 0) ) { 
					swap(array, i-1, i); 
					i--;  
                }  
//				swap(array, key, i+1);
//				array[i+1] = key;  
		}
    }  
}

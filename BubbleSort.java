package sorting.simpleSorting;

import static util.Util.swap;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		for(int i = leftIndex; i < rightIndex; i++){

			for(int j = leftIndex; j < rightIndex - i; j++){  

				if(array[j].compareTo(array[j+1]) > 0){  
					swap(array, j+1, j);
				}


			}

		}
	}
}

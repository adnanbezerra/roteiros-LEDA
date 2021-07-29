package sorting.simpleSorting;

import static util.Util.swap;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		for(int i = leftIndex; i < rightIndex; i++){

			int scout = i;

			for(int j = i + 1; j < array.length; j++){
				if(array[j].compareTo(array[scout]) < 0){
					scout = j;
				}
				


			}
			swap(array, scout, i);

		}

	}
}

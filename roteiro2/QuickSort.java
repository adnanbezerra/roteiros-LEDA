package sorting.divideAndConquer;

import sorting.AbstractSorting;

import static util.Util.swap;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 1)
			return;

		if (leftIndex < rightIndex){
			int index_pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, index_pivot - 1);
			sort(array, index_pivot + 1, rightIndex);
		}

	}

	private int partition(T[] values, int leftIndex, int rightIndex){

		int pivot = (int) values[leftIndex];
		int i = leftIndex;

		// parte responsável por fazer as comparações dentro do array
		for (int j = leftIndex + 1; j <= rightIndex; j++){
			if ( (int) values[j] <= pivot){
				i++;
				swap(values, i, j);
			}
		}

		// realiza a troca entre o pivot e o último índice
		swap(values, leftIndex, i);

		return i;
	}
}

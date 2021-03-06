package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= rightIndex)
			return;

		else {
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);

			array = merge(array, leftIndex, middle, rightIndex);
		}

	}

	private T[] merge(T[] array, int left, int middle, int right){

		T[] result = (T[]) new Comparable[array.length];

		// esta primeira parte é responsabilizada por criar um array auxiliar que está entre os índices laterais
//		int[] helper = new int[array.length];
		for(int i = left; i <= right; i++) {
			result[i] = array[i]; 
		}

		int i = left;
		int j = middle + 1;
		int k = left;

		// é responsável pela rotina do merge de fato, une os dois arrays em um ordenado
		while ( i <= middle && j <= right ){

			if (result[i].compareTo(result[j]) < 0) {

				array[k] = result[i];
				i++;

			} else {
				array[k] = result[j];
				j++;
			}
			k++;

		}

		// faz o append para o caso da metade inicial não ter sido toda consumida
		while (i <= middle){
			array[k] = result[i];
			i++;
			k++;
		}

		// faz o append da metade final, para o caso desta não ter sido toda consumida ainda
		while (j <= right) {
			array[k] = result[j];
			j++;
			k++;
		}

		return result;
	}
}

package sorting.divideAndConquer.hybridMergesort;

import static util.Util.swap;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.length <= SIZE_LIMIT){
			quickSort(array, leftIndex, rightIndex);
			
		} else {
			mergeSort(array, leftIndex, rightIndex);
		}
	}

	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
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

	private void quickSort(T[] array, int leftIndex, int rightIndex) {

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

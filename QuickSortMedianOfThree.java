package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 1)
			return;
	
		if (leftIndex < rightIndex){
			int index_pivot = partition (array, leftIndex, rightIndex);
			sort(array, leftIndex, index_pivot - 1);
			sort(array, index_pivot + 1, rightIndex);
		}
		
	}
		
	private int partition (T[] values, int leftIndex, int rightIndex) {
	
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

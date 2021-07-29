package sorting.divideAndConquer.quicksort3;

import static util.Util.swap;

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
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length == 1 || array.length == 0)
			return;
		
		if (leftIndex < rightIndex){
			int index_pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, index_pivot - 1);
			sort(array, index_pivot + 1, rightIndex);
		}	
	}
		
	private int partition(T[] values, int leftIndex, int rightIndex){

		// primeiro, comparamos o valor central com os dos lados e os organizamos no array, escolhendo 
		// o pivot a partir do elemento central.
		
		int pivot = organizaPivot(values, leftIndex, rightIndex);
		int i = rightIndex - 1;

		// põe o pivot no penúltimo item, conforme requisitado
		swap(values, pivot, rightIndex - 1);
		
		// parte responsável por fazer as comparações dentro do vetor menor, de values[left+1] até A[right-1]
		for (int j = i - 1; j >= leftIndex + 1; j--){
			if (values[j].compareTo(values[pivot]) >= 0){
				i--;
				swap(values, i, j);
			}
		}

		// agora põe o pivot em seu lugar de direito no array
		swap(values, pivot, i);
		
		return i;
	}

	private int organizaPivot(T[] values, int leftIndex, int rightIndex){

		int center = (leftIndex + rightIndex) / 2;

		// este array registra os índices a serem usados nos laços a seguir
		int[] auxilio = {leftIndex, center, rightIndex};

		// selection sort responsável por organizar o array da entrada na ordem desejada, ou seja,
		// de modo que values[left] < values[center] < values[right]
		for (int i = 0; i < auxilio.length; i++){
			int scout = i;
			for(int j = 1; i < auxilio.length; i++) {
				if (values[j].compareTo(values[scout]) > 0){
					scout = j;
				}
			}
			swap(values, i, scout);
		}

		// determina e retorna o índice do novo center para o sistema
		return ((leftIndex + rightIndex) / 2);
	}
}

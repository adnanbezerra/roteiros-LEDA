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
			if (values[j].compareTo(values[rightIndex - 1]) >= 0){
				i--;
				swap(values, i, j);
			}
		}

		// agora põe o pivot em seu lugar de direito no array
		swap(values, i, rightIndex - 1);
		
		return i;
	}

	private int organizaPivot(T[] values, int leftIndex, int rightIndex){

		int center = (leftIndex + rightIndex) / 2;

		// este array registra os índices a serem usados nos laços a seguir
		T[] auxilio = (T[]) new Comparable[] {values[leftIndex], values[center], values[rightIndex]};

		// para o caso do elemento do índice 0 do array auxiliar for o maior
		if (auxilio[0].compareTo(auxilio[1]) >= 0 && auxilio[0].compareTo(auxilio[2]) >= 0) {
			swap(auxilio, 0, 2);
			if (auxilio[0].compareTo(auxilio[1]) >= 0) {
				swap(auxilio, 1, 0);
			}
		}

		// O elemento do índice 1 do array é o maior dos três elementos.
		else if (auxilio[1].compareTo(auxilio[0]) >= 0 && auxilio[1].compareTo(auxilio[2]) >= 0) {
			swap(auxilio, 1, 2);
			if (auxilio[0].compareTo(auxilio[1]) >= 0) {
				swap(auxilio, 1, 0);
			}
		}

		// O elemento do índice 2 do array é o maior dos três elementos.
		else {
			if (auxilio[0].compareTo(auxilio[1]) >= 0) {
				swap(auxilio, 1, 0);
			}
		}

        values[leftIndex] = auxilio[0];
        values[center] = auxilio[1];
        values[rightIndex] = auxilio[2];

		// determina e retorna o índice do novo center para o sistema
		return ((leftIndex + rightIndex) / 2);
	}
}
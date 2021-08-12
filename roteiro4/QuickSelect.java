package orderStatistic;
import static util.Util.swap;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 * 
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 * 
 * @author Adalberto
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calclar o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes baseado no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contém o k-ésimo menor
	 * elemento). Isso reduz a completixade de O(n.log n) para O(n).
	 * 
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 * 
	 * 
	 * @param array
	 *            o array de dados a procurar o k-esimo menor elemento.
	 * @param k
	 *            a ordem do elemento desejado. 1 significa primeiro menor
	 *            elemento, 2 significa segundo menor elemento e assim por
	 *            diante
	 * @return
	 */
	public T quickSelect(T[] array, int k) {
		
		// Esta estrutura permite o teste de todos os casos de erro enunciados; Se o
		// array for inválido ou se o retorno for inválido, o retorno é null.
		if(array.length > 0 && k > 0 && k <= array.length) {
			return recursiveQuickSelect(array, k, 0, array.length - 1);
		}
		
		return null;	

	}

	private T recursiveQuickSelect(T[] array,int k, int leftIndex, int rightIndex) {
		
		// Aciona o algoritmo de forma recursiva. É interessante observar que ele só ocorre
		// numa metade do array, a que tiver o k menor que o pivot, e não nele todo.
		if(leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			int pivotIndex = particiona(array,leftIndex,rightIndex );

			if (k < pivotIndex + 1) {
				return recursiveQuickSelect(array,k,leftIndex, rightIndex - 1);
			} else if (k > pivotIndex + 1) {
				return recursiveQuickSelect(array,k,pivotIndex + 1, rightIndex);
			}

			return array[pivotIndex];
		}

		return array[k - 1];

	}

	private int particiona (T [] array, int inicio, int fim) {
		
		// Isso é um merge sort comum com particionamento por mediana de três
		int meio = (inicio + fim)/2;
		mediaDeTres(array, inicio, meio, fim);
		T pivot = array[meio];
		swap(array, meio, fim-1);
		int pivotIndex = fim - 1;
		
		for(int j = pivotIndex-1; j > inicio;j-- ) {
			if(pivot.compareTo(array[j]) < 0) {
				pivotIndex--;
				swap(array, pivotIndex, j);
			}
		}
		swap(array, fim-1, pivotIndex);
		
		return pivotIndex;
	}
	
	private void mediaDeTres(T[] array, int leftIndex, int middleIndex, int rightIndex) {

        if (array[leftIndex].compareTo(array[middleIndex]) > 0)
            swap(array, leftIndex, middleIndex);

        if (array[leftIndex].compareTo(array[rightIndex]) > 0)
            swap(array, leftIndex, rightIndex);

        if (array[middleIndex].compareTo(array[rightIndex]) > 0)
            swap(array, middleIndex, rightIndex);

	}

}

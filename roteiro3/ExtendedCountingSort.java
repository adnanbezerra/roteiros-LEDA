package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(array.length <= 0)
			return;
		if(rightIndex > array.length || rightIndex < 0)
			return;

		// estrutura responsável por determinar qual o maior elemento do array de entrada a fim de criar o auxiliar C
		int maior = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++){
			if(array[i] > maior)
				maior = array[i];
		}

		// esta estrutura faz o mesmo que a anterior, mas detecta os valores menores ao invés de maiores
		int menor = array[leftIndex];
		for(int i = leftIndex; i<= rightIndex; i++){
			if(array[i] < menor)
			menor = array[i];
		}

        int[] C = new int[maior - menor + 1];

        // estrutura que conta a frequência em que um índice aparece
        for (int i = leftIndex; i <= rightIndex; i++) {
            C[array[i] - menor] += 1;
        }
        
        // agora faz a contagem acumulativa no array auxiliar C
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }

        int[] B = new int[rightIndex - leftIndex + 1];

        for (int i = rightIndex; i >= leftIndex; i--) {
            B[C[array[i] - menor] - 1] = array[i];
            C[array[i] - menor] -= 1;
        }

        int j = 0;
		for(int i = leftIndex; i <= rightIndex; i++){
			array[i] = B[j];
			j++;
		}
    

	}

}

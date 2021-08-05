package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(array.length <= 0)
			return;

		// estrutura responsável por determinar qual o maior elemento do array de entrada a fim de criar o auxiliar C
		int maior = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++){
			if(array[i] > maior)
				maior = array[i];
		}
        int[] C = new int[maior + 1];

        // estrutura que conta a frequência em que um índice aparece
        for (int i = leftIndex; i <= rightIndex; i++) {
            C[array[i]] += 1;
        }
        
        // agora faz a contagem acumulativa no array auxiliar C
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }

        int[] B = new int[rightIndex - leftIndex + 1];

        for (int i = rightIndex; i >= leftIndex; i--) {
            B[C[array[i]] - 1] = array[i];
            C[array[i]] -= 1;
        }

        int j = 0;
		for(int i = leftIndex; i <= rightIndex; i++){
			array[i] = B[j];
			j++;
		}
    
	}

}

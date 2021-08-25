package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return(this.head == null);
	}

	@Override
	public int size() {
		int i = 0;
		SingleLinkedListNode<T> aux = this.head;
		while(aux != null){
			i++;
			aux = aux.next;
		}

		return i;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = this.head;

		while(aux != null){
			if(aux.equals(element)) return aux.data;
			aux = aux.next;
		}

		return null;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = this.head;

		while(aux.next != null){
			if(aux.next == null){
				SingleLinkedListNode<T> novo = new SingleLinkedListNode<T>(element, null);
				aux.next = novo;
				return;
			}
			aux = aux.next;
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		SingleLinkedListNode<T> aux = this.head;
		T[] saida = (T[]) new Object[this.size()];
		int i = 0;

		while(aux != null){
			saida[i] = aux.data;
			i++;
			aux = aux.next;
		}

		return saida;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}

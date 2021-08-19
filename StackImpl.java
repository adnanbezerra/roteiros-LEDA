package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		if(array.length == 0) return true;
		else return false;
	}

	@Override
	public boolean isFull() {
		if(array.length == top) return true;
		else return false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		try{
			array[top] = element;
			top++;
		} catch (Exception e) {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()) throw new StackUnderflowException();
		else{
			T retorno = array[top];
			array[top] = null;
			top--;
			return retorno;
		}
	}

}

package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (stack1.isFull() || stack2.isFull()) throw new QueueOverflowException();

		while(!stack1.isEmpty()){
			try {
				T temp = null;
				try {
					temp = stack1.pop();
				} catch (StackUnderflowException e) { }
				stack2.push(temp);
			} catch (StackOverflowException e) { }
		}

		try{
			stack1.push(element);
		} catch(StackOverflowException e) { }

		while(!stack2.isEmpty()){
			try{
				T temp = null;
				try {
					temp = stack2.pop();
				} catch (StackUnderflowException e) { }
				stack1.push(temp);
			} catch (StackOverflowException e) { }
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (stack1.isEmpty()) throw new QueueUnderflowException();

		T retorno = stack1.top();

		try{
			stack1.pop();
		} catch (StackUnderflowException e) { }

		return retorno;
	}

	@Override
	public T head() {
		if(stack1.isEmpty()){
			return stack2.top();
		} else {
			return stack1.top();
		}
	}

	@Override
	public boolean isEmpty() {
		return (stack1.isEmpty());
	}

	@Override
	public boolean isFull() {
		return (stack1.isFull() && stack2.isFull());
	}

}

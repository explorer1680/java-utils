package personal.queue;

public class LinkedObject<T> {
	
	private T obj;
	
	private LinkedObject<T> prev;
	
	private LinkedObject<T> next;
	
	public LinkedObject(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public LinkedObject<T> getPrev() {
		return prev;
	}

	public void setPrev(LinkedObject<T> prev) {
		this.prev = prev;
	}

	public LinkedObject<T> getNext() {
		return next;
	}

	public void setNext(LinkedObject<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "LinkedObject [obj=" + obj + "]";
	}
	
	
}

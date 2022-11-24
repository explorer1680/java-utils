package interview;

public class InterViewQueue<T> {
	
	private LinkedObject<T> head;
	
	private LinkedObject<T> tail;
	
	public void push(T t) {
		LinkedObject<T> lo = new LinkedObject<>(t);
		if(head == null) {
			head = lo;
			tail = lo;
		}else {
			head.setPrev(lo);
			head = lo;
		}

	}

	public LinkedObject<T> pop() {
		LinkedObject<T> last = tail;
		tail = tail.getPrev();
		return last;
	}

	public LinkedObject<T> getHead() {
		return head;
	}

	public void setHead(LinkedObject<T> head) {
		this.head = head;
	}

	public LinkedObject<T> getTail() {
		return tail;
	}

	public void setTail(LinkedObject<T> tail) {
		this.tail = tail;
	}
}

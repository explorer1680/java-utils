package personal.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventOverlap {
	public static void main(String[] args) {

		Event event1 = new Event(1, 5);
		Event event2 = new Event(2, 7);
		Event event3 = new Event(4, 5);
		Event event4 = new Event(7, 15);

		List<Event> eventList = new ArrayList<>();

		eventList.add(event1);
		eventList.add(event2);
		eventList.add(event3);
		eventList.add(event4);

		List<Event> tempList = new ArrayList<>(eventList);

		List<Pair> pairList = new ArrayList<>();

		for (Event e : eventList) {
			tempList.remove(e);
			List<Pair> tempPairList = tempList.stream()
					.filter(p -> (p.getStart() > e.getStart() && p.getStart() < e.getEnd())
							|| (p.getEnd() > e.getStart() && p.getEnd() < e.getEnd()))
					.map(p -> new Pair(e, p)).collect(Collectors.toCollection(() -> pairList));
//			pairList.addAll(tempPairList);
		}
		pairList.stream().forEach(System.out::println);
	}
}

class Event {
	private int start;
	private int end;

	public Event(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return "Event [start=" + start + ", end=" + end + "]";
	}

}

class Pair {
	private Event first;
	private Event second;

	public Pair(Event first, Event second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
}
package personal.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TreeStructure {
	static List<Note> list = new ArrayList<>();

	public static void main(String[] args) {

		Note n10 = new Note(10, null, null);
		Note n9 = new Note(9, null, null);
		Note n8 = new Note(8, null, null);
		Note n7 = new Note(7, n9, n10);
		Note n6 = new Note(6, null, null);
		Note n5 = new Note(5, null, n8);
		Note n4 = new Note(4, n6, n7);
		Note n3 = new Note(3, null, null);
		Note n2 = new Note(2, n4, n5);
		Note n1 = new Note(1, n2, n3);

		getAllNotesOnList(n1);
		System.out.println(getAllNotesOnList(n1).stream().sorted(Comparator.comparing(Note::getNumber, new NoteComparator()))
				.collect(Collectors.toList()));
		System.out.println(getAllNotesOnList(n1).stream().sorted(Comparator.comparing(Note::getNumber, new  Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		}))
				.collect(Collectors.toList()));
		// System.out.print(TreeStructure.list);
	}

	// static void getAllNotesOnList(Note note) {
	// if (note.getLeft() != null) {
	// getAllNotesOnList(note.getLeft());
	// TreeStructure.list.add(note.getLeft());
	// }
	// if (note.getRight() != null) {
	// getAllNotesOnList(note.getRight());
	// TreeStructure.list.add(note.getRight());
	// }
	// return;
	// }

	static List<Note> getAllNotesOnList(Note note) {
		List<Note> totalList = new ArrayList<>();
		List<Note> leftList = new ArrayList<>();
		List<Note> rightList = new ArrayList<>();

		if (note.getLeft() != null) {
			leftList = getAllNotesOnList(note.getLeft());
		}
		if (note.getRight() != null) {
			rightList = getAllNotesOnList(note.getRight());
		}
		totalList.add(note);
		totalList.addAll(leftList);
		totalList.addAll(rightList);
		return totalList;
	}
}

class NoteComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return 0 - (o1 - o2);
	}
}

class Note {
	int number;
	Note left;
	Note right;

	public Note(int number, Note left, Note right) {
		super();
		this.number = number;
		this.left = left;
		this.right = right;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Note getLeft() {
		return left;
	}

	public void setLeft(Note left) {
		this.left = left;
	}

	public Note getRight() {
		return right;
	}

	public void setRight(Note right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Note [number=" + number + "]";
	}
}
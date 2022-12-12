package questions.linkedListHasACircle;

import java.util.Objects;

public class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        LinkedListNode that = (LinkedListNode) o;
//
//        if (value != that.value) return false;
//        return Objects.equals(next, that.next);
//    }

//    @Override
//    public int hashCode() {
//        int result = value;
//        result = 31 * result + (next != null ? next.hashCode() : 0);
//        return result;
//    }
}

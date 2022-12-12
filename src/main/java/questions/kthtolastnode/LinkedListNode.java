package questions.kthtolastnode;

public class LinkedListNode {
    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "value='" + value + '\'' +
                '}';
    }
}

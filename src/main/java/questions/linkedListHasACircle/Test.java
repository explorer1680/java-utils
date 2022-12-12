package questions.linkedListHasACircle;

import java.util.HashSet;

public class Test {

    public static void main(String[] args){
        LinkedListNode linkedListNode1 = new LinkedListNode(1);
        LinkedListNode linkedListNode2 = new LinkedListNode(2);
        LinkedListNode linkedListNode3 = new LinkedListNode(3);
        LinkedListNode linkedListNode4 = new LinkedListNode(4);
        LinkedListNode linkedListNode5 = new LinkedListNode(5);
        LinkedListNode linkedListNode6 = new LinkedListNode(6);
        LinkedListNode linkedListNode7 = new LinkedListNode(7);
        LinkedListNode linkedListNode8 = new LinkedListNode(8);
        LinkedListNode linkedListNode9 = new LinkedListNode(9);

        linkedListNode1.next = linkedListNode2;
        linkedListNode2.next = linkedListNode3;
        linkedListNode3.next = linkedListNode4;
        linkedListNode4.next = linkedListNode5;
        linkedListNode5.next = linkedListNode6;
        linkedListNode6.next = linkedListNode7;
        linkedListNode7.next = linkedListNode8;
        linkedListNode8.next = linkedListNode4;

        HashSet<LinkedListNode> hashSet = new HashSet<>();

        LinkedListNode currentNode = linkedListNode1;
        hashSet.add(currentNode);

        boolean isCircled = false;
        while(true){
            LinkedListNode nextNode = currentNode.next;
            if(nextNode == null){
                break;
            }
            if(hashSet.contains(nextNode)){
                isCircled = true;
                break;
            }

            currentNode = nextNode;
            hashSet.add(currentNode);
        }

        System.out.println(isCircled);

    }
}

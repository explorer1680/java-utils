package questions.kthtolastnode;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args){
        LinkedListNode a = new LinkedListNode("Angel Food");
        LinkedListNode b = new LinkedListNode("Bundt");
        LinkedListNode c = new LinkedListNode("Cheese");
        LinkedListNode d = new LinkedListNode("Devil's Food");
        LinkedListNode e = new LinkedListNode("Eccles");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Solution.getKthToLast(2, a);
    }

    public static void getKthToLast(int num, LinkedListNode node){
        Deque<LinkedListNode> deque = new LinkedList<>();
        while(node != null){
            deque.push(node);
            node = node.next;
        }

        System.out.println(((List)deque).get(1));

    }

}

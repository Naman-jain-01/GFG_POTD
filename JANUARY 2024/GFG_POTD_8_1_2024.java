

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
class GfG {
    static Node addToBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    Node mergeResult(Node node1, Node node2) {
        Node mergedList = null;
        Node temp;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                temp = node1.next;
                node1.next = mergedList;
                mergedList = node1;
                node1 = temp;
            } else {
                temp = node2.next;
                node2.next = mergedList;
                mergedList = node2;
                node2 = temp;
            }
        }

        // Add remaining nodes of node1 to the merged list
        while (node1 != null) {
            temp = node1.next;
            node1.next = mergedList;
            mergedList = node1;
            node1 = temp;
        }

        // Add remaining nodes of node2 to the merged list
        while (node2 != null) {
            temp = node2.next;
            node2.next = mergedList;
            mergedList = node2;
            node2 = temp;
        }

        return mergedList;
    }
}


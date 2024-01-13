package JANUARY;

class Solution13 {
    public static Node insertionSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node sortedHead = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;

            if (sortedHead == null || sortedHead.data > current.data) {
                current.next = sortedHead;
                sortedHead = current;
            } else {
                Node currentSorted = sortedHead;

                while (currentSorted.next != null && currentSorted.next.data < current.data) {
                    currentSorted = currentSorted.next;
                }

                current.next = currentSorted.next;
                currentSorted.next = current;
            }

            current = nextNode;
        }

        return sortedHead;
    }
}


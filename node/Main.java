package node;

class Main {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(4);
        Node node2 = new Node(6);
        Node node3 = new Node(8);
        Node node4 = new Node(1);

        node1.next = node2;
        node1.prev = node4;

        node2.next = node3;
        node2.prev = node1;

        node3.next = node4;
        node3.prev = node2;

        node4.next = node1;
        node4.prev = node3;

        Node currentNode = node4;
        do {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.prev;
        } while (currentNode != node4);

        System.out.println("Reversed order");

        Node currentNode2 = node1;
        do {
            System.out.print(currentNode2.data + " -> ");
            currentNode2 = currentNode2.next;
        } while (currentNode2 != node1);

        // remove node 3
        node2.next = node4;
        node4.prev = node2;


        System.out.println();

        Node currentNode3 = node4;
        do {
            System.out.print(currentNode3.data + " -> ");
            currentNode3 = currentNode3.prev;
        } while (currentNode3 != node4);

        System.out.println("Reversed order");

        Node currentNode4 = node1;
        do {
            System.out.print(currentNode4.data + " -> ");
            currentNode4 = currentNode4.next;
        } while (currentNode4 != node1);

        // insert new node 4 6 1 -> 4 6 99 1
        Node node5 = new Node(99);
        node2.next = node5;
        node4.prev = node5;

        node5.prev = node2;
        node5.next = node4;

        System.out.println();


        Node currentNode5 = node4;
        do {
            System.out.print(currentNode5.data + " -> ");
            currentNode5 = currentNode5.prev;
        } while (currentNode5 != node4);

        System.out.println("Reversed order");

        Node currentNode6 = node1;
        do {
            System.out.print(currentNode6.data + " -> ");
            currentNode6 = currentNode6.next;
        } while (currentNode6 != node1);

    }
}

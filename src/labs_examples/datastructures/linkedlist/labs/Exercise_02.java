package labs_examples.datastructures.linkedlist.labs;

/*      LinkedLists - Exercise_02
 *
 *      Write your own custom LinkedList class. Although it can mimic the CustomLinkedList
 *      class we used here, it must be entirely unique. Please also add at least two
 *      additional helper methods that you think could be useful. Refer to Java's built-in
 *      LinkedList class for inspiration. Your new LinkedList class should ONLY allow users
 *      to add and remove elements from the front of the list AND the end of the list.
 *      Also, instead of using the index in the get() and remove() methods, these methods should
 *      get() and remove() based by the Node's value, not it's index.
 */
public class Exercise_02 {
    public static void main(String[] args) {
        // Create object
        KustomLinkedList<Object> kustomLinkedList = new KustomLinkedList<>();
        // add and remove elements from the front of the list
        kustomLinkedList.insertAtHead(7);
        kustomLinkedList.insertAtHead(6);
        // AND the end of the list
        kustomLinkedList.insertAtTail(1);
        kustomLinkedList.insertAtTail(2);
        // get() and remove() based by the Node's value, not it's index.
        System.out.println("The index of 7: " + kustomLinkedList.getIndexOf(7));
        System.out.println("The index of 1: " + kustomLinkedList.getIndexOf(1));
        kustomLinkedList.remove(6);


        System.out.println(kustomLinkedList.toString());
    }
}

// Here's my custom node
class kustomNode {
    // Each has an integer value
    private int data;
    // and it knows what the next node is.
    private kustomNode nextKustomNode;  // Default is null.

    // Constructor (make this node with an integer passed in)
    public kustomNode(int data) {
        this.data = data;
    }

    // Getters & Setters for the data and the next node
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public kustomNode getNextKustomNode() {
        return nextKustomNode;
    }

    public void setNextKustomNode(kustomNode nextKustomNode) {
        this.nextKustomNode = nextKustomNode;
    }
}

class KustomLinkedList<T> {
    // A LinkedList will always have a head node
    private kustomNode head;  // Defaults to null.

    // An empty constructor to create the object
    public KustomLinkedList() {
    }

    // Other methods
    // Add a new node to the end of the LinkedList
    public void insertAtTail(int data) {
        kustomNode newNode = new kustomNode(data);
        if (this.head == null) {
            head = newNode;
        } else {
            kustomNode currentKustomNode = head;
            while (currentKustomNode.getNextKustomNode() != null) {
                currentKustomNode = currentKustomNode.getNextKustomNode();
            }
            currentKustomNode.setNextKustomNode(newNode);
        }
    }

    // Add a new node to the head of the LinkedList
    public void insertAtHead(int data) {
        kustomNode newNode = new kustomNode(data);
        newNode.setNextKustomNode(head);
        head = newNode;
    }

    // Get index of node at value
    public int getIndexOf(int data) {
        int counter = 0;
        kustomNode iteration = head;
        while (iteration != null) {
            if (iteration.getData() == data) {
                return counter;
            } else {
                iteration = iteration.getNextKustomNode();
                counter++;
            }
        }
        return -1;
    }

    // Remove node at value
    public void remove(int data) {
        kustomNode currentNode = head;
        kustomNode previousNode = null;
//        int sizeOfList = this.listSize();
        while (currentNode != null) {  // Is there a better way than all of these if/else statements?
            // I thought this might be simpler, but turned out to be more complicated.
//            if (currentNode.getData() == data) {
//                switch (this.listSize()) {
//                    case 1:
//                        head = null;
//                        break;
//                    case 2:
//                        if (currentNode == head) {
//                            head = head.getNextKustomNode();
//                            break;
//                        } else {
//                            head.setNextKustomNode(null);
//                            break;
//                        }
//                    default:
//                        if (currentNode.getNextKustomNode() == null) {
//                            if (previousNode != null) {
//                                previousNode.setNextKustomNode(null);
//                            }
//                            break;
//                        } else {
//                            if (previousNode != null) {
//                                previousNode.setNextKustomNode(currentNode.getNextKustomNode());
//                            }
//                            break;
//                        }
//                }
//            }
//            previousNode = currentNode;
//            currentNode = currentNode.getNextKustomNode();


            if (currentNode.getData() == data) {
                if (currentNode == head && head.getNextKustomNode() == null) {  // If it's a single node list
                    head = null;  // then remove the head by setting it to null.
                    break;
                } else if (currentNode == head) {  // If there's more than one element and the node to delete is the head
                    head = head.getNextKustomNode();  // then reset the head's next node.
                    break;
                } else if (currentNode.getNextKustomNode() == null) {  // If the matching node is the last element
                    if (previousNode != null) {
                        previousNode.setNextKustomNode(null);  // then just set the previous node's next node to null.
                    }
                    break;
                } else {  // In all other cases
                    if (previousNode != null) {
                        previousNode.setNextKustomNode(currentNode.getNextKustomNode());  // connect the previous and next nodes.
                    }
                    break;
                }
            } else {
                previousNode = currentNode;
                currentNode = currentNode.getNextKustomNode();
            }
        }
    }

    public int listSize() {
        kustomNode iterator = head;
        int counter = 0;
        while (iterator != null) {
            counter++;
            iterator = iterator.getNextKustomNode();
        }
        return counter;
    }

    // ToString
    @Override
    public String toString() {
        kustomNode node = head;
        StringBuilder outString = new StringBuilder("kustomLinkedList: ");
        while (node != null) {
            outString.append(node.getData());
            outString.append(" ");
            node = node.getNextKustomNode();
        }
        return outString.toString();
    }
}
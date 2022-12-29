package labs_examples.datastructures.linkedlist.labs;

/*      LinkedLists - Exercise_02
 *      Please create your own custom doubly-LinkedList from start to finish :) You got this!
 */
public class Exercise_03 {
    public static void main(String[] args) {
        // Create object
        KustomDLList<Object> kustomDLList = new KustomDLList<>();
        // add and remove elements from the front of the list
        kustomDLList.insertAtHead(17);
        kustomDLList.insertAtHead(16);
        // AND the end of the list
        kustomDLList.insertAtTail(11);
        kustomDLList.insertAtTail(12);
        System.out.println(kustomDLList.toString());

        // get() and remove() based by the Node's value, not it's index.
        System.out.println("The index of 17: " + kustomDLList.getIndexOf(17));
        System.out.println("The index of 11: " + kustomDLList.getIndexOf(11));
        kustomDLList.remove(16);

        System.out.println(kustomDLList.toString());
    }
}

// Here's my custom node
class kustomDLLNode {
    // Each has an integer value
    private int data;
    // and it knows what the next node is.
    private kustomDLLNode nextKustomDLLNode;  // Default is null, I think.
    // And what the previous node is.
    private kustomDLLNode previousKustomDllNode;

    // Constructor (make this node with an integer passed in)
    public kustomDLLNode(int data) {
        this.data = data;
    }

    // Getters & Setters for the data and the next node
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public kustomDLLNode getNextKustomDLLNode() {
        return nextKustomDLLNode;
    }

    public void setNextKustomDLLNode(kustomDLLNode nextKustomDLLNode) {
        this.nextKustomDLLNode = nextKustomDLLNode;
    }

    public kustomDLLNode getPreviousKustomDllNode() {
        return previousKustomDllNode;
    }

    public void setPreviousKustomDllNode(kustomDLLNode previousKustomDllNode) {
        this.previousKustomDllNode = previousKustomDllNode;
    }
}

class KustomDLList<T> {
    // A LinkedList will always have a head node
    private kustomDLLNode head;  // Defaults to null.
    private kustomDLLNode tail;

    // An empty constructor to create the object
    public KustomDLList() {
    }

    // Other methods
    // Add a new node to the end of the LinkedList
    public void insertAtTail(int data) {
        kustomDLLNode newNode = new kustomDLLNode(data);
        if (this.head == null) {
            head = newNode;
        } else {
            tail.setNextKustomDLLNode(newNode);
            newNode.setPreviousKustomDllNode(tail);
            tail = newNode;
        }
    }

    // Add a new node to the head of the LinkedList
    public void insertAtHead(int data) {
        kustomDLLNode newNode = new kustomDLLNode(data);
        newNode.setNextKustomDLLNode(head);
        if (head != null){
            head.setPreviousKustomDllNode(newNode);
            tail = head;
        }
        head = newNode;
    }

    // Get index of node at value
    public int getIndexOf(int data) {
        int counter = 0;
        kustomDLLNode iteration = head;
        while (iteration != null) {
            if (iteration.getData() == data) {
                return counter;
            } else {
                iteration = iteration.getNextKustomDLLNode();
                counter++;
            }
        }
        return -1;  // If the value is not found.
    }

    // Remove node at value
    public void remove(int data) {
        kustomDLLNode currentNode = head;
        while (currentNode != null) {  // Is there a better way than all of these if/else statements?
            if (currentNode.getData() == data) {
                if (currentNode == head && head.getNextKustomDLLNode() == null) {  // If it's a single node list
                    head = null;  // then remove the head by setting it to null.
                    break;
                } else if (currentNode == head) {  // If there's more than one element and the node to delete is the head
                    head.getNextKustomDLLNode().setPreviousKustomDllNode(null);  // Set the second element's previous node to null.
                    head = head.getNextKustomDLLNode();  // then reset the head's next node.
                    break;
                } else if (currentNode.getNextKustomDLLNode() == null) {  // If the matching node is the last element
                        currentNode.getPreviousKustomDllNode().setNextKustomDLLNode(null);
                    break;
                } else {  // In all other cases
                        currentNode.getPreviousKustomDllNode().setNextKustomDLLNode(currentNode.getNextKustomDLLNode());
                        currentNode.getNextKustomDLLNode().setPreviousKustomDllNode(null); // And set the following node's previous node to null.
                    break;
                }
            } else {
                currentNode = currentNode.getNextKustomDLLNode();
            }
        }
    }

    public int listSize() {
        kustomDLLNode iterator = head;
        int counter = 0;
        while (iterator != null) {
            counter++;
            iterator = iterator.getNextKustomDLLNode();
        }
        return counter;
    }

    // ToString
    @Override
    public String toString() {
        kustomDLLNode node = head;
        StringBuilder outString = new StringBuilder("kustomDLList: ");
        while (node != null) {
            outString.append(node.getData());
            outString.append(" ");
            node = node.getNextKustomDLLNode();
        }
        return outString.toString();
    }
}
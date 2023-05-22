public class Node<E>{
    private final E element; // reference to the element stored at this node
    private Node<E> prev; // reference to te previous node in the list
    private Node<E> next; // reference to the next node in the list

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
    // setters & getters
    public E getElement() { return element; }
    public Node<E> getPrev() { return prev; }
    public Node<E> getNext() { return next; }
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


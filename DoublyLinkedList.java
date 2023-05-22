public class DoublyLinkedList<E extends Comparable<E> >{
    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        this.header = new Node<>(null, null, null); // create header - trailer not defined yet
        this.trailer = new Node<>(null, header, null); // trailer is preceded by header // previous is header
        this.header.setNext(trailer); // header is followed by trailer // next node in list // this means linked list is empty since header.next = trailer
        this.size = 0; // starting size is 0
    }

    public int size() {
        return size;
    }
    public boolean isEmpty( ) {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) { // first checks to make sure that the doubly linked list isn't empty --> proceeds if not empty
            return null;
        } else {
            return header.getNext().getElement(); // first element is beyond header // first returning header, then the element after the header, so we do .getElement to find out what that element is
        }
    }

    /**
     * last method returns the last element of the list (element before the trailer)
     * @return the last element of the list (element before the trailer)
     */
    public E last() {
        if(isEmpty()){ // checks to make sure double linked list isn't empty
            return null;
        }
        return trailer.getPrev().getElement(); // last element is before trailer // going from back
    }

    /**
     * addBetween method adds an element in between the two elements given in the parameter (predecessor & successor)
     * @param element
     * @param predecessor
     * @param successor
     */
    public void addBetween(E element, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<E>(element, predecessor, successor); // creates new node
        predecessor.setNext(newest); // sets the new node between predecessor & successor - does this from both sides
        successor.setPrev(newest);
        size++; // size increases by 1 once it adds the new node
    }

    /**
     * remove method takes out a node from the list
     * @param node
     * @return
     */
    public E remove(Node<E> node){ //
        Node<E> predecessor = node.getPrev(); // retrieves the node before (predecessor)
        Node<E> successor = node.getNext(); // retrieves the node after (successor)
        predecessor.setNext(successor); // sets the successor as the next node after predecessor
        successor.setPrev(predecessor); // sets the predecessor as the previous node before the successor
        size--; // size decreases by 1 since node was removed
        return node.getElement(); // returns the node element
    }

    /**
     * addFirst adds an element at the beginning of the node list (right after the header)
     * @param element
     */
    public void addFirst(E element) {
        addBetween(element, header, header.getNext()); // place node just after the header
    }

    /**
     * addLast adds an element at the end of the node list (right before the trailer)
     * @param element
     */
    public void addLast(E element){
        addBetween(element, trailer.getPrev(), trailer); // place node just before the trailer
    }

    /**
     * removeFirst removes the first element
     * @return
     */
    public E removeFirst(){
        if(isEmpty()) return null; // nothing to remove
        return remove(header.getNext()); // first element is beyond header
    }

    /**
     * removeLast removes the last element
     * @return
     */
    public E removeLast() {
        if(isEmpty()) return null; // nothing to remove
        return remove(trailer.getPrev()); // last element is before trailer
    }

    // setters and getters
    public Node<E> getHeader() {
        return header;
    }
    public void setHeader(Node<E> header) {
        this.header = header;
    }
    public Node<E> getTrailer() {
        return trailer;
    }
    public void setTrailer(Node<E> trailer) {
        this.trailer = trailer;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * takes a generic element and inserts it within a given list by its compareTo function
     * which for this program is just comparing dates
     */
    public void insertByDate(E input) {
        if (this.isEmpty()) {
            this.addFirst(input); //adds the object to the list if empty
        } else {
            Node<E> curr = header.getNext();

            while (input.compareTo(curr.getElement()) < 0) {
                curr = curr.getNext();

                if (curr.getElement() == null) {
                    this.addLast(input);
                    size++;
                    return;
                }
            }
            this.addBetween(input, curr.getPrev(), curr);

            size++;
        }
    }

    public String toString() {
        Node<E> curr = header.getNext();
        String str = curr.toString();
        while (curr.getNext() != trailer){
            curr = curr.getNext();
            str = str + "\n\n" + curr.toString();
        }
        return str;
    }
}
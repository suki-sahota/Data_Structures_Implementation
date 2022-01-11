/**
 * Author: Suki Sahota
 */
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class MyLimitedLinkedList<T> implements MyList<T> {
    private Class dataType; // The type of data we have in our Linked List
    private boolean first;  // True until Linked List adds its first element
    private MyNode<T> dummyHead;
    private MyNode<T> dummyTail;
    private int sz;

    // No-argument constructor
    public MyLimitedLinkedList() {
        first = true;
        sz = 0;
        dummyHead = new MyNode<>();
        dummyTail = new MyNode<>();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public boolean add(T element) {
        if (first) {
            dataType = element.getClass();
            first = false;
        }
        if (element.getClass() != dataType) {
            throw new InputMismatchException("Type missmatch");
        }

        MyNode<T> tempNode = new MyNode<T>(element);
        tempNode.prev = dummyTail.prev;
        tempNode.next = dummyTail;

        dummyTail.prev.next = tempNode;
        dummyTail.prev = tempNode;
        ++sz;
        return true; // (as specified by Collection.add(E))
    }

    public void add(int index, T element) {
        if (index < 0 || sz < index) {
            throw new IndexOutOfBoundsException();
        }
        if (first) {
            dataType = element.getClass();
            first = false;
        }
        if (element.getClass() != dataType) {
            throw new InputMismatchException("Type missmatch");
        }

        MyNode<T> iteratorNode = null;
        if (index < sz / 2) {
            iteratorNode = iterateFromFront(index);
        } else {
            iteratorNode = iterateFromRear(index);
        }

        MyNode<T> tempNode = new MyNode<T>(element);

        tempNode.prev = iteratorNode.prev;
        iteratorNode.prev.next = tempNode;

        tempNode.next = iteratorNode;
        iteratorNode.prev = tempNode;
        ++sz;
    }

    // Not from MyList interface
    public void addFirst(T element) {
        add(0, element);
    }

    // Not from MyList interface
    public void addLast(T element) {
        add(element);
    }

    public void clear() {
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        sz = 0;
    }

    public boolean contains(T element) {
        if (!first && element.getClass() != dataType) {
            throw new InputMismatchException("Type missmatch");
        }

        MyNode<T> iteratorNode = dummyHead.next;
        while (iteratorNode != dummyTail) {
            if (element == null
                ? iteratorNode.val == null
                : element.equals(iteratorNode.val))
            {
                return true;
            }
            iteratorNode = iteratorNode.next;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || sz <= index) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> iteratorNode = null;
        if (index < sz / 2) {
            iteratorNode = iterateFromFront(index);
        } else {
            iteratorNode = iterateFromRear(index);
        }

        return iteratorNode.val;
    }

    // Not from MyList interface
    public T getFirst() {
        if (sz == 0) {
            throw new NoSuchElementException();
        }

        return dummyHead.next.val;
    }

    // Not from MyList interface
    public T getLast() {
        if (sz == 0) {
            throw new NoSuchElementException();
        }

        return dummyTail.prev.val;
    }

    public int indexOf(T element) {
        if (!first && element.getClass() != dataType) {
            throw new InputMismatchException("Type missmatch");
        }

        MyNode<T> iteratorNode = dummyHead.next;
        int i = 0;
        while (iteratorNode != dummyTail) {
            if (element == null
                ? iteratorNode.val == null
                : element.equals(iteratorNode.val))
            {
                return i;
            }
            iteratorNode = iteratorNode.next;
            ++i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public int lastIndexOf(T element) {
        if (!first && element.getClass() != dataType) {
            throw new InputMismatchException("Type missmatch");
        }

        MyNode<T> iteratorNode = dummyTail.next;
        int i = sz - 1;
        while (iteratorNode != dummyHead) {
            if (element == null
                ? iteratorNode.val == null
                : element.equals(iteratorNode.val))
            {
                return i;
            }
            iteratorNode = iteratorNode.prev;
            --i;
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || sz <= index) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> iteratorNode = null;
        if (index < sz / 2) {
            iteratorNode = iterateFromFront(index);
        } else {
            iteratorNode = iterateFromRear(index);
        }

        T ret = iteratorNode.val;
        iteratorNode.prev.next = iteratorNode.next;
        iteratorNode.next.prev = iteratorNode.prev;
        --sz;

        return ret;
    }

    public boolean remove(T element) {
        if (!first && element.getClass() != dataType) {
            throw new InputMismatchException("Type missmatch");
        }

        MyNode<T> iteratorNode = dummyHead.next;
        while (iteratorNode != dummyTail) {
            if (element == null
                ? iteratorNode.val == null
                : element.equals(iteratorNode.val))
            {
                iteratorNode.prev.next = iteratorNode.next;
                iteratorNode.next.prev = iteratorNode.prev;
                --sz;
                return true;
            }
        }
        return false;
    }

    // Not from MyList interface
    public T removeFirst() {
        if (sz == 0) {
            throw new NoSuchElementException();
        }

        T ret = dummyHead.next.val;
        dummyHead.next = dummyHead.next.next;
        dummyHead.next.prev = dummyHead;
        --sz;

        return ret;
    }

    // Not from MyList interface
    public T removeLast() {
        if (sz == 0) {
            throw new NoSuchElementException();
        }

        T ret = dummyTail.prev.val;
        dummyTail.prev = dummyTail.prev.prev;
        dummyTail.prev.next = dummyTail;
        --sz;

        return ret;
    }

    public T set(int index, T element) {
        if (index < 0 || sz <= index) {
            throw new IndexOutOfBoundsException();
        }
        if (element.getClass() != dataType) {
            throw new InputMismatchException("Type missmatch");
        }

        MyNode<T> iteratorNode = null;
        if (index < sz / 2) {
            iteratorNode = iterateFromFront(index);
        } else {
            iteratorNode = iterateFromRear(index);
        }

        T ret = iteratorNode.val;
        iteratorNode.val = element;

        return ret;
    }

    public int size() {
        return sz;
    }

    // Helper functions
    private MyNode<T> iterateFromFront(int index) {
        MyNode<T> iteratorNode = dummyHead.next;
        int i = 0;
        while (i != index) {
            iteratorNode = iteratorNode.next;
            ++i;
        }

        return iteratorNode;
    }

    private MyNode<T> iterateFromRear(int index) {
        MyNode<T> iteratorNode = dummyTail.prev;
        int i = sz - 1;
        while (i != index) {
            iteratorNode = iteratorNode.prev;
            --i;
        }

        return iteratorNode;
    }
}

/**
 * Usage in main():
 * MyLimitedLinkedList<Integer> myFirstArr =
 *     new MyLimitedLinkedList<Integer>(Integer[].class);
 * myFirstArr.add(5);
 * ...
 *
 * MyLimitedLinkedList<String> mySecondArr =
 *     new MyLimitedLinkedList<String>(String[].class);
 * mySecondArr.add("Hello World");
 * ...
 */

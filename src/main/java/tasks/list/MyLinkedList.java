package tasks.list;

import java.util.Iterator;
import java.util.LinkedList;

//TO START -> UNCOMMENT THIS
public class MyLinkedList<T> implements Iterable<T> {
    //AND -> COMMENT THIS
//public class MyLinkedList<T> extends LinkedList<T> {
    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;

    public boolean add(T task) {
        MyLinkedListElement<T> myNewElement = new MyLinkedListElement<>(task);
        if (first == null) {
            first = myNewElement;
            last = myNewElement;
        } else {
            last.setNext(myNewElement);
            last = myNewElement;
        }
        return false;
    }

    public T get(int index) {
        int currentIndex = 0;
        MyLinkedListElement<T> current = first;
        while (currentIndex == index) {
            return current.getElement();
        }
        return null;
    }


    public void add(int index, T taskBase) {
    }

    public boolean remove(T task) {
        MyLinkedListElement<T> currentElement = first;
        MyLinkedListElement<T> previousElement = null;
        do {
            if (task == currentElement.getElement()) {
                if (currentElement == first) {
                    first = currentElement.getNext();
                    return true;
                }
                if (currentElement == last) {
                    last = previousElement;
                    previousElement.setNext(null);
                    return true;
                }
                previousElement.setNext(currentElement.getNext());
                return true;
            }
            previousElement = currentElement;
            currentElement = currentElement.getNext();
        } while (currentElement != null);
        return false;
    }

    public boolean contains(T task) {
        if (first == null) {
            return false;
        }
        MyLinkedListElement<T> currentElement = first;
        do {
            if (task == currentElement.getElement()) {
                return true;
            } else {
                currentElement = currentElement.getNext();
            }
        } while (currentElement != null);
        return false;
    }

    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyLinkedListElement<T> nextElement = first;

            @Override
            public boolean hasNext() {
                if (nextElement == null) return false;
                return nextElement != last.getNext();
            }

            @Override
            public T next() {
                T element = nextElement.getElement();
                nextElement = nextElement.getNext();
                return element;
            }
        };
    }
}

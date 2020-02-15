package tasks.list;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<T> implements Iterable<T> {


    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;


    public boolean add(T task) {
        MyLinkedListElement<T> myLinkedListElement = new MyLinkedListElement<>(task);
        if (first == null) {
            first = myLinkedListElement;
            last = myLinkedListElement;
        } else {
            last.setNext(myLinkedListElement);
            last = myLinkedListElement;
        }
        return true;
    }

    public void add(int index, T taskBase) {

    }

    public boolean remove(T task) {
        if (first == null) {
            return true;
        }
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
        MyLinkedListElement<T> currentElementOnList = first;
        do {
            if (task == currentElementOnList.getElement()) {
                return true;
            } else {
                currentElementOnList = currentElementOnList.getNext();
            }
        } while (currentElementOnList != null);
        return false;
    }

    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyLinkedListElement<T> currentElement = first;

            @Override
            public boolean hasNext() {
                return currentElement != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T element = currentElement.getElement();
                    currentElement = currentElement.getNext();
                    return element;
                }
                return null;
            }
        };
    }
}

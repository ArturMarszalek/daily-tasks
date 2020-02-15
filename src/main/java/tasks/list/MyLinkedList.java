package tasks.list;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<T> implements Iterable<T> {

    //public class MyLinkedList<T> extends LinkedList<T> {
//
    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;

    public boolean add(T task) {
        MyLinkedListElement<T> newElement = new MyLinkedListElement<>(task);
        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            last.setNext(newElement);
            last = newElement;
        }
        return false;
    }


    public void add(int index, T taskBase) {

    }

    public boolean remove(T task) {
        return false;
    }

    public boolean contains(T task) {
        MyLinkedListElement<T> elemntOnList = first;
        if (first != null) {
            do {
                if (task == elemntOnList.getElement()) {
                    return true;
                } else {
                    elemntOnList = elemntOnList.getNext();
                }
            } while (elemntOnList.getNext() != null);
            return false;
        }
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
                if(hasNext()){
                    T element = currentElement.getElement();
                    currentElement = currentElement.getNext();
                    return element;
                }
                return null;
            }
        };
    }
}
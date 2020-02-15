package tasks.list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;

    public boolean add(T task) {

        MyLinkedListElement<T> newElement = new MyLinkedListElement<>(task);

        if (first == null) {
            first = newElement;
            last = newElement;
            return true;
        } else {
            last.setNext(newElement);
            this.last = newElement;
            return true;
        }
    }

    public void add(int index, T taskBase) {
        MyLinkedListElement<T> elementToAdd = new MyLinkedListElement<>(taskBase);

        if (index == 0) {
            MyLinkedListElement<T> nextElement = getElementAt(index);
            elementToAdd.setNext(nextElement);
            first = elementToAdd;
        }
    }

    private MyLinkedListElement<T> getElementAt(int index) {
        int currentIndex = 0;
        MyLinkedListElement<T> current = first;
        while (current != null) {
            if (currentIndex == index) {
                return current;
            }
            current = current.getNext();
            currentIndex++;

        }
        return null;
    }

    public boolean remove(T task) {

        if (first == null) return false;
        MyLinkedListElement<T> elemntOnList = first;
        if (task == first.getElement()) {
            first = null;
            last = null;

        } else {
            do {
                if (task == elemntOnList.getNext().getElement() && elemntOnList.getNext() != last) {
                    elemntOnList.setNext(elemntOnList.getNext().getNext());
                } else {
                    elemntOnList.setNext(null);
                    last = elemntOnList;
                }
            } while (elemntOnList.getNext() != null);
        }
        return false;
    }

    public boolean contains(T task) {

        if (first == null) {
            return false;
        }

        MyLinkedListElement<T> elemntOnList = first;
        do {
            if (task == elemntOnList.getElement()) {
                return true;
            } else {
                elemntOnList = elemntOnList.getNext();
            }
        } while (elemntOnList.getNext() != null);
        return false;
    }

    public T get(int index) {
        int currentIndex = 0;
        MyLinkedListElement<T> current = first;
        while (current != null) {
            current = first.getNext();
            if (currentIndex == index) {
                return current.getElement();
            }
            current = first.getNext();
            currentIndex++;
        }
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
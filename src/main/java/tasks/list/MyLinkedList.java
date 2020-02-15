package tasks.list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

//public class MyLinkedList<T> extends LinkedList<T> {

    private MyLinkedListElement<T> first;

    private MyLinkedListElement<T> last;

    private static int indexCounter = 0;


    public boolean add(T task) {
        MyLinkedListElement<T> addedElement = new MyLinkedListElement<>(task);
        if (first == null) {
            first = addedElement;
            last = addedElement;
            addedElement.setIndex(indexCounter);
            indexCounter++;

            return true;
        } else if (first != null) {
            last.setNextElement(addedElement);
            last = addedElement;
            addedElement.setIndex(indexCounter);
            indexCounter++;
            return true;

        }
        return false;
    }

    public void add(int index, T taskBase) {

    }

    public boolean remove(T task) {
        if (first == null) return false;
        MyLinkedListElement<T> elemntOnList = first;
        if (task == first.getElement()) {
            first = null;
            last = null;

        } else {
            do {
                if (task == elemntOnList.getNextElement().getElement() && elemntOnList.getNextElement() != last) {
                    elemntOnList.setNextElement(elemntOnList.getNextElement().getNextElement());
                } else {
                    elemntOnList.setNextElement(null);
                    last = elemntOnList;
                }


            } while (elemntOnList.getNextElement() != null);
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
                elemntOnList = elemntOnList.getNextElement();
            }
        } while (elemntOnList.getNextElement() != null);

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
                return nextElement != last.getNextElement();

            }
            @Override
            public T next() {
                T element = nextElement.getElement();
                nextElement = nextElement.getNextElement();

                return element;
            }
        };
    }
}

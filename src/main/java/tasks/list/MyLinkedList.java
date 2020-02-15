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
        } while (currentElement.getNext() != null);

        return false;
    }

    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyLinkedListElement<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T element = current.getElement();
                current = current.getNext();
                return element;
            }
        };
    }
}

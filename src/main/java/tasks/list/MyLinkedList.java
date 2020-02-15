package tasks.list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    // public class MyLinkedList<T extends TaskBase> extends LinkedList<T> {
    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;

    public MyLinkedListElement<T> getFirst() {
        return first;

    }

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

        if(first == null)
            return false;

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

        MyLinkedListElement<T> listElement = first;

        do {
            if (task == listElement.getElement()) {
                return true;
            } else {
                listElement = listElement.getNext();
            }
        } while (listElement.getNext() != null);

        return false;
    }

    public T get(int index) {

        int currentIndex = 0;

        MyLinkedListElement<T> current = first;

        while (current != null) {

            if(currentIndex == index) {

                return current.getElement();
            }

            current = current.getNext();
            currentIndex++;

        }

        return null;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            MyLinkedListElement<T> currentScore = first;

            @Override

            public boolean hasNext() {
                if (currentScore == null)
                    return false;

                return currentScore != last.getNext();
            }

            @Override

            public T next() {
                T element = currentScore.getElement();
                currentScore = currentScore.getNext();
                return element;
            }
        };
    }
}


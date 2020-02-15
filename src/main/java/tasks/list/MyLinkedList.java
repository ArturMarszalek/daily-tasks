package tasks.list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;


    public boolean add(T task) {
        MyLinkedListElement newElement = new MyLinkedListElement(task);

        if (first == null) {

            first = newElement;
            last = newElement;
        } else {
            if (first == last) {
                first.setNext(newElement);
                last = newElement;
            } else {
                last.setNext(newElement);
                last = newElement;
            }
        }
        return true;
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

    public T getAt(int index) {
        int currentIndex = 0;
        MyLinkedListElement<T> current = first;
        while (current != null) {
            if (currentIndex == index) {
                return current.getElement();
            }
            current = current.getNext();
            currentIndex++;

        }
        return null;
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

            MyLinkedListElement<T> currentElement = first;

            @Override
            public boolean hasNext() {

                return currentElement != null;
            }

            @Override
            public T next() {
                MyLinkedListElement<T> temp = currentElement;
                currentElement = currentElement.getNext();
                return temp.getElement();
            }
        };
    }
}

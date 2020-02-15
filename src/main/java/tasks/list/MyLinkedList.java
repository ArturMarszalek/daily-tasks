package tasks.list;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<T> implements Iterable<T> {

    //public class MyLinkedList<T> extends LinkedList<T> {
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
        } while (currentElement != null);
        return false;
    }


    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            //SOMETHING TO ADD HERE?
            MyLinkedListElement<T> current = null;
            boolean firstWasSet = false;

            @Override
            public boolean hasNext() {
                //TODO CHANGE THIS
                if(first != null && !firstWasSet) {
                    return true;
                }
                return current != null && current.getNext() != null;

            }

            @Override
            public T next() {
                if (current == null){
                    current = first;
                    firstWasSet = true;
                    return current.getElement();
                } else {
                    current = current.getNext();
                    return current.getElement();
                }
            }
        };
    }
}

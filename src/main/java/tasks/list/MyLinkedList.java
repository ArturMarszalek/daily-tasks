package tasks.list;


import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<T> implements Iterable<T> {

    private MyLinkedListElement first;
    private MyLinkedListElement last;

    public boolean add(T task) {

        MyLinkedListElement<T> listOfElements = new MyLinkedListElement<>(task);
        if (first == null) {
            first = listOfElements;
            last = listOfElements;
        } else {
            last.setNext(listOfElements);
            last = listOfElements;
        }
        return false;
    }

    public void add(int index, T taskBase) {
        }

    public boolean remove(T task) {
        return false;
    }

    public boolean contains(T task) {

        MyLinkedListElement ifContains = first;

        do {
            if (ifContains == null) {
                return false;
            }
            if (task == ifContains.getElement()) {
                return true;
            } else {
                ifContains = ifContains.getNext();
            }
        } while (ifContains.getNext() != null);
        return false;
    }

    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
       return new Iterator<T>() {
             MyLinkedListElement nextElement = first;

           @Override
           public boolean hasNext() {

               return nextElement != last.getNext();
           }

           @Override
           public T next() {
               T element = (T) nextElement.getElement();
               nextElement = nextElement.getNext();
               return element;
           }
       };
    }
}

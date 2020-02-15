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
        first = null;

        return true;
    }

    public boolean contains(T task) {
        MyLinkedListElement<T> elementOnList = first;
        do {
            if (first==null){
                return false;
            }else if (task == elementOnList.getElement()) {
                return true;
            } else {
                elementOnList = elementOnList.getNext();
            }
        } while (elementOnList != null);
        return false;
    }

    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            //SOMETHING TO ADD HERE?

            @Override
            public boolean hasNext() {
                //TODO CHANGE THIS
                return false;
            }

            @Override
            public T next() {
                //TODO CHANGE THIS
                return null;
            }
        };
    }
}

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

//    public Iterator<T> iterator() {
//        return new Iterator<T>() {
//            MyLinkedListElement<T> nextElement = first;
//            @Override
//            public boolean hasNext() {
//                return nextElement != last.getNext();
//            }
//            @Override
//            public T next() {
//                T element = nextElement.getElement();
//                nextElement = nextElement.getNext();
//                return element;
//            }
//        };
//    }


    @Override
    public Iterator<T> iterator() {


        return new Iterator<T>() {

            MyLinkedListElement<T> currentElement = first;

            @Override
            public boolean hasNext() {
                if (currentElement == null) {
                    return false;
                }
                return true;
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

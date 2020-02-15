package tasks.list;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<T> implements Iterable<T> {

    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;
    private MyLinkedListElement<T> current=null;

    boolean initialize = true;

    public boolean add(T task) {
        MyLinkedListElement<T> newTask = new MyLinkedListElement<>(task);
        if (first == null) {
            first = newTask;
            last = newTask;
            return true;
        } else if (first != null) {
            last.setNext(newTask);
            last = newTask;

        }

        return false;
    }

    public void add(int index, T taskBase) {

    }

    public boolean remove(T task) {
//        MyLinkedListElement tmp=new MyLinkedListElement(first);
//    while (tmp.hasNext()){
//        if (tmp==task){
//
//        }
//        tmp=tmp.getNext();
////    }
//        return false;
        return false;
    }

    public boolean contains(T task) {
        if (first==null){
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
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyLinkedListElement<T> nextElement = first;
            @Override
            public boolean hasNext() {
                if (nextElement==null){return false;}
                return nextElement != last.getNext();
            }
            @Override
            public T next() {
                T element = nextElement.getElement();
                nextElement = nextElement.getNext();
                return element;

            }
        };
    }
}

package tasks.list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

//public class MyLinkedList<T> extends LinkedList<T> {
    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;



    public boolean add(T task) {
        return false;
    }

    public void add(int index, T taskBase) {

    }

    public boolean remove(T task) {
        return false;
    }

    public boolean contains(T task) {
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

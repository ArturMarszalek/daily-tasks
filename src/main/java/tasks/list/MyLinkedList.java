package tasks.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

//TO START -> UNCOMMENT THIS
public class MyLinkedList<T> implements Iterable<T> {

    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;

    public void add(T task) {

        MyLinkedListElement<T> newElement = new MyLinkedListElement<>(task);

        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            last.setNext(newElement);
            last = newElement;
        }
    }

    public void add(int index, T taskBase) {

        MyLinkedListElement<T> element = new MyLinkedListElement<>(taskBase);

        if (index == 0) {
            MyLinkedListElement<T> next = getElement(index);
            element.setNext(next);
            first = element;
        }

        MyLinkedListElement<T> preview = getElement(index - 1);

        preview.setNext(element);

    }

    public boolean remove(T task) {

        MyLinkedListElement<T> currentElement = first;
        MyLinkedListElement<T> previewElement = null;

        do {

            if (task == currentElement.getElement()) {
                if (currentElement == first) {
                    first = currentElement.getNext();
                    return true;
                }

                if (currentElement == last) {
                    last = previewElement;
                    previewElement.setNext(null);
                    return true;
                }
                previewElement.setNext(currentElement.getNext());
                return true;
            }

            previewElement = currentElement;
            currentElement = currentElement.getNext();

        } while (currentElement != null);


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
        int indexElement = 0;

        MyLinkedListElement<T> current = first;

        while (current != null) {

            if (indexElement == index) {
                return current.getElement();
            }

            current = current.getNext();
            indexElement++;

        }

        return null;

    }

    public MyLinkedListElement<T> getElement(int index) {
        int indexElement = 0;

        MyLinkedListElement<T> current = first;

        while (current != null) {

            if (indexElement == index) {
                return current;
            }

            current = current.getNext();
            indexElement++;

        }

        return null;
    }

    @Override
    public Iterator<T> iterator() {
       return new Iterator<T>() {

           public MyLinkedListElement<T> current = first;

           //SOMETHING TO ADD HERE?
           @Override
           public boolean hasNext() {

               //TODO CHANGE THIS
               return current != null;
           }

           @Override
           public T next() {

               if(hasNext()) {
                   T element = current.getElement();
                   current = current.getNext();
                   return element;
               }

               return null;
           }
       };
    }
}

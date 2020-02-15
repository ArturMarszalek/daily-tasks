package tasks.list;


import java.util.Iterator;

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

        MyLinkedListElement<T> elementToAdd = new MyLinkedListElement<>(taskBase);

        if (index == 0){
            MyLinkedListElement<T> nextElement = getElementAt(index);
            elementToAdd.setNext(nextElement);
            first = elementToAdd;
        }
        MyLinkedListElement<T> previousElement = getElementAt(index -1);
        previousElement.setNext(elementToAdd);
        }

    public boolean remove(T task) {
        MyLinkedListElement<T> currentElement = first;
        MyLinkedListElement<T> previousElement = null;
        do {
            if (task == currentElement.getElement()) {
                if (currentElement == first){
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

        MyLinkedListElement currentElement = first;

        do {
            if (currentElement == null) {
                return false;
            }
            if (task == currentElement.getElement()) {
                return true;
            } else {
                currentElement = currentElement.getNext();
            }
        } while (currentElement.getNext() != null);
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
    private MyLinkedListElement getElementAt(int index) {
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

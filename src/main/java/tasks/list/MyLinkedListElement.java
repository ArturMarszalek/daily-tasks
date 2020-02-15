package tasks.list;


import java.util.LinkedList;

public class MyLinkedListElement<T> {
    private T element;
    private MyLinkedListElement<T> next;
    private MyLinkedListElement<T> previous;

    public MyLinkedListElement<T> getPrevious() {
        return previous;
    }

    public void setPrevious(MyLinkedListElement<T> previous) {
        this.previous = previous;
    }

    public MyLinkedListElement<T> getNext() {
        return next;
    }

    public void setNext(MyLinkedListElement<T> next) {
        this.next = next;
    }

    public MyLinkedListElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}

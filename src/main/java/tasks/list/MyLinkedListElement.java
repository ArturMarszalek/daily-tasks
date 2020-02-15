package tasks.list;

public class MyLinkedListElement<T> {
    private T element;
    private MyLinkedListElement<T> next;

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

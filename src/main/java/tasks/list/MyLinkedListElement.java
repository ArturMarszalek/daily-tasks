package tasks.list;

public class MyLinkedListElement<T> {
    private T element;
    private MyLinkedListElement next;

    public MyLinkedListElement getNext() {
        return next;
    }

    public void setNext(MyLinkedListElement next) {
        this.next = next;
    }

    public MyLinkedListElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}

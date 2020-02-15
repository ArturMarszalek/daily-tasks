package tasks.list;

public class MyLinkedListElement<T> {
    private T element;

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private MyLinkedListElement<T> next;

    public MyLinkedListElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public MyLinkedListElement<T> getNext() {
        return next;
    }

    public void setNext(MyLinkedListElement<T> next) {
        this.next = next;
    }

}




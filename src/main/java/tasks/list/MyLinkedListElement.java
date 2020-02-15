package tasks.list;

public class MyLinkedListElement<T> {

    private T element;

    private MyLinkedListElement<T> nextElement;

    private int index;



    public MyLinkedListElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }



    public MyLinkedListElement<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(MyLinkedListElement<T> nextElement) {
        this.nextElement = nextElement;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

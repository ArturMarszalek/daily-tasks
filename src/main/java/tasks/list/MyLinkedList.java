package tasks.list;

import tasks.status.TaskStatus;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<T> implements Iterable<T> {

    private MyLinkedListElement<T> first;
    private MyLinkedListElement<T> last;
    private MyLinkedListElement<T> current = null;



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
//    public boolean add(T task, TaskStatus taskStatus){
//        add(task);
//        taskStatus.getFinshedScore;
//    }

    public void add(int index, T taskBase) {
        MyLinkedListElement<T> elementToAdd = new MyLinkedListElement<>(taskBase);

        if (index==0){
            MyLinkedListElement<T> nextElement = getElementAdd(index);
            elementToAdd.setNext(nextElement);
            first=elementToAdd;
        }
MyLinkedListElement<T> previousElemnt = getElementAdd(index-1);




previousElemnt.setNext(elementToAdd);

    }

    public boolean remove(T task) {

        if (first == null) return false;
        MyLinkedListElement<T> elemntOnList = first;
        if (task == first.getElement()) {
            first = null;
            last = null;

        } else {
            do {
                if (task == elemntOnList.getNext().getElement() && elemntOnList.getNext() != last) {
                    elemntOnList.setNext(elemntOnList.getNext().getNext());
                } else {
                    elemntOnList.setNext(null);
                    last = elemntOnList;
                }


            } while (elemntOnList.getNext() != null);
        }

        return false;

//        if (first == null) {
//            return false;
//        }
//        MyLinkedListElement<T> tmp2 = first;
//        if (first == task) {
//            first = null;
//            last = null;
//        } else {
//            do {
//
//                if (tmp2.getNext().getElement() == task && tmp2.getNext() != last) {
//                    tmp2.setNext(tmp2.getNext().getNext());
//                } else {
//                    tmp2.setNext(null);
//                    last = tmp2;
//                }
//
//            } while (tmp2.getNext() != null);


//while (tmp2!=null){
//    if (tmp2.getNext()==last){
//        if (task==last){
//            tmp2.setNext(null);
//        }
//    }
//    if (tmp2.getNext()==task){
//        tmp2.setNext(tmp2.getNext().getNext());
//        return true;
//    }
//    tmp2=tmp2.getNext();
//        }
//        return false;
    }

    public boolean contains(T task) {
        if (first == null) {
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
        return getElementAdd(index).getElement();
    }

    private MyLinkedListElement<T> getElementAdd(int index){
        int currentIndex = 0;
        MyLinkedListElement<T> current= first;
        while (current!=null){
            if (currentIndex==index){
                return current;
            }
            current=current.getNext();
            currentIndex++;
        }
        return null;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public MyLinkedListElement<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T element = current.getElement();
                current = current.getNext();
                return element;
            }
        };
    }
}

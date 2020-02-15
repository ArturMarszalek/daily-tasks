package tasks.list;

import tasks.EasyTask;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<MyLinkedListElement> myLinkedList = new MyLinkedList();
        myLinkedList.add(new MyLinkedListElement(new EasyTask("11")));
        myLinkedList.add(new MyLinkedListElement(new EasyTask("22")));
        myLinkedList.add(new MyLinkedListElement(new EasyTask("33")));
        myLinkedList.add(new MyLinkedListElement(new EasyTask("44")));

        for (MyLinkedListElement myLinkedListElement : myLinkedList) {
            System.out.println(myLinkedListElement);
        }
        System.out.println("-----------");
        for (MyLinkedListElement myLinkedListElement : myLinkedList) {
            System.out.println(myLinkedListElement);
        }
//        System.out.println(myLinkedList.iterator().hasNext());
//        System.out.println(myLinkedList.iterator().next());
//        System.out.println(myLinkedList.iterator().next());
//        System.out.println(myLinkedList.iterator().next());
//        System.out.println(myLinkedList.iterator().next());
//        System.out.println(myLinkedList.iterator().next());

    }
}

package tasks.list;

import tasks.EasyTask;

public class Main {
    public static void main(String[] args) {


        MyLinkedList<MyLinkedListElement> myLinkedList = new MyLinkedList();
        MyLinkedListElement el1= new MyLinkedListElement(new EasyTask("11"));
        MyLinkedListElement el2= new MyLinkedListElement(new EasyTask("12"));
        MyLinkedListElement el3= new MyLinkedListElement(new EasyTask("13"));
        MyLinkedListElement el4= new MyLinkedListElement(new EasyTask("14"));


//        myLinkedList.add(el1);
        myLinkedList.add(el2);
        myLinkedList.add(el3);
//        myLinkedList.add(el4);

        iterate(myLinkedList);

        myLinkedList.remove(el3);

        System.out.println("--------------");
        iterate(myLinkedList);
    }

    private static void iterate(MyLinkedList<MyLinkedListElement> myLinkedList) {
        for (MyLinkedListElement myLinkedListElement : myLinkedList) {
            System.out.println(myLinkedListElement);
        }
    }
}
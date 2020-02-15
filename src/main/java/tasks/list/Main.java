package tasks.list;

import tasks.EasyTask;

public class Main {
    public static void main(String[] args) {


        MyLinkedList<MyLinkedListElement> myLinkedList = new MyLinkedList();
        MyLinkedListElement element1= new MyLinkedListElement(new EasyTask("11"));
        MyLinkedListElement element2= new MyLinkedListElement(new EasyTask("12"));
        MyLinkedListElement element3= new MyLinkedListElement(new EasyTask("13"));
        MyLinkedListElement element4= new MyLinkedListElement(new EasyTask("14"));


//        myLinkedList.add(element1);
        myLinkedList.add(element2);
        myLinkedList.add(element3);
//        myLinkedList.add(element4);

        iterate(myLinkedList);

        myLinkedList.remove(element3);

        System.out.println("--------------");
        iterate(myLinkedList);
    }

    private static void iterate(MyLinkedList<MyLinkedListElement> myLinkedList) {
        for (MyLinkedListElement myLinkedListElement : myLinkedList) {
            System.out.println(myLinkedListElement);
        }
    }
}

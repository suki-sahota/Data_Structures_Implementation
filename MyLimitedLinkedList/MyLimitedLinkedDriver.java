/**
 * Author: Suki Sahota
 */
public class MyLinkedDriver {
    public static void main(String[] args) {
        MyLimitedLinkedList<Integer> myFirstList = 
            new MyLimitedLinkedList<Integer>();
        myFirstList.add(1);
        myFirstList.add(2);
        System.out.println("My first list is size == " + myFirstList.size());
        for (int i = 0; i < myFirstList.size(); ++i) {
            System.out.println(myFirstList.get(i));
        }

        MyLimitedLinkedList<String> mySecondList = 
            new MyLimitedLinkedList<String>();
        mySecondList.add("Hello");
        mySecondList.add("World");
        System.out.println("\nMy second list is size == "
            + mySecondList.size());
        for (int i = 0; i < mySecondList.size(); ++i) {
            System.out.println(mySecondList.get(i));
        }

        MyLimitedLinkedList<Integer> myThirdList = 
            new MyLimitedLinkedList<Integer>();
        for (int i = 0; i < 1000; ++i) {
            myThirdList.add(0, i);
        }
        System.out.println("\nMy third list is size == " + myThirdList.size());

        for (int i = 0; i < 1000; ++i) {
            myThirdList.remove(0);
        }
        System.out.println("\nNow, my third list is size == "
            + myThirdList.size());
    }
}

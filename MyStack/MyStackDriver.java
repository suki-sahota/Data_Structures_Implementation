/**
 * Author: Suki Sahota
 */
public class MyStackDriver {
    public static void main(String[] args) {
        MyStack<Integer> myFirstStk = 
            new MyStack<Integer>(Integer[].class);
        myFirstStk.add(1);
        myFirstStk.add(2);
        System.out.println("My first stack is size == " + myFirstStk.size());
        for (int i = 0; i < myFirstStk.size(); ++i) {
            System.out.println(myFirstStk.get(i));
        }

        MyStack<String> mySecondStk = 
            new MyStack<String>(String[].class);
        mySecondStk.add("Hello");
        mySecondStk.add("World");
        System.out.println("\nMy second stack is size == "
            + mySecondStk.size());
        for (int i = 0; i < mySecondStk.size(); ++i) {
            System.out.println(mySecondStk.get(i));
        }

        MyStack<Integer> myThirdStk = 
            new MyStack<Integer>(Integer[].class);
        for (int i = 0; i < 1000; ++i) {
            myThirdStk.add(0, i);
        }
        System.out.println("\nMy third stack is size == " + myThirdStk.size());

        for (int i = 0; i < 1000; ++i) {
            myThirdStk.remove(0);
        }
        System.out.println("\nNow, my third stack is size == "
            + myThirdStk.size());
    }
}

/**
 * Usage in main():
 * MyStack<Integer> myFirstStk = new MyStack<Integer>(Integer[].class);
 * myFirstStk.add(5);
 * ...
 *
 * MyStack<String> mySecondStk = new MyStack<String>(String[].class);
 * mySecondStk.add("Hello World");
 * ...
 */

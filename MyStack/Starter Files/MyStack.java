/**
 * Author: Suki Sahota
 */
 import java.util.EmptyStackException;

 public class MyStack<T> extends MyArrayList<T> {

     public MyStack(Class<T[]> arrClass) {
         super(arrClass);
     }

     public boolean empty() {
         // ...
         return true;
     }

     public T peek() {
         if (super.isEmpty()) {
             throw new EmptyStackException();
         }

         return null;
     }

     public T pop() {
         if (super.isEmpty()) {
             throw new EmptyStackException();
         }

         return null;
     }

     public T push(T element) {
         // ...
         return null;
     }

     public int search(T element) {
         // ...
         return -1;
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

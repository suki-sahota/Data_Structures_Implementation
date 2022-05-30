/**
 * Author: Suki Sahota
 */
 import java.util.EmptyStackException;

 public class MyStack<T> extends MyArrayList<T> {

     public MyStack(Class<T[]> arrClass) {
         super(arrClass);
     }

     public boolean empty() {
         return super.isEmpty();
     }

     public T peek() {
         if (super.isEmpty()) {
             throw new EmptyStackException();
         }

         return super.get(super.size() - 1);
     }

     public T pop() {
         if (super.isEmpty()) {
             throw new EmptyStackException();
         }

         return super.remove(super.size() - 1);
     }

     public T push(T element) {
         super.add(element);
         return element;
     }

     public int search(T element) {
         int index = super.lastIndexOf(element);
         return index != -1
             ? super.size() - index
             : -1;
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

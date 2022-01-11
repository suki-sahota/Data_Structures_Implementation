/**
 * Author: Suki Sahota
 */
 import java.util.EmptyStackException;

 public class MyStack<T> extends MyArrayList<T> {

     public MyStack(Class<T[]> arrClass) {
         super(arrClass);
     }

     public boolean empty() {
         return isEmpty();
     }

     public T peek() {
         if (isEmpty()) {
             throw new EmptyStackException();
         }

         return get(size() - 1);
     }

     public T pop() {
         if (isEmpty()) {
             throw new EmptyStackException();
         }

         return remove(size() - 1);
     }

     public T push(T element) {
         add(element);
         return element;
     }

     public int search(T element) {
         int index = lastIndexOf(element);
         return index != -1
             ? size() - index
             : -1;
     }
 }

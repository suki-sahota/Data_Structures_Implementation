/**
 * Author: Suki Sahota
 */
public class MyArrayDriver {
    public static void main(String[] args) {
        MyArrayList<Integer> myFirstArr = 
            new MyArrayList<Integer>(Integer[].class);
        myFirstArr.add(1);
        myFirstArr.add(2);
        System.out.println("My first array is size == " + myFirstArr.size());
        for (int i = 0; i < myFirstArr.size(); ++i) {
            System.out.println(myFirstArr.get(i));
        }

        MyArrayList<String> mySecondArr = 
            new MyArrayList<String>(String[].class);
        mySecondArr.add("Hello");
        mySecondArr.add("World");
        System.out.println("\nMy second array is size == " + mySecondArr.size());
        for (int i = 0; i < mySecondArr.size(); ++i) {
            System.out.println(mySecondArr.get(i));
        }

        MyArrayList<Integer> myThirdArr = 
            new MyArrayList<Integer>(Integer[].class);
        for (int i = 0; i < 1000; ++i) {
            myThirdArr.add(0, i);
        }
        System.out.println("\nMy third array is size == " + myThirdArr.size());

        for (int i = 0; i < 1000; ++i) {
            myThirdArr.remove(0);
        }
        System.out.println("\nNow, my third array is size == "
            + myThirdArr.size());
    }
}

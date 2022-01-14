/**
 * Author: Suki Sahota
 */
import java.lang.reflect.Array;

public class MyArrayList<T> implements MyList<T> {
    private final static int DEFAULT_SIZE = 8;

    private Class<T[]> arrType;
    private Class dataType;
    private T[] myArr;
    private int sz;
    private int cap;

    // Construction happens internally
    private MyArrayList(Class<T[]> arrClass, int length) {
        arrType = arrClass;
        dataType = arrClass.getComponentType();
        myArr = arrClass.cast(Array.newInstance(dataType, length));
        sz = 0;
        cap = length;
    }

    // One-argument constructor
    public MyArrayList(Class<T[]> arrClass) {
        this(arrClass, DEFAULT_SIZE);
    }

    public boolean add(T element) {
        myArr[sz++] = element;

        if (sz == cap) {
            doubleArray();
        }
        return true; // (as specified by Collection.add(E))
    }

    public void add(int index, T element) {
        if (index < 0 || sz < index) {
            throw new IndexOutOfBoundsException();
        }

        shiftRight(index);
        ++sz;
        myArr[index] = element;

        if (sz == cap) { doubleArray(); }
    }

    public void clear() {
        myArr = createNewArray(DEFAULT_SIZE);
        sz = 0;
        cap = DEFAULT_SIZE;
    }

    public boolean contains(T element) {
        for (int i = 0; i < sz; ++i) {
            if (element == null ? myArr[i] == null : element.equals(myArr[i])) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || sz <= index) {
            throw new IndexOutOfBoundsException();
        }

        return myArr[index];
    }

    public int indexOf(T element) {
        for (int i = 0; i < sz; ++i) {
            if (element == null ? myArr[i] == null : element.equals(myArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public int lastIndexOf(T element) {
        for (int i = sz - 1; i >= 0; --i) {
            if (element == null ? myArr[i] == null : element.equals(myArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || sz <= index) {
            throw new IndexOutOfBoundsException();
        }

        T ret = myArr[index];
        shiftLeft(index + 1);
        --sz;

        if (sz <= cap / 4) { halveArray(); }

        return ret;
    }

    public boolean remove(T element) {
        for (int i = 0; i < sz; ++i) {
            if (element == null ? myArr[i] == null : element.equals(myArr[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public T set(int index, T element) {
        if (index < 0 || sz <= index) {
            throw new IndexOutOfBoundsException();
        }

        T ret = myArr[index];
        myArr[index] = element;

        return ret;
    }

    public int size() {
        return sz;
    }

    // Helper functions
    private T[] createNewArray(int length) {
        T[] myArr = arrType.cast(Array.newInstance(dataType, length));
        return myArr;
    }

    private void doubleArray() {
        cap *= 2;
        T[] myDoubledArr = createNewArray(cap);

        for (int i = 0; i < sz; ++i) {
            myDoubledArr[i] = myArr[i];
        }

        myArr = myDoubledArr;
    }

    private void halveArray() {
        cap /= 2;
        T[] myHalvedArr = createNewArray(cap);

        for (int i = 0; i < sz; ++i) {
            myHalvedArr[i] = myArr[i];
        }

        myArr = myHalvedArr;
    }

    private void shiftRight(int index) {
        for (int i = sz - 1; i >= index; --i) {
            myArr[i + 1] = myArr[i];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < sz; ++i) {
            myArr[i - 1] = myArr[i];
        }
    }
}

/**
 * Usage in main():
 * MyArrayList<Integer> myFirstArr = new MyArrayList<Integer>(Integer[].class);
 * myFirstArr.add(5);
 * ...
 *
 * MyArrayList<String> mySecondArr = new MyArrayList<String>(String[].class);
 * mySecondArr.add("Hello World");
 * ...
 */

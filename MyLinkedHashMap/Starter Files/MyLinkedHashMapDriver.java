/**
 * Author: Suki Sahota
 */
public class MyLinkedHashMapDriver {
    public static void main(String[] args) {
        MyLinkedHashMap<String, Integer> myFirstMap =
            new MyLinkedHashMap<String, Integer>();
        myFirstMap.put("Suki", 1);
        myFirstMap.put("Sahota", 2);
        myFirstMap.put("Hello", 3);
        myFirstMap.put("World", 4);
        System.out.println("My first map is size == " + myFirstMap.size());
        System.out.println("Suki has value " + myFirstMap.get("Suki"));
        System.out.println("Sahota has value " + myFirstMap.get("Sahota"));
        System.out.println("Hello has value " + myFirstMap.get("Hello"));
        System.out.println("World has value " + myFirstMap.get("World"));
        
        // Remove Sahota and World
        myFirstMap.remove("Sahota");
        myFirstMap.remove("World");
        System.out.println("My first map is size == " + myFirstMap.size());
        System.out.println("Suki has value " + myFirstMap.get("Suki"));
        System.out.println("Sahota has value " + myFirstMap.get("Sahota"));
        System.out.println("Hello has value " + myFirstMap.get("Hello"));
        System.out.println("World has default value " 
            + myFirstMap.getOrDefault("World", -1337));
    }
}

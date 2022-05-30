/**
 * Author: Suki Sahota
 */
public class MyLinkedHashMapDriver {
    public static void main(String[] args) {
        MyLinkedHashMap<String, Integer> myFirstMap =
            new MyLinkedHashMap<String, Integer>();

        System.out.println("Checking if \"First\" is contained in map");
        System.out.println("Answer is " + myFirstMap.containsKey("First"));
        System.out.println();

        System.out.println("Adding First through Fifth in map");
        myFirstMap.put("First", 1);
        myFirstMap.put("Second", 2);
        myFirstMap.put("Third", 3);
        myFirstMap.put("Fourth", 4);
        myFirstMap.put("Fifth", 5);
        System.out.println("My first map is size == " + myFirstMap.size());
        System.out.println("First has value " + myFirstMap.get("First"));
        System.out.println("Second has value " + myFirstMap.get("Second"));
        System.out.println("Third has value " + myFirstMap.get("Third"));
        System.out.println("Fourth has value " + myFirstMap.get("Fourth"));
        System.out.println("Fifth has value " + myFirstMap.get("Fifth"));
        System.out.println();
        
        // Remove First and Fifth
        System.out.println("Removing First and Fifth from map");
        myFirstMap.remove("First");
        myFirstMap.remove("Fifth");
        System.out.println("My first map is size == " + myFirstMap.size());
        System.out.println("First has default value "
            + myFirstMap.getOrDefault("First", 1337));
        System.out.println("Second has value " + myFirstMap.get("Second"));
        System.out.println("Third has value " + myFirstMap.get("Third"));
        System.out.println("Fourth has value " + myFirstMap.get("Fourth"));
        System.out.println("Fifth has default value " 
            + myFirstMap.getOrDefault("Fifth", 1337));
        System.out.println();

        // Add Sixth, Seventh, Eighth, Ninth, Tenth, and Eleventh
        System.out.println("Adding Sixth through Eleventh");
        myFirstMap.put("Sixth", 6);
        myFirstMap.put("Seventh", 7);
        myFirstMap.put("Eighth", 8);
        myFirstMap.put("Ninth", 9);
        myFirstMap.put("Tenth", 10);
        myFirstMap.put("Eleventh", 11);
        System.out.println("My first map is size == " + myFirstMap.size());
        System.out.println("Second has value " + myFirstMap.get("Second"));
        System.out.println("Third has value " + myFirstMap.get("Third"));
        System.out.println("Fourth has value " + myFirstMap.get("Fourth"));
        System.out.println("Sixth has value " + myFirstMap.get("Sixth"));
        System.out.println("Seventh has value " + myFirstMap.get("Seventh"));
        System.out.println("Eighth has value " + myFirstMap.get("Eighth"));
        System.out.println("Ninth has value " + myFirstMap.get("Ninth"));
        System.out.println("Tenth has value " + myFirstMap.get("Tenth"));
        System.out.println("Eleventh has value " + myFirstMap.get("Eleventh"));
        System.out.println("My first map is size == " + myFirstMap.size());
        System.out.println();

        // Replacing Seventh, Ninth, and Eleventh with different values
        System.out.println("Replacing 7th, 9th, and 11th with different vals");
        myFirstMap.put("Seventh", 77);
        myFirstMap.put("Ninth", 99);
        myFirstMap.put("Eleventh", 1111);
        System.out.println("My first map is size == " + myFirstMap.size());
        System.out.println("Firth has value " + myFirstMap.get("First"));
        System.out.println("Second has value " + myFirstMap.get("Second"));
        System.out.println("Third has value " + myFirstMap.get("Third"));
        System.out.println("Fourth has value " + myFirstMap.get("Fourth"));
        System.out.println("Fifth has value " + myFirstMap.get("Fifth"));
        System.out.println("Sixth has value " + myFirstMap.get("Sixth"));
        System.out.println("Seventh has value " + myFirstMap.get("Seventh"));
        System.out.println("Eighth has value " + myFirstMap.get("Eighth"));
        System.out.println("Ninth has value " + myFirstMap.get("Ninth"));
        System.out.println("Tenth has value " + myFirstMap.get("Tenth"));
        System.out.println("Eleventh has value " + myFirstMap.get("Eleventh"));
        System.out.println();
    }
}

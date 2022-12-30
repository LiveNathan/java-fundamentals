package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*  HashMaps Exercise_01
 *
 *  Demonstrate your mastery of using Java's built-in HashMap class below.
 *
 *  Using a HashMap demonstrate the use of the following methods:
 *
 *  put()
 *  get()
 *  putAll()
 *  size()
 *  contains()
 *  keySet()
 *  entrySet()
 *  putIfAbsent()
 *  remove()
 *  replace()
 *  forEach()
 *  clear()
 */
public class Exercise_01 {
    public static void main(String[] args) {
        HashMap<String, Integer> cityPopulations = new HashMap<>();

        // put
        cityPopulations.put("Placerville", 10869);
        cityPopulations.put("Minneapolis", 425336);
        cityPopulations.put("Sacramento", 525041);

        // get
        Integer placerville = cityPopulations.get("Placerville");
        System.out.println(placerville.toString());

        // putAll
        HashMap<String, Integer> newHashmap = new HashMap<>();
        newHashmap.putAll(cityPopulations);

        // size
        System.out.println("Size: " + cityPopulations.size());

        // contains
        System.out.println("MSP is key: " + cityPopulations.containsKey("Minneapolis"));

        // keySet
        System.out.println("The keySet is: " + cityPopulations.keySet());

        // entrySet
        System.out.println("The entrySet is: " + cityPopulations.entrySet());

        // putIfAbsent
        cityPopulations.putIfAbsent("Smithville", 4047);

        // remove
        System.out.println("Value removed: " + cityPopulations.remove("Sacramento"));

        // replace
        cityPopulations.replace("Smithville", 4048);

        // print each element (key and value) in the HashMap
        Set<Map.Entry<String, Integer>> entries = cityPopulations.entrySet();
        // loop through the entries
        for (Map.Entry<String, Integer> person : entries) {
            // get each Entry individually
            // print out the entry's key and value
            System.out.println("The key is: " + person.getKey()
                    + " and the value is: " + person.getValue().toString());
        }

        // demonstrate at least 3 other HashMap methods
        System.out.println("10869 is value: " + cityPopulations.containsValue(10869));
        System.out.println("Is empty: " + cityPopulations.isEmpty());

        cityPopulations.clear();
    }
}
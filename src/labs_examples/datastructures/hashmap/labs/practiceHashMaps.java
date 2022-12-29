package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class practiceHashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> cityPopulations = new HashMap<>();

        // add several cities (key )and their populations (value )to the HashMap
        cityPopulations.put("Placerville", 10869);
        cityPopulations.put("Minneapolis", 425336);
        cityPopulations.put("Sacramento", 525041);

        // retrieve the population of each city using the key
        Integer example = cityPopulations.get("Placerville");
        System.out.println(example.toString());

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
        System.out.println("MSP is key: " + cityPopulations.containsKey("Minneapolis"));
        System.out.println("10869 is value: " + cityPopulations.containsValue(10869));
        System.out.println("Is empty: " + cityPopulations.isEmpty());

        cityPopulations.clear();
    }
}

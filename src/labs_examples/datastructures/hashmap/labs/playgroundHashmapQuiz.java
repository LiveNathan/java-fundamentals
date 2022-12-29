package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class playgroundHashmapQuiz {
    public static void main(String[] args) {
        // instantiate new HashMap to hold country names and their populations
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();

        // add "China" and 1420062022 to the map
        myMap.put("China", 1420062022);

        // add "India" and 1368737513 to the map
        myMap.put("India", 1368737513);

        // add "USA" and 329093110 to the map
        myMap.put("USA", 329093110);

        // add "Indonesia" and 269536482 to the map
        myMap.put("Indonesia", 269536482);

        // add "Brazil" and 212392717 to the map
        myMap.put("Brazil", 212392717);

        // get the population value for key = "China" and store in a variable
        int chinaPopulation = myMap.get("China");

        // print China's population
        System.out.println(chinaPopulation);

        // get the population value for key = "India" and store in a variable
        int indiaPopulation = myMap.get("India");

        // print India's population
        System.out.println(indiaPopulation);

        // get the population value for key = "USA" and store in a variable
        int USApopulation = myMap.get("USA");

        // print USA's population
        System.out.println(USApopulation);

        // get the population value for key = "Indonesia" and store in a variable
        int indonesiaPopulation = myMap.get("Indonesia");

        // print Indonesia's population
        System.out.println(indonesiaPopulation);

        // get the population value for key = "Brazil" and store in a variable
        int brazilPopulation = myMap.get("Brazil");

        // print Brazil's population
        System.out.println(brazilPopulation);

        // demonstrate iterating through the entries of a HashMap
        // create a Set of entries from the entrySet
        Set<Map.Entry<String, Integer>> entries = myMap.entrySet();
        // create an Iterator from that entrySet
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        // loop through the entries using the iterator
        while (iterator.hasNext()) {
            // get each Entry individually
            Map.Entry<String, Integer> data = iterator.next();
            // print out the entry's key and value
            System.out.print("Key = " + data.getKey() + " -> Value = " + data.getValue());
            System.out.println();
        }
    }
}
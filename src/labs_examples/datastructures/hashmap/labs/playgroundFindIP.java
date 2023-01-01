package labs_examples.datastructures.hashmap.labs;

import java.util.Objects;

public class playgroundFindIP {
    public boolean ipExistsInDataSet(String[][] data, String ipAddr) {
        for (String[] datum : data) {
            if (Objects.equals(datum[6], ipAddr)) {
                return true;
            }
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.Collections;

public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        Collections.addAll(cities, "Mysuru", "Bengaluru", "Mangaluru");

        for (String city : cities) {
            System.out.println(city);
        }
    }

}
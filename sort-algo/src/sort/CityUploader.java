package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CityUploader {
    private final BufferedReader bufferedReader;

    private final List<City> cities = new ArrayList<>();

    public CityUploader(String fileName) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(fileName));

    }

    public void mapCSVToPOJO() throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.replaceAll("\"","").split(",");
            cities.add(new City(values[0], values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]), values[4], values[5], values[6], values[7], values[8], values[9], values[10]));
        }
    }

    public List<City> getCities() {
        return cities;
    }
}

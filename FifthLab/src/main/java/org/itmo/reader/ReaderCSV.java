package org.itmo.reader;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.itmo.entity.Coordinates;
import org.itmo.entity.LocationFrom;
import org.itmo.entity.LocationTo;
import org.itmo.entity.Route;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Класс для чтения данных с csv.
 */
public class ReaderCSV {
    /**
     * Заголовки.
     */
    private static String[] headers;
    /**
     * Дата создания set.
     */
    private static LocalDateTime initTimeSet;
    /**
     * Поле для хранения нашей коллекции.
     */
    private static Set<Route> routeSet;

    /**
     *
     * @param path
     * @throws IOException
     * @throws CsvException
     */
    public static void readCSV(String path){
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(path)).build();

            Map<String, List<String>> stringListMap = new HashMap<>();
            String[] headers = reader.readNext();
            ReaderCSV.headers = headers;
            for (String cur : headers)
                stringListMap.put(cur, new ArrayList<>());

            for (String[] row : reader.readAll()) {
                for (int i = 0; i < row.length; i++) {
                    stringListMap.get(headers[i]).add(row[i]);
                }

            }
            routeSet = fillRouteSet(stringListMap);
        } catch (CsvException | IOException e) {
            System.out.println("Файл не найден");
            System.exit(0);
        }
    }

    /**
     *
     * @return
     */
    public static String[] getHeaders() {
        return headers;
    }

    /**
     *
     * @param stringListMap
     * @return
     */
    private static Set<Route> fillRouteSet(Map<String, List<String>> stringListMap) {
        Set<Route> routeSet = new TreeSet<>();
        int size = stringListMap.get("name").size();
        for (int i = 0; i < size; i++) {
            try {

                String name = stringListMap.get("name").get(i);
                if (!(name.isBlank() && (Double.parseDouble(stringListMap.get("xC").get(i)) <= 909) && (Integer.parseInt(stringListMap.get("yC").get(i)) <= 660))) {
                    Coordinates coordinates = new Coordinates(Double.parseDouble(stringListMap.get("xC").get(i)), Integer.parseInt(stringListMap.get("yC").get(i)));
                    LocationFrom locationFrom = new LocationFrom(Long.parseLong(stringListMap.get("xLF").get(i)), Double.parseDouble(stringListMap.get("yLF").get(i)), Float.parseFloat(stringListMap.get("zLF").get(i)), stringListMap.get("nameLF").get(i));
                    LocalDateTime date = LocalDateTime.now();
                    LocationTo locationTo = new LocationTo(Double.parseDouble(stringListMap.get("xLT").get(i)), Long.parseLong(stringListMap.get("yLT").get(i)), Integer.parseInt(stringListMap.get("zLT").get(i)));
                    Integer distance = Integer.parseInt(stringListMap.get("distance").get(i));
                    routeSet.add(new Route(i + 1, name, coordinates, date, locationFrom, locationTo, distance));
                }

                initTimeSet = LocalDateTime.now();
            } catch (NullPointerException | NumberFormatException nullPointerException) {

            }
        }
        return routeSet;
    }

    /**
     *
     * @return время иницилизации
     */
    public static LocalDateTime getInitTimeSet() {
        return initTimeSet;
    }

    /**
     *
     * @return коллекция
     */
    public static Set<Route> getRouteSet() {
        return routeSet;
    }
}

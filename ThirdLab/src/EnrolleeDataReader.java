import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EnrolleeDataReader implements DatabaseReader {
    private List<String> enrollee = new ArrayList<>();

    public List<String> readFromDatabase() throws IOException {
        String line;
        File file = new File("C:\\Users\\belal\\dev\\Trashbox\\ThirdLab\\src\\Abitura.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        while ((line = br.readLine()) != null) {
            enrollee.add(line);
        }
        br.close();
        return enrollee;
    }
}
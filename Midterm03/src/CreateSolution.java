import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Jimin on 3/8/17.
 */
public class CreateSolution {
    public void writeDataToFile(String organized_data, String file_name) {
        try {
            Files.write(Paths.get(file_name), organized_data.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}


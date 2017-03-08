import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Jimin on 3/8/17.
 */
public class CreateSolution {

    public void writeDataToFile(String organized_data, String file_name) {
        String no_data = "hh";
        try {
//            Files.write(Paths.get(file_name), no_data.getBytes(), StandardOpenOption.CREATE_NEW);
            Files.write(Paths.get(file_name), organized_data.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jimin on 3/3/17.
 */
public class ReadData {

    int count;
    int[][] data; // = new double[count][count];

    public int[][] readData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("american_tour.dat"));
            String line;

            //number of cities
            count = Integer.parseInt(br.readLine());
            data = new int[count][count];

            //initialize
            for (int i = 0; i < count; i++) {
                for(int j=0; j< count; j++) {
                    data[i][j] = 0;
                }
            }

            //make array
            int i = 0;
            while ((line = br.readLine()) != null) {
                for(int j = 0; j<count; j++) {
                    data[i][j] = Integer.parseInt(line.split(",")[j]);
                }
                i++;
            }

            br.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return data;
    }

    public void printDate() {
        for(int i=0 ; i<count; i++) {
            for(int j =0 ; j<count ; j++) {
                System.out.print(data[i][j] + "   ");
            }
            System.out.println();
        }
    }
}

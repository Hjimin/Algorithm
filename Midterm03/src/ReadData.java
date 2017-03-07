import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jimin on 3/1/17.
 */
public class ReadData {

    int count = 919;
    double[][] data  = new double[count][2];

    public double[][] readData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("shipments.dat"));
            String line;

            for (int i = 0; i < count; i++) {
                for(int j=0; j<2 ; j++) {
                    data[i][j] = 0;
                }
            }

            int order = 0;
            while ((line = br.readLine()) != null) {
                data[order][0]= Integer.parseInt(line.split(",")[1]);
                data[order][1]= Integer.parseInt(line.split(",")[2]);
                order++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return data;
    }

    public void printDate() {
        for(int i=0 ; i<count; i++) {
            for(int j =0 ; j<2 ; j++) {
                System.out.print(data[i][j] + "   ");
            }
            System.out.println();
        }
    }
}

import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Created by Jimin on 1/27/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ReadPoints readPoints = new ReadPoints();
        int[][] data = readPoints.readData("rtest1-2.dat");
        readPoints.calDistance(data, 1000);
    }
}

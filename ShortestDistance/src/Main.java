import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Created by Jimin on 1/27/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        ShortestPath shortestPath = new ShortestPath();
//        int[][] data = shortestPath.readData("challenge1.dat");
//        double[][] dis = shortestPath.calDistance(data);
//        shortestPath.reorder(dis);


        ThreadDemo R1 = new ThreadDemo( "challenge1.dat");
        R1.start();
        ThreadDemo R2 = new ThreadDemo( "challenge2.dat");
        R2.start();
        ThreadDemo R3 = new ThreadDemo( "challenge3.dat");
        R3.start();
        ThreadDemo R4 = new ThreadDemo( "challenge4.dat");
        R4.start();
        ThreadDemo R5 = new ThreadDemo( "challenge5.dat");
        R5.start();
    }
}

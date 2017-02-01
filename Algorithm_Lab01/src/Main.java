import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Created by Jimin on 1/27/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ShortestPath shortestPath = new ShortestPath();
        int[][] data = shortestPath.readData("rtest1.dat");
        double[][] dis = shortestPath.calDistance(data);
        shortestPath.reorder(dis);
//        ShortestPath shortestPath = new ShortestPath();
//        int[][] new_data = shortestPath.readData("rtest1.dat");
//        int x=2;
//        int y=8;
//
//        int j = y;
//        for(int i=x; i < (y+x)/2; i++) {
//            int temp_x2 = 0;
//            int temp_y2 = 0;
//            temp_x2 = new_data[i][0];
//            temp_y2 = new_data[i][1];
//
//            new_data[i][0] = new_data[j][0];
//            new_data[i][1] = new_data[j][1];
//
//            new_data[j][0] = temp_x2;
//            new_data[j][1] = temp_y2;
//            j--;
//        }
//
//        for(int i =0; i< 12 ; i++) {
//            System.out.println(new_data[i][0] + "    " + new_data[i][1]);
//        }
    }
}

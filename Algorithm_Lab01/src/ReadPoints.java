/**
 * Created by Jimin on 1/25/17.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadPoints {
    int[][] data = new int[2000][2000];
    public int[][] readData(String dataFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dataFile));
        String line;
        int count = 0;
        for(int i = 0; i<count; i++) {
            for(int j = 0; j<count; j++) {
                data[i][j] = 0;
            }
        }
        while ((line = br.readLine()) != null) {
            data[count][0] = Integer.parseInt(line.split("   ")[0]);
            data[count][1] = Integer.parseInt(line.split("   ")[1]);
            count++;
        }
//        calDistance(data, count);

        br.close();
        return data;
    }

    public String calDistance(int[][] data, int count) throws IOException {
        double[][] dis = new double[count][count];
        String ordered_data = "";
//        for(int i = 0 ; i < count ; i++) {
//            for (int j = 0; j< count ; j++) {
//                dis[i][j] = 0 ;
//            }
//        }

        for(int i = 0; i<count; i++) {
            for (int j = i+1; j<count; j++ ) {
                double x = data[i][0] - data[j][0];
                double y = data[i][1] - data[j][1];
                dis[i][j] = Math.sqrt(x * x + y * y);
                dis[j][i] = Math.sqrt(x * x + y * y);
            }
        }

        //nearest neighbor
        int start = 0;
//        ordered_data += data[0][0] + "   " +data[0][1] + "\n";
        for(int i = 0; i < count; i++) {
            double small = 999999;
            int next = 0;

            for (int j = 0; j < count; j++ ) {
                if(dis[start][j] != 0 && small > dis[start][j]) {
                    small = dis[start][j];
                    next = j;
                }
            }
            ordered_data += data[next][0] + "   " +data[next][1] + "\n";

            start = next;
            for(int x = 0; x < count ; x++ ) {
                dis[x][next] = 0;
            }
            dis[i][next] = 0;
            dis[next][i] = 0;
        }

        System.out.println(ordered_data);
        writeData(ordered_data);
        return ordered_data;
    }

    public void writeData(String num) throws IOException {
        Files.write(Paths.get("rtest11.dat"), num.getBytes(), StandardOpenOption.APPEND);
    }

    public void print(int count, double[][] dis) {
        for(int i = 0 ; i<count; i++) {
            for (int j = 0; j<count; j++ ) {
                System.out.print(dis[i][j]);
                System.out.print("\t\t\t\t\t");
            }
            System.out.println("");
        }
    }
}

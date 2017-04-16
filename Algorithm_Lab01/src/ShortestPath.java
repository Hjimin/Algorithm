/**
 * Created by Jimin on 1/25/17.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ShortestPath {
    int[][] data = new int[2000][2000];
    static int count = 0;

    public int[][] readData(String dataFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dataFile));
        String line;
        int num;
        for(int i = 0; i<count; i++) {
            for(int j = 0; j<count; j++) {
                data[i][j] = 0;
            }
        }
        num = Integer.parseInt(br.readLine());
        while ((line = br.readLine()) != null) {
            data[count][0] = Integer.parseInt(line.split("   ")[0]);
            data[count][1] = Integer.parseInt(line.split("   ")[1]);
            count++;
        }

        br.close();
        return data;
    }

    public double[][] calDistance(int[][] data) {
        double[][] dis = new double[count][count];
        for(int i = 0; i<count; i++) {
            for (int j = i+1; j<count; j++ ) {
                double x = data[i][0] - data[j][0];
                double y = data[i][1] - data[j][1];
                dis[i][j] = Math.sqrt(x * x + y * y);
                dis[j][i] = Math.sqrt(x * x + y * y);
            }
        }
        return dis;
    }


    //nearest neighbor
    public void reorder(double[][] dis) {
        int[][] new_data = new int[count][count];

        //String ordered_data = "";
        int start = 0;
        for(int i = 0; i < count; i++) {
            double small = 999999;
            int next = 0;
            for (int j = 0; j < count; j++ ) {
                if(dis[start][j] != 0 && small > dis[start][j]) {
                    small = dis[start][j];
                    next = j;
                }
            }
            new_data[i][0] = data[next][0];
            new_data[i][1] = data[next][1];

            start = next;
            for(int x = 0; x < count ; x++ ) {
                dis[x][next] = 0;
            }
            dis[i][next] = 0;
            dis[next][i] = 0;
        }

        onceMore(new_data);
    }

    public void onceMore(int[][] new_data) {
        String ordered_data = "";
        double[][] dis2 = calDistance(new_data);

        for(int i = 0; i<count-4; i++) {
            for (int j= i+2; j< count - 1; j++) {
                if(dis2[i][i+1] + dis2[j][j+1] > dis2[i][j]+dis2[i+1][j+1]) {
                    new_data = reverse(i+1, j, new_data);
                    dis2 = calDistance(new_data);
                }
            }
        }

        ordered_data = "";

        double[][] dis = calDistance(new_data);
        int temp_x = 0;
        int temp_y = 0;

        for(int i = 0 ; i < count-3; i++) {
            if(dis[i][i+1] + dis[i+2][i+3] > dis[i][i+2] + dis[i+1][i+3]) {
                temp_x = new_data[i + 1][0];
                temp_y = new_data[i + 1][1];

                new_data[i + 1][0] = new_data[i + 2][0];
                new_data[i + 1][1] = new_data[i + 2][1];

                new_data[i + 2][0] = temp_x;
                new_data[i + 2][1] = temp_y;
            }
        }

        for(int i =0 ; i<count ; i++ ) {
            ordered_data += new_data[i][0] + "   " + new_data[i][1] + "\n";
        }
        writeData(ordered_data, "rtest11.dat");
    }

    public int[][] reverse(int x, int y, int[][] new_data){
        int j = y;
        for(int i=x; i < (y+x)/2; i++) {
            int temp_x2 = 0;
            int temp_y2 = 0;
            temp_x2 = new_data[i][0];
            temp_y2 = new_data[i][1];

            new_data[i][0] = new_data[j][0];
            new_data[i][1] = new_data[j][1];

            new_data[j][0] = temp_x2;
            new_data[j][1] = temp_y2;
            j--;
        }
        return new_data;
    }

    public void writeData(String num, String name) {
        try {
            Files.write(Paths.get(name), num.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error IOException");
        }
    }
}

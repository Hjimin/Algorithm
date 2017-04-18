/**
 * Created by Jimin on 1/25/17.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ShortestPath {
    int[][] data = new int[3000][2];
    int count = 0;

    public int[][] readData(String dataFile) throws IOException {
        Scanner in = new Scanner( new BufferedReader(new FileReader(dataFile)));
        int cc=2999;
        int shorte = Integer.MAX_VALUE;
        while (in.hasNext()) {
            data[count][0] = in.nextInt();
            data[count][1] = in.nextInt();
            count++;
        }

        int tempx,tempy;

        for(int i=0; i<count-1;i++){
            if((data[i][0] + data[i][1]) > (data[i+1][0]+data[i+1][1])) {
                tempx = data[i][0];
                tempy = data[i][1];
                data[i][0] = data[i+1][0];
                data[i][1] = data[i+1][1];
                data[i+1][0] = tempx;
                data[i+1][1] = tempy;
            }
        }

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
    public int[][] reorder(double[][] dis) {
        int[][] new_data = new int[count][count];

        //String ordered_data = "";
        int start = 0;
        for(int i = 0; i < count; i++) {
            double small = Integer.MAX_VALUE;
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

        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);
        new_data = onceMore(new_data);

        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        return new_data;
    }




    public int[][] onceMore(int[][] new_data) {
        System.out.println("oneMore!");
        int temp_x = 0;
        int temp_y = 0;

        double[][] dis = calDistance(new_data);

        for(int i = 0; i<count-1; i++) {
            for (int j= i+2; j< count - 1; j++) {
                if(i<count-4) {
                    if (dis[i][i + 1] + dis[j][j + 1] > dis[i][j] + dis[i + 1][j + 1]) {
                        new_data = reverse(i + 1, j, new_data);
                        dis = calDistance(new_data);
                    }
                }

                if(j<count-3) {
                    if((dis[i][i+1] + dis[j][j+1] + dis[j+1][j+2])
                            > (dis[i][j+1] + dis[i+1][j+1] + dis[j][j+2])) {
                        if((i+1) < j) {
                            temp_x = new_data[j + 1][0];
                            temp_y = new_data[j + 1][1];
                            for (int x = j; x >= (i + 1); x--) {
                                new_data[x + 1][0] = new_data[x][0];
                                new_data[x + 1][1] = new_data[x][1];

                            }
                            new_data[i + 1][0] = temp_x;
                            new_data[i + 1][1] = temp_y;
                            dis = calDistance(new_data);
                        } else if((j+2)<i){
                            temp_x = new_data[j+1][0];
                            temp_y = new_data[j+1][1];
                            for(int x = j+2 ; x <= i ; x++) {
                                new_data[x-1][0] = new_data[x][0];
                                new_data[x-1][1] = new_data[x][1];
                            }
                            new_data[i][0] = temp_x;
                            new_data[i][1] = temp_y;
                            dis = calDistance(new_data);
                        }
                    }

                }
            }
            if(i<count-3) {
                if (dis[i][i + 1] + dis[i + 2][i + 3] > dis[i][i + 2] + dis[i + 1][i + 3]) {
                    temp_x = new_data[i + 1][0];
                    temp_y = new_data[i + 1][1];

                    new_data[i + 1][0] = new_data[i + 2][0];
                    new_data[i + 1][1] = new_data[i + 2][1];

                    new_data[i + 2][0] = temp_x;
                    new_data[i + 2][1] = temp_y;
                    dis = calDistance(new_data);
                }
            }
        }

        System.out.println("here1");
        for(int i = 0 ; i < count-3; i++) {
            if(dis[i][i+1] + dis[i+2][i+3] > dis[i][i+2] + dis[i+1][i+3]) {
                temp_x = new_data[i + 1][0];
                temp_y = new_data[i + 1][1];

                new_data[i + 1][0] = new_data[i + 2][0];
                new_data[i + 1][1] = new_data[i + 2][1];

                new_data[i + 2][0] = temp_x;
                new_data[i + 2][1] = temp_y;
                dis = calDistance(new_data);
            }
        }


        System.out.println("here2");
        double[][] dis3 = calDistance(new_data);
        for(int i=0; i<count-1 ;i++) {
            for(int j=0; j<count-3; j++) {
               if((dis3[i][i+1] + dis3[j][j+1] + dis3[j+1][j+2])
                       > (dis3[i][j+1] + dis3[i+1][j+1] + dis3[j][j+2])) {
                   if((i+1) < j) {
                       temp_x = new_data[j + 1][0];
                       temp_y = new_data[j + 1][1];
                       for (int x = j; x >= (i + 1); x--) {
                           new_data[x + 1][0] = new_data[x][0];
                           new_data[x + 1][1] = new_data[x][1];

                       }
                       new_data[i + 1][0] = temp_x;
                       new_data[i + 1][1] = temp_y;
                       dis3 = calDistance(new_data);
                   } else if((j+2)<i){
                       temp_x = new_data[j+1][0];
                       temp_y = new_data[j+1][1];
                       for(int x = j+2 ; x <= i ; x++) {
                           new_data[x-1][0] = new_data[x][0];
                           new_data[x-1][1] = new_data[x][1];
                       }
                       new_data[i][0] = temp_x;
                       new_data[i][1] = temp_y;
                       dis3 = calDistance(new_data);
                   }
               }
            }
        }


        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);
        new_data = recconect(new_data);

        System.out.println("here3");
        return new_data;
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

    public void writeData(int[][] new_data, String num) {
        String ordered_data ="";
        for(int i =0 ; i<count ; i++ ) {
            ordered_data += new_data[i][0] + "   " + new_data[i][1] + "\n";
        }

        try {
            Files.write(Paths.get(num), ordered_data.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error IOException");
        }
    }
    public int[][] recconect2(int[][] new_data) {
        int temp_a = 0;
        int temp_b = 0;
        int temp_c = 0;
        double large = Double.MIN_VALUE;
        double small = Double.MAX_VALUE;

        double[][] dis = calDistance(new_data);

        for(int i=0; i<count-1; i++) {
            if (large < dis[i][i+1]) {
                large = dis[i][i+1];
                temp_a = i;
            }
        }

        for(int i=1; i<count-10; i++ ){
            if(dis[temp_a][i] < small && temp_a != i ) {
                if(temp_a > i && temp_a-i >= 2) {
                    small = dis[temp_a][i];
                    temp_b = i;
                } else if(i>temp_a && i-temp_a>=2){
                    small = dis[temp_a][i];
                    temp_b = i;
                }
            }
        }
        for(int i=1; i<count-10; i++ ){
            if(dis[temp_a+1][i] < small && (temp_a+1) != i ) {
                if((temp_a+1) > i && (temp_a+1)-i >= 3) {
                    small = dis[temp_a+1][i];
                    temp_c = i;
                } else if(i>(temp_a+1) && i-(temp_a+1)>=3){
                    small = dis[temp_a+1][i];
                    temp_c = i;
                }
            }
        }
//        System.out.println(temp_a);
//        System.out.println(temp_b);
//        System.out.println(temp_c);

        System.out.println(large);


        int temp_x, temp_y;
        temp_x = new_data[temp_a][0];
        temp_y = new_data[temp_a][1];
        int temp2_x, temp2_y;
        temp2_x = new_data[temp_a+1][0];
        temp2_y = new_data[temp_a+1][1];
        if(temp_a>temp_b+1) {
            if(temp_a>temp_c+1) {
                if(temp_b-1>temp_c+1) {
                    System.out.println("aa");
                    //a>b>c
                    for(int i=temp_a-1; i>=temp_b; i--)
                    {
                        new_data[i+2][0] = new_data[i][0];
                        new_data[i+2][1] = new_data[i][1];
                    }
                    new_data[temp_b+1][0] = temp_x;
                    new_data[temp_b+1][1] = temp_y;
                    for(int i=temp_b-1; i>=temp_c; i--)
                    {
                        new_data[i+1][0] = new_data[i][0];
                        new_data[i+1][1] = new_data[i][1];
                    }
                    new_data[temp_c][0] = temp2_x;
                    new_data[temp_c][1] = temp2_y;
                } else if(temp_c-1> temp_b+1){
                    System.out.println("bb");
                    //a>c>b
                    for(int i=temp_a-1; i>=temp_c; i--)
                    {
                        new_data[i+2][0] = new_data[i][0];
                        new_data[i+2][1] = new_data[i][1];
                    }
                    new_data[temp_c+1][0] = temp2_x;
                    new_data[temp_c+1][1] = temp2_y;
                    for(int i=temp_c-1; i>=temp_b; i--)
                    {
                        new_data[i+1][0] = new_data[i][0];
                        new_data[i+1][1] = new_data[i][1];
                    }
                    new_data[temp_b][0] = temp_x;
                    new_data[temp_b][1] = temp_y;
                } else {
                     System.out.println(temp_a);
            System.out.println(temp_b);
            System.out.println(temp_c);
                }
            } else if(temp_c-1> temp_a+1){
                System.out.println("cc");
                //c>a>b
                for(int i=temp_a-1; i>=temp_b; i--)
                {
                    new_data[i+1][0] = new_data[i][0];
                    new_data[i+1][1] = new_data[i][1];
                }
                new_data[temp_b][0] = temp_x;
                new_data[temp_b][1] = temp_y;
                for(int i=temp_a+2; i<=temp_c; i++)
                {
                    new_data[i-1][0] = new_data[i][0];
                    new_data[i-1][1] = new_data[i][1];
                }
                new_data[temp_c][0] = temp2_x;
                new_data[temp_c][1] = temp2_y;

            } else {
                 System.out.println(temp_a);
            System.out.println(temp_b);
            System.out.println(temp_c);
            }
        } else if(temp_b> temp_a+1){
            if(temp_a>temp_c+1) {
                System.out.println("dd");
                //b>a>c
                for(int i=temp_a-1; i>=temp_c; i--)
                {
                    new_data[i+1][0] = new_data[i][0];
                    new_data[i+1][1] = new_data[i][1];
                }
                new_data[temp_c][0] = temp2_x;
                new_data[temp_c][1] = temp2_y;
                for(int i=temp_a+2; i<=temp_b; i++)
                {
                    new_data[i-1][0] = new_data[i][0];
                    new_data[i-1][1] = new_data[i][1];
                }
                new_data[temp_b][0] = temp_x;
                new_data[temp_b][1] = temp_y;

            } else if(temp_c-1> temp_a+1){
                if(temp_b-1>temp_c+1) {
                    System.out.println("ee");
                    //b>c>a
                    for(int i=temp_a+2; i<=temp_c; i++)
                    {
                        new_data[i-2][0] = new_data[i][0];
                        new_data[i-2][1] = new_data[i][1];
                    }
                    new_data[temp_c-1][0] = temp2_x;
                    new_data[temp_c-1][1] = temp2_y;
                    for(int i=temp_c+2; i<=temp_b; i++)
                    {
                        new_data[i-1][0] = new_data[i][0];
                        new_data[i-1][1] = new_data[i][1];
                    }
                    new_data[temp_b][0] = temp_x;
                    new_data[temp_b][1] = temp_y;
                } else if(temp_c> temp_b+1){
                    System.out.println("ff");
                    //c>b>a
                    for(int i=temp_a+2; i<=temp_b; i++)
                    {
                        new_data[i-2][0] = new_data[i][0];
                        new_data[i-2][1] = new_data[i][1];
                    }
                    new_data[temp_b-1][0] = temp_x;
                    new_data[temp_b-1][1] = temp_y;
                    for(int i=temp_b+2; i<=temp_c; i++)
                    {
                        new_data[i-1][0] = new_data[i][0];
                        new_data[i-1][1] = new_data[i][1];
                    }
                    new_data[temp_c][0] = temp2_x;
                    new_data[temp_c][1] = temp2_y;
                } else {
                    System.out.println("33");
                     System.out.println(temp_a);
                        System.out.println(temp_b);
                    System.out.println(temp_c);
                }
            } else {
                System.out.println("qq");
                 System.out.println(temp_a);
            System.out.println(temp_b);
            System.out.println(temp_c);
            }
        } else {
            System.out.println(temp_a);
            System.out.println(temp_b);
            System.out.println(temp_c);
        }

        return new_data;
    }
    public int[][] recconect(int[][] new_data) {
        int temp_x = 0;
        int temp_y = 0;
        double large = Double.MIN_VALUE;
        double small = Double.MAX_VALUE;

        double[][] dis = calDistance(new_data);

        for(int i=0; i<count-1; i++) {
            if (large < dis[i][i+1]) {
                large = dis[i][i+1];
                temp_x = i;
            }
        }
        System.out.println(temp_x);

        for(int i=0; i<count-1; i++ ){
            if(dis[temp_x][i] < small && temp_x != i ) {
                if(temp_x > i && temp_x-i >= 3) {
                    small = dis[temp_x][i];
                    temp_y = i;
                } else if(i>temp_x && i-temp_x>=1){
                    small = dis[temp_x][i];
                    temp_y = i;
                }
            }
        }
        System.out.println(temp_y);

        int x,y;
        if((temp_x + 3)< temp_y) {
            System.out.println("dd");
            x = new_data[temp_x][0];
            y = new_data[temp_x][1];
            for(int i=temp_x+1; i<=temp_y; i++) {
                new_data[i-1][0] = new_data[i][0];
                new_data[i-1][1] = new_data[i][1];
            }
            new_data[temp_y][0] = x;
            new_data[temp_y][1] = y;
        }

        if((temp_y + 1) < temp_x) {
            System.out.println("cd");
            x = new_data[temp_x][0];
            y = new_data[temp_x][1];
            for(int i=temp_x-1; i>=temp_y+1; i--) {
                new_data[i+1][0] = new_data[i][0];
                new_data[i+1][1] = new_data[i][1];
            }
            new_data[temp_y][0] = x;
            new_data[temp_y][1] = y;
            System.out.println(new_data[temp_y][0]);
            System.out.println(new_data[temp_y][1]);
        }


        return new_data;
    }
}

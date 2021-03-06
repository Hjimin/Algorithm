import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jimin on 2/24/17.
 */
public class Main {
    static int[][] s = new int[9][9];
    static int[][] M;
    public static void main(String argv[]) {
        int[] shops = new int[] {20,18,47,44,53,67,95,93,88};
        int[][] secondary = new int[9][9];

        for(int i = 0 ; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(i!=j) {
                    secondary[i][j] = problemA(shops[i], shops[j]);
                } else {
                    secondary[i][j] = 50;
                }
                System.out.print(secondary[i][j] + "  ");
            }
            System.out.println(" ");
        }
        for(int i = 0 ; i<9; i++) {
            for(int j=0; j<9; j++) {
                s[i][j] = secondary[i][j];
            }
        }

        M = problemB(secondary);
        for(int i = 0 ; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(M[i][j] == 1) {
                    System.out.print("i : " + i);
                    System.out.print(" j : " + j);
                }
            }
            System.out.println(" ");
        }
    }

    public static int[][] problemB(int[][] arr){
        Secondary secondary = new Secondary(arr, arr.length);
        secondary.find();
        int[][] M = secondary.getM();
//        for(int i=0; i<9; i++) {
//            for(int j=0; j<9; j++){
//                if(M[i][j] == 1) {
//                    System.out.print(s[i][j] + " ");
//                } else {
//                    System.out.print("0 ");
//                }
//            }
//            System.out.println(" ");
//        }
        return M;
    }

    public static int problemA(int from, int to){
        CityMap map = new CityMap();
        map.makeMap();
        int[][] city_map = map.getCityMap();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(from);
        FindRoute findRoute1 = new FindRoute(city_map);
        findRoute1.find(from, to, list);
        list = findRoute1.getShortest();
        return list.size()-1;
    }
}

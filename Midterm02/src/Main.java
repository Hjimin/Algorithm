import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jimin on 2/24/17.
 */
public class Main {
    public static void main(String argv[]) {
        int[] shops = new int[] {20,18,47,44,53,67,95,93,88};
        int[][] secondary = new int[9][9];

        for(int i = 0 ; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(i!=j) {
                    secondary[i][j] = dis(shops[i], shops[j]);
                } else {
                    secondary[i][j] = 50;
                }
//                System.out.print(secondary[i][j] + "  ");
            }
//            System.out.println(" ");
        }
        problemB(secondary);
    }

    public static void problemB(int[][] arr){
        Secondary secondary = new Secondary(arr);
        secondary.find();

    }

    public static int dis(int from, int to){
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
    public static int problemA(int from, int to){
        CityMap map = new CityMap();
        map.makeMap();
        int[][] city_map = map.getCityMap();
        ArrayList<Integer> final_list;

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(from);
        FindRoute findRoute1 = new FindRoute(city_map);
        findRoute1.find(from, to, list);
        list = findRoute1.getShortest();

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(to);
        FindRoute findRoute2 = new FindRoute(city_map);
        findRoute2.find(to, from, list2);
        list2 = findRoute2.getShortest();

        if(list.size() < list2.size()) {
            final_list = list;
        } else {
            final_list = list2;
        }
//        findRoute2.print(final_list);
//        System.out.println(final_list.size()-1);
        return final_list.size()-1;

    }

}

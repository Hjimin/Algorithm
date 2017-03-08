import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jimin on 2/24/17.
 */
public class Main {
    
    public static void main(String argv[]) {
        CityMap map = new CityMap();
        map.makeMap();
        int[][] city_map = map.getCityMap();
        ArrayList<Integer> final_list;

        Scanner scanner = new Scanner(System.in);
        System.out.print("input x : ");
        int from = scanner.nextInt();
        System.out.print("input y : ");
        int to = scanner.nextInt();

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
        findRoute2.print(final_list);
    }
}

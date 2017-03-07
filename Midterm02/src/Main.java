import java.util.Scanner;

/**
 * Created by Jimin on 2/24/17.
 */
public class Main {
    
    public static void main(String argv[]) {
        //fr.findRoute(0, 0, 1, 2);
        CityMap map = new CityMap();
        map.makeMap();
        int[][] city_map = map.getCityMap();

//        FindRoute fr = new FindRoute(city_map);
        Scanner scanner = new Scanner(System.in);
        System.out.print("input x : ");
        int from = scanner.nextInt();
        System.out.print("input y : ");
        int to = scanner.nextInt();

        CityTree cityTree = new CityTree(city_map, from, to);
        cityTree.makeTree(from, to);

    }
}

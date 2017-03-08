import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/8/17.
 */
public class ProblemCMain {
    static ArrayList<Character> shortest_list = new ArrayList<Character>();
    static int shortest;
    public static void main(String argv[]) {
        int[] shops = new int[]{20, 18, 47, 44, 53, 67, 95, 93, 88, 66};
        int size = shops.length;
        int[][] secondary = new int[size][size];
        int[][] secondary2 = new int[size][size];
        String data = "";
        CreateSolution cs = new CreateSolution();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    secondary[i][j] = problemA(shops[i], shops[j]);
                    secondary2[i][j] = problemA(shops[i], shops[j]);

                } else {
                    secondary[i][j] = 50;
                    secondary2[i][j] = 50;
                }
            }
        }
        problemC(secondary2);
        Iterator<Character> itr = shortest_list.iterator();
        data = "Shortest tour length: " + shortest + "\t\t Path: " + "W-";
        while (itr.hasNext()) {
            data += itr.next() + "-";
        }
        data += "W";
        cs.writeDataToFile(data, "TheCornerStore-(c)");
    }

    public static void problemC(int[][] arr) {
        Permutation permutation = new Permutation(9, arr);
        permutation.getPermutation();
//        permutation.print();
        shortest_list = permutation.getShortest_list();
        shortest = permutation.getShortest();
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

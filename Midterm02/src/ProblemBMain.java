import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/8/17.
 */
public class ProblemBMain {
    public static void main(String argv[]) {
        int[] shops = new int[] {20,18,47,44,53,67,95,93,88};
        int size = shops.length;
        int[][] secondary = new int[size][size];
        int[][] secondary2 = new int[size][size];
        int[][] M;
        String data;
        char from,to;
        CreateSolution cs = new CreateSolution();

        for(int i = 0 ; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(i!=j) {
                    secondary[i][j] = problemA(shops[i], shops[j]);
                    secondary2[i][j] = problemA(shops[i], shops[j]);

                } else {
                    secondary[i][j] = 50;
                    secondary2[i][j] = 50;
                }
            }
        }

        M = problemB(secondary);

        for(int i = 0 ; i<size; i++) {
            from = (char)(65+i);
            for(int j=0; j<size; j++) {
                if(M[i][j] == 1) {
                    to = (char) (65 + j);
                    data = from + " matched " + to;
                    data += "\n";
                    System.out.println(data);
                    cs.writeDataToFile(data, "TheCornerStore-(b)");
                }
            }
        }
    }

    public static int[][] problemB(int[][] arr){
        Secondary secondary = new Secondary(arr, arr.length);
        secondary.find();
        int[][] M = secondary.getM();
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

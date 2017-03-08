import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/8/17.
 */
public class ProblemAMain {
    public static void main(String argv[]) {
        CreateSolution cs = new CreateSolution();
        int size;
        int[] shops = new int[] {20,18,47,44,53,67,95,93,88,66};
        size = shops.length;
        String data="";
        char from,to;

        for(int i = 0 ; i<size; i++) {
            if(i==size-1){
                from = 'W';
            } else {
                from = (char)(65+i);
            }
            for(int j=0; j<size; j++) {
                if(i!=j) {
                    if(j == size-1) {
                        to = 'W';
                    } else {
                        to = (char) (65 + j);
                    }
                    data += from + " to " + to + "\tdistance: "
                            + String.format("%2s",shortestPath(shops[i], shops[j]).size() - 1);
                    data += "\t\tpath: ";
                    Iterator<Integer> itr = shortestPath(shops[i], shops[j]).iterator();
                    while(itr.hasNext()) {
                        int next = itr.next();
                        data += next + " ";
                    }
                    data += "\n";
                }
            }
            data += "\n\n\n";
            System.out.println(" ");
        }
        System.out.println(data);
        cs.writeDataToFile(data, "TheCornerStore-(a)");
    }

    public static ArrayList<Integer> shortestPath(int from, int to){
        CityMap map = new CityMap();
        map.makeMap();
        int[][] city_map = map.getCityMap();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(from);
        FindRoute findRoute1 = new FindRoute(city_map);
        findRoute1.find(from, to, list);
        list = findRoute1.getShortest();
        return list;
    }
}

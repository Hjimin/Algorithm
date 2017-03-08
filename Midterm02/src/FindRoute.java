import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/7/17.
 */
public class FindRoute {
    int[][] city_map;
    int size=9999999;
    ArrayList<Integer> shortest;

    public FindRoute(int[][] cityMap){
        this.city_map = cityMap;
    }

    public ArrayList<Integer> find(int from, int to, ArrayList<Integer> old){
        ArrayList<Integer> new_route;
        for(int i=0; i<100; i++) {
            if(city_map[from][i] == 1 && old.size()<=20 && !old.contains(i)) {
                if(i == to) {
                    new_route = new ArrayList<Integer>();
                    new_route.addAll(old);
                    new_route.add(i);
                    if(size > new_route.size()) {
                        shortest= new_route;
                        size=new_route.size();
                    }
                    return new_route;
                }
                new_route = new ArrayList<Integer>();
                new_route.addAll(old);
                new_route.add(i);
                find(i, to, new_route);
            }
        }
        return null;
    }

    public ArrayList<Integer> getShortest(){
        return shortest;
    }

    public void print(ArrayList<Integer> arrayList){
        Iterator<Integer> li = arrayList.iterator();
        while(li.hasNext()) {
            System.out.print(li.next() + " ");
        }
        System.out.println(" ");
    }
}

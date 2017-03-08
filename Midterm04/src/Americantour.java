import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/5/17.
 */
public class Americantour {
    int[][] tour;
    int distance = 0;
    int shortest=Integer.MAX_VALUE;

    public Americantour(int[][] tour) {
        this.tour = tour;
    }

    public void getDistance(ArrayList<ArrayList<Integer>> lists2) {
        Iterator<ArrayList<Integer>> itr4 = lists2.iterator();
        while ((itr4.hasNext())) {
            cal(itr4.next());
//            Iterator<Integer> itr3 = itr4.next().iterator();
//            while (itr3.hasNext()) {
////                System.out.print(itr3.next());
//            }
//            System.out.println(" ");
        }
    }

    public int cal(ArrayList<Integer> selected ) {//,int count) {
        int i, from, to;
        distance=0;

        for(i=0; i<selected.size()-1; i++) {
            from = selected.get(i);
            to = selected.get(i + 1);
            distance += tour[from][to];
        }
        from = selected.get(i);
        to = selected.get(0);
        distance += tour[from][to];
//        System.out.println(distance);

        if(shortest > distance) {
            shortest = distance;
            Iterator<Integer> itr2 = selected.iterator();
            while(itr2.hasNext()) {
                int use = itr2.next();
                System.out.print(use);
            }
            System.out.println(" dis: "+shortest );//+ " count: " + count);
            return distance;
        }
        return -1;
    }
}
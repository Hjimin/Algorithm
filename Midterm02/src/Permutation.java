import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/8/17.
 */

public class Permutation {
    int perm_num;
    ArrayList<Character> cityTour = new ArrayList<Character>();
    int[][] city_tour;
    int size;
    int shortest = Integer.MAX_VALUE;
    ArrayList<Character> shortest_list = new ArrayList<Character>();

    public Permutation(int perm_num, int[][] city_tour) {
        this.perm_num = perm_num;
        char c;
        for(int i=0 ; i<9; i++) {
            c = (char)(65+i);
            cityTour.add(c);
        }
        this.city_tour = city_tour;
        this.size = city_tour.length;
    }

    public void getPermutation() {
            Iterator<Character> itr2 = cityTour.iterator();
            while (itr2.hasNext()) {
                ArrayList<Character> newS = new ArrayList<Character>();
                permute2(itr2.next(), newS, cityTour);
            }
    }

    public void permute2(char shop, ArrayList<Character> perm, ArrayList<Character> cityTour) {
        boolean flag = true;

        if(perm.contains(shop)) {
            flag = false;
        }

        if(flag == true) {
            perm.add(shop);
            Iterator<Character> itr2 = cityTour.iterator();
            if(perm.size() == perm_num) {
                calDis(perm);
//                count++;
//                Iterator<Character> itr = perm.iterator();
//                while(itr.hasNext()) {
//                    char use = itr.next();
//                    System.out.print(use);
//                }
//                System.out.println(" count  " + count);
            }

            while(itr2.hasNext()) {
                Character use = itr2.next();
                ArrayList<Character> aa = new ArrayList<Character>();
                aa.addAll(perm);
                permute2(use, aa, cityTour);
            }
        }
    }

    public void calDis(ArrayList<Character> list) {
        Iterator<Character> itr = list.iterator();
        int total=0;
        int from, to;
        from = 9;
        while(itr.hasNext()) {
            to = itr.next() - 65;
            total += city_tour[from][to];
            from = to;
        }
        total += city_tour[from][9];

        if(shortest > total) {
            shortest = total;
            shortest_list.clear();
            shortest_list.addAll(list);
        }
    }

    public void print(){
        Iterator<Character> itr = shortest_list.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next());
        }
        System.out.println(shortest);
    }

    public ArrayList<Character> getShortest_list() {
        return shortest_list;
    }

    public int getShortest(){
        return shortest;
    }


}

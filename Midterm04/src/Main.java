import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/3/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists;
        ArrayList<ArrayList<Integer>> lists2;
        //read .dat
        ReadData rd = new ReadData();
        int[][] dis = rd.readData();

        //Combination 10 out of 16
        Combination cm = new Combination(10, 16);
        cm.getCombination();
        lists = cm.getAllTheList();
//        print(lists);


        //Permutation 9! for each Combination
        Permutation pm = new Permutation(9);
        pm.getPermutation(lists);
        lists2 = pm.getAllTheLists();
//        print(lists2);

        //calculate distance
        Americantour at = new Americantour(dis);
        at.getDistance(lists2);

//        Iterator<ArrayList<Integer>> itr4 = lists2.iterator();
//        while ((itr4.hasNext())) {
//            at.cal(itr4.next());
//            Iterator<Integer> itr3 = itr4.next().iterator();
//            while (itr3.hasNext()) {
////                System.out.print(itr3.next());
//            }
//            System.out.println(" ");
//        }

//            count++;
//            System.out.println(" " + count);

//
//        long start = System.currentTimeMillis();
//        for(int i=0 ; i<8; i++){
//            ArrayList<Integer> newS = new ArrayList<Integer>();
//            pm.permute2(i,newS);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("time " +(end-start)/1000);
//        pm.printCount();
    }
    public static void print(ArrayList<ArrayList<Integer>> lists) {
        int count = 0;
        Iterator<ArrayList<Integer>> itr4 = lists.iterator();
        while ((itr4.hasNext())) {
            Iterator<Integer> itr3 = itr4.next().iterator();
            count++;
            while (itr3.hasNext()) {
                System.out.print(itr3.next());
            }
            System.out.println(" " );
        }
        System.out.println("count : " + count);
    }
}

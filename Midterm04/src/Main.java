import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/3/17.
 */
public class Main {
    public static void main(String[] args) {
        ReadData rd = new ReadData();
        int[][] dis = rd.readData();

        Americantour at = new Americantour(dis);

        Combination cm = new Combination(10, 12);
        ArrayList<ArrayList<Integer>> total;
        cm.start();
        total = cm.getTotal();

        Permutation pm = new Permutation(9, 9, at);

        int count = 0;
        Iterator<ArrayList<Integer>> itr = total.iterator();
        while(itr.hasNext()) {
            Iterator<Integer> itr2 = itr.next().iterator();
            int first = itr2.next();
//            System.out.println(first);
            while (itr2.hasNext()) {
                ArrayList<Integer> newS = new ArrayList<Integer>();
                pm.permute2(itr2.next(), newS);
            }
        }

        System.out.println("hahahhahahhaha");
        ArrayList<ArrayList<Integer>> total2 = pm.getTotal();
        Iterator<ArrayList<Integer>> itr4 = total2.iterator();
        while ((itr4.hasNext())) {
            at.cal(itr4.next());
//            Iterator<Integer> itr3 = itr4.next().iterator();
//            while (itr3.hasNext()) {
////                System.out.print(itr3.next());
//            }
//            System.out.println(" ");
        }

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
}

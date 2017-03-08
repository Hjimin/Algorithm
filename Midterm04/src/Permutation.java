import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/4/17.
 */
public class Permutation {
    int perm_num;
    int count=0;
    ArrayList<ArrayList<Integer>> total = new ArrayList<ArrayList<Integer>>();

    public Permutation(int perm_num) {
        this.perm_num = perm_num;
    }

    public void getPermutation(ArrayList<ArrayList<Integer>> lists) {
        Iterator<ArrayList<Integer>> itr = lists.iterator();
        while(itr.hasNext()) {
            ArrayList<Integer> lis = itr.next();
            Iterator<Integer> itr2 = lis.iterator();
            int first = itr2.next();
//            System.out.println(first);
            while (itr2.hasNext()) {
                ArrayList<Integer> newS = new ArrayList<Integer>();
                permute2(itr2.next(), newS, lis);
            }
        }
    }

    public void permute2(int num, ArrayList<Integer> perm, ArrayList<Integer> li) {
        boolean flag = true;

        if(perm.contains(num)) {
            flag = false;
        }

        if(flag == true) {
            perm.add(num);
            Iterator<Integer> itr2 = li.iterator();
            int first = itr2.next();
            if(perm.size() == perm_num) {
//                ArrayList<Integer> tmp = new ArrayList<Integer>();
//                tmp.addAll(perm);
                count++;
//                am.cal(tmp, count);
//                tmp.clear();
//                Iterator<Integer> itr2 = perm.iterator();
                perm.add(first);
                total.add(perm);
//                while(itr2.hasNext()) {
//                    int use = itr2.next();
//                    System.out.print(use);
//                }
//                System.out.println("count  " + count);
            }


            while(itr2.hasNext()) {
                int use = itr2.next();
                ArrayList<Integer> aa = new ArrayList<Integer>();
                aa.addAll(perm);
                permute2(use, aa, li);
            }

//            for(int i=0; i<perm_num; i++) {
//                ArrayList<Integer> aa = new ArrayList<Integer>();
//                aa.addAll(perm);
//                permute2(i, aa);
//            }
        }
    }

    public ArrayList<ArrayList<Integer>> getAllTheLists() {
        return total;
    }

    public void printCount(){
        System.out.println(count);
    }
}

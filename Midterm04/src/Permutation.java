import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/4/17.
 */
public class Permutation {
    int perm_num;
    int pick;
    int count=0;
    Americantour am;
    ArrayList<ArrayList<Integer>> total = new ArrayList<ArrayList<Integer>>();

    public Permutation(int perm_num, int pick, Americantour am) {
        this.perm_num = perm_num;
        this.pick = pick;
        this.am = am;
    }

    public void permute2(int num, ArrayList<Integer> perm) {
        boolean flag = true;

        if(perm.contains(num)) {
            flag = false;
        }

        if(flag == true) {
            perm.add(num);
            if(perm.size() == pick) {
//                ArrayList<Integer> tmp = new ArrayList<Integer>();
//                tmp.addAll(perm);
                count++;
//                am.cal(tmp, count);
//                tmp.clear();
//                Iterator<Integer> itr2 = perm.iterator();
                total.add(perm);
//                while(itr2.hasNext()) {
//                    int use = itr2.next();
//                    System.out.print(use);
//                }
//                System.out.println(" " + count);
            }

            for(int i=0; i<perm_num; i++) {
                ArrayList<Integer> aa = new ArrayList<Integer>();
                aa.addAll(perm);
                permute2(i, aa);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getTotal() {
        return total;
    }

    public void printCount(){
        System.out.println(count);
    }
}

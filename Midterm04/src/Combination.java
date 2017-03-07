import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Jimin on 3/6/17.
 */
public class Combination {
    int count=0;
    int pick_size;
    int size;
    ArrayList<ArrayList<Integer>> total = new ArrayList<ArrayList<Integer>>();

    public Combination(int pick_size, int size) {
        this.pick_size = pick_size;
        this.size = size;
    }

    public void start(){
        ArrayList<Integer> possible = new ArrayList<Integer>();
        for (int a = 0; a < size; a++) {
            possible.add(a);
        }

        for(int i=0; i<size; i++){
            ArrayList<Integer> com = new ArrayList<Integer>();
            com.add(i);
            combination(com, possible);
        }
    }

    public void  combination(ArrayList<Integer> com, ArrayList<Integer> possible){
        Iterator<Integer> itr = possible.iterator();
        ArrayList<Integer> new_list;

        while(itr.hasNext()) {
            int next = itr.next();
            if(!com.contains(next) && com.size() <= pick_size){
                new_list = new ArrayList<Integer>();
                new_list.addAll(com);
                new_list.add(next);
                if(new_list.size() == pick_size) {
                    count++;
//                    System.out.println(count);
                    total.add(new_list);
//                    print(new_list);
//                    Iterator<Integer> itr2 = new_list.iterator();
//                    while(itr2.hasNext()){
//                        ArrayList<Integer> newS = new ArrayList<Integer>();
//                        itr2.next();
//                        pm.permute2(itr2.next(), newS);
//                    }
                }
                combination(new_list, possible);
            } else {
                return;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getTotal(){
        return this.total;
    }

    public void print(ArrayList<Integer> arrayList){
        Iterator<Integer> li = arrayList.iterator();
        while(li.hasNext()) {
            System.out.print(li.next() + " ");
        }
        System.out.println(" ");
    }
}

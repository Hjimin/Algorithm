/**
 * Created by Jimin on 2/25/17.
 */


public class FindRoute {

    int[][] city_map;
    public FindRoute(int[][] city_map) {
        this.city_map = city_map;
    }
    public void findRoute(int from, int to) {
        //root == from
        //last child == to
        //need to find shortest
//        CityNode root = new CityNode();


    }

    private void creatTree(CityNode root, CityNode lastChild) {

    }

    private int calRoute(int x1, int y1, int x2, int y2){
        int dis =  0;
        if(x1 - x2 >= 0) {
           dis += (x1-x2);
        } else {
            dis += (x2-x1);
        }
        if(y1 - y2 >=0) {
            dis += (y1 - y2);
        } else {
            dis += (y2 - y1);
        }
        System.out.println("dis!!!!!" +dis);
       return dis;
    }


}

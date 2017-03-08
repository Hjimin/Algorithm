import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by Jimin on 2/24/17.
 */
public class CityMap {

    //String[][] city_map = new String[100][100];
    int[][] city_map = new int[100][100];

    //i*10 + j
    public void makeMap() {
        for(int i = 0; i < 100; i++) {
            for (int j = 0 ; j < 100; j++) {
                int num = j/10;
                if((j%2 == 0) && (i+10) == j) {
//                    city_map[i][j] = "ㅜ";
                    city_map[i][j] = 1;
                } else if( (j%2 != 0) && (i-10) == j) {
//                    city_map[i][j] = "ㅗ";
                    city_map[i][j] = 1;
                } else if((num%2 == 0) && (i+1)%10 != 0 && (i+1) == j) {
//                    city_map[i][j] = "ㅏ";
                    city_map[i][j] = 1;
                } else if ((num%2 != 0)&& (j+1)%10 != 0  && (i-1) == j){
//                    city_map[i][j] = "ㅓ";
                    city_map[i][j] = 1;
                } else {
//                    city_map[i][j] = " ";
                    city_map[i][j] = 0;
                }
            }
        }
//        printMap();
    }



    private void printMap () {
        for(int i=0; i < 100 ; i++) {
            System.out.print(i +" ");
            for(int j=0; j<100; j++) {
                System.out.print(city_map[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] getCityMap() {
        return city_map;
    }
}

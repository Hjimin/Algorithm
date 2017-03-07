/**
 * Created by Jimin on 3/1/17.
 */
public class AnalyzeDate {
    double[][] container;
    int[] needed;
    double[] fee;
    double[][] analyze; // 0 -> needed, 1 -> fee

    int max = 18;

    public AnalyzeDate(double[][] container) {
        this.container = container;
    }
    public double[][] analyze(){
        analyze = new double[container.length][3];
        for(int i = 0 ; i < container.length; i++) {
            analyze[i][0] = Math.ceil(container[i][0]/18); //number of container needed
            analyze[i][1] = container[i][1] / analyze[i][0]; //average fee of each container
            analyze[i][2] = container[i][0]; // total weight
        }
        return analyze;
    }

//    public int[] numberOfContainer() {
//        needed = new int[container.length];
//        for(int i = 0 ; i < container.length; i++) {
//            needed[i] = (int)Math.ceil(container[i][0]/18);
//        }
//        return needed;
//    }
//
//
//    public double[] averageFee() {
//        fee = new double[container.length];
//        for(int i =0 ; i<container.length; i++) {
//            fee[i] = container[i][1] / needed[i];
//        }
//
//        return fee;
//    }

    public void printData() {
        for(int i = 0 ; i < container.length; i++) {
            System.out.print(analyze[i][0] + "    ");
            System.out.println(analyze[i][1]);
        }
    }
}

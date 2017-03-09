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
        analyze = new double[container.length][5];
        for(int i = 0 ; i < container.length; i++) {
            analyze[i][0] = Math.ceil(container[i][0]/18); //number of container needed
            analyze[i][1] = container[i][1] / analyze[i][0]; //average fee of each container
            analyze[i][2] = container[i][0]; // total weight
            analyze[i][3] = container[i][1]; // total fee
            analyze[i][4] = container[i][2]; // shipping number
        }
        return analyze;
    }

    public double[][] getAnalyze(){
        return analyze;
    }

    public void printData() {
        for(int i = 0 ; i < container.length; i++) {
            System.out.print(analyze[i][2] + "    ");
            System.out.print(analyze[i][0] + "    ");
            System.out.println(analyze[i][1]);
        }
    }
}

/**
 * Created by Jimin on 3/1/17.
 */
public class Main {


    public static void main(String[] args) {
        ReadData rd = new ReadData();
        double[][] container = rd.readData();
        //rd.printDate();


        AnalyzeDate ad = new AnalyzeDate(container);
        double[][] data = ad.analyze();
        //ad.printData();
//        ad.printContainer();
//        ad.printFee();


        Shipping sh = new Shipping(data);
        sh.sorting();
        sh.choose();
//        sh.print();

    }
}

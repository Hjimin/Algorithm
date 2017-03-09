import java.text.DecimalFormat;

/**
 * Created by Jimin on 3/8/17.
 */
public class ProblemABMain {
    public static void main(String[] args) {
        CreateSolution cs = new CreateSolution();
        ReadData rd = new ReadData();
        double[][] container = rd.readData();
        String st="";

        AnalyzeDate ad = new AnalyzeDate(container);
        double[][] data = ad.analyze();
        DecimalFormat form = new DecimalFormat("#.##");
        for(int i=0; i<container.length; i++){
            st += "Shipping_num :"+String.format("%3s",(int)data[i][4])+"\t\tContainer_needed :"
                    +(int)data[i][0] + "\t\tAverage_fee :"+ form.format(data[i][1])+ "\n";
        }
        cs.writeDataToFile(st, "CargoShipLogistics-(a,b)");
        System.out.println(st);
    }
}

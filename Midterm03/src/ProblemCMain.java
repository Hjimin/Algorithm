import java.text.DecimalFormat;

/**
 * Created by Jimin on 3/8/17.
 */
public class ProblemCMain {
    public static void main(String[] args) {
        CreateSolution cs = new CreateSolution();
        ReadData rd = new ReadData();
        double[][] container = rd.readData();
        String st="";

        AnalyzeDate ad = new AnalyzeDate(container);
        double[][] data = ad.analyze();

        Shipping shipping = new Shipping(data);
        data = shipping.sorting();
        int end = shipping.choose();
        int total_weight =shipping.old_weight;
        double total_fee =shipping.old_fee;
        int total_container = shipping.old_num;
        st+= "Total_Weigh: " + total_weight + "\n\n";
        st+= "Total_Fee: " + total_fee +"\n\n";
        st+= "Total_container: " + total_container + "\n\n";
        st+="\n\n**************************************************************************************************\n";
        for(int i=0; i<end; i++){
            total_weight += data[i][2];
            total_fee += data[i][3];
            total_container += data[i][0];
            st+= "shipping_number :"+String.format("%3s",(int)data[i][4])+"\t\tweight :" + String.format("%3s",(int)data[i][2])
                    +"\t\tcontainer :"+ (int)data[i][0]+ "\t\tshipping_fee :"+(int)data[i][3]+"\n";

        }
        System.out.println(st);
        cs.writeDataToFile(st, "CargoShipLogistics-(c)");
//        System.out.println(st);
    }
}

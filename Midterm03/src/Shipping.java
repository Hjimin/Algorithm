import java.text.DecimalFormat;

/**
 * Created by Jimin on 3/1/17.
 */
public class Shipping {
    double[][] data;
    int count = 919;
    int maxWeight = 35000;
    int maxCon = 2200;

    public Shipping(double[][] data) {
        this.data = data;
    }

    public void sorting() {
        for(int i=0; i < count - 1; i++){
            for(int j = i+1; j< count; j++) {
                if(data[j][1]>data[i][1]) {
                    //number of container needed
                    double temp_num = data[i][0];
                    data[i][0] = data[j][0];
                    data[j][0] = temp_num;

                    //average fee per container
                    double temp_fee = data[i][1];
                    data[i][1] = data[j][1];
                    data[j][1] = temp_fee;

                    //total weight
                    double temp_total_weight = data[i][2];
                    data[i][2] = data[j][2];
                    data[j][2] = temp_total_weight;

                    //total fee
                    double temp_total_fee = data[i][3];
                    data[i][3] = data[j][3];
                    data[j][3] = temp_total_fee;
                }
            }
        }
    }

    public void choose() {
        int num = 0;
        double fee = 0;
        int weight = 0;
        int old_num = 0;
        double old_fee = 0;
        int old_weight = 0;

        int i=0;
        while (num<2200 && weight<35000) {
            old_num = num;
            old_weight = weight;
            old_fee = fee;

            num += data[i][0];
            weight += data[i][2];
            fee += data[i][3];
            i++;
        }
        System.out.println(i);
        System.out.println(old_num);
        System.out.println(old_fee);
        System.out.println(old_weight);

    }

    public void print() {
        DecimalFormat form = new DecimalFormat("#.##");
        System.out.println("******************************************************");
        for(int i=0; i < count; i++){
            System.out.print(data[i][0] + "   ");
            System.out.print(form.format(data[i][1]) + "\t\t");
            System.out.println(data[i][2]);
        }
    }
}

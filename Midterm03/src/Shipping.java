import java.text.DecimalFormat;

/**
 * Created by Jimin on 3/1/17.
 */
public class Shipping {
    double[][] data;
    int count = 919;
    int shipping_limit=0;
    int maxWeight = 35000;
    int maxCon = 2200;
    int old_num = 0;
    double old_fee = 0;
    int old_weight = 0;

    public Shipping(double[][] data) {
        this.data = data;
    }

    public double[][] sorting() {
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

                    //shipping_num
                    double shipping_num = data[i][4];
                    data[i][4] = data[j][4];
                    data[j][4] = shipping_num;
                }
            }
        }
        return data;
    }

    public int choose() {
        int num = 0;
        double fee = 0;
        int weight = 0;


        while (num<maxCon && weight<maxWeight) {
            old_num = num;
            old_weight = weight;
            old_fee = fee;

            num += data[shipping_limit][0];
            weight += data[shipping_limit][2];
            fee += data[shipping_limit][3];
            shipping_limit++;
        }
        System.out.println(shipping_limit);
        System.out.println(old_num);
        System.out.println(old_fee);
        System.out.println(old_weight);

        return shipping_limit-1;
    }

    public void print() {
        DecimalFormat form = new DecimalFormat("#.##");
        System.out.println("******************************************************");
        for(int i=0; i < shipping_limit-1; i++){
            System.out.print(data[i][0] + "   ");
            System.out.print(form.format(data[i][1]) + "\t\t");
            System.out.print(form.format(data[i][3]) + "\t\t");
            System.out.println(data[i][2]);
        }
    }
}

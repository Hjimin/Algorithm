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
                    double temp_weight = data[i][2];
                    data[i][2] = data[j][2];
                    data[j][2] = temp_weight;
                }
            }
        }
    }

    public void choose() {
        int num = 0;
        double fee = 0;
        int weight = 0;
        do {
            int i=0;
            num +=data[i][0];
            fee += data[i][1];
            weight += data[i][2];
            i++;
        } while(num<2200 && weight<35000);

        System.out.println(num);
        System.out.println(fee);
        System.out.println(weight);
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

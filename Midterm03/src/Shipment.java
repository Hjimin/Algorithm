/**
 * Created by Jimin on 3/3/17.
 */
public class Shipment {

    int order_number;
    int total_weight;
    int shipping_fee;
    int container_needed;
    double fee_per_container;

    double[][] shipments; // 0->total number,

    int[] needed;
    double[] fee;
    double[][] analyze; // 0 -> needed, 1 -> fee

    public Shipment(double[][] shipments) {
        this.shipments = shipments;
    }

    public double[][] analyze(){
        analyze = new double[shipments.length][2];
        for(int i = 0 ; i < shipments.length; i++) {
            container_needed = (int)Math.ceil(shipments[i][0]/18);
            fee_per_container = shipments[i][1] / container_needed;
        }
        return analyze;
    }
}

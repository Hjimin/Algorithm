/**
 * Created by Jimin on 2/4/17.
 */
public class Main {
    public static void main(String[] args) {
        int k = 5;
        int[] d = new int[k+1];
        int n = 24;

        d[0] = 1;
        d[1] = 3;
        d[2] = 15;
        d[3] = 19;
        d[4] = 23;
        d[5] = 25;


        CoinChange coinChange = new CoinChange();
        CoinSet coinSet = coinChange.coinChange(d,k+1,n);
        coinChange.makeChange(coinSet.getS(), d ,n);

    }
}

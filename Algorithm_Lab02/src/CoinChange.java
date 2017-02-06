/**
 * Created by Jimin on 2/4/17.
 */
public class CoinChange {

    public CoinSet coinChange (int[] d, int k, int n) {
        int C[] = new int[n+1];
        int S[] = new int[n+1];
        C[0] = 0;
        int coin = 0;

        for (int p = 1; p <= n; p++) {
            int min = 99999;
            for(int i=0; i<k ; i++) {
                if (d[i] <= p) {
                    if(1+ C[p-d[i]] < min) {
                        min = 1+ C[p-d[i]];
                        coin = i;
                    }
                }
            }
            C[p] = min;
            S[p] = coin;
        }
        return new CoinSet(C,S);
    }

    public void makeChange(int S[], int[] d, int n) {
        while (n > 0) {
            System.out.println(S[n]);
            n = n - d[S[n]];
        }
    }
}

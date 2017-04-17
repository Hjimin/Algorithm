import java.io.IOException;

/**
 * Created by Jimin on 4/17/17.
 */
public class ThreadDemo implements Runnable {
    private Thread t;
    private String fileName;

    ThreadDemo( String name) {
        fileName = name;
        System.out.println("Creating " +  fileName );
    }

    public void run() {
        System.out.println("Running " +  fileName );
        ShortestPath shortestPath = new ShortestPath();
        int[][] data = null;
        try {
            data = shortestPath.readData(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        double[][] dis = shortestPath.calDistance(data);
        int[][] data2 = shortestPath.reorder(dis);
        shortestPath.writeData(data2, "reorder-"+fileName);

        System.out.println("Thread " + fileName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  fileName );
        if (t == null) {
            t = new Thread (this, fileName);
            t.start ();
        }
    }
}
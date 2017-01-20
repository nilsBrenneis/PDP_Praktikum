package aufgabe3;

import java.util.concurrent.*;

/**
 * Created by nils on 18.01.17.
 */
public class ThreadPerTask implements Executor {

    @Override
    public void execute(Runnable r) {
        Thread t = new Thread(r);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

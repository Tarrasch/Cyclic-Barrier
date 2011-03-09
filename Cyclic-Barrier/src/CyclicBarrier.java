
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rarash
 */
public class CyclicBarrier {

    int n;

    public CyclicBarrier(int n) {
        this.n = n;
    }

    public synchronized void await() {
        if (--n > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CyclicBarrier.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            notifyAll();
        }
        n++;
    }
}

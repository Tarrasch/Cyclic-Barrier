import java.awt.Color;
import javax.swing.*;

public class Balls {

    public static void nap(int ms) {
	try {
	    Thread.sleep(ms);
	}
	catch(InterruptedException e) {
	    //
	    //  Print out the name of the tread that caused this.
	    //
	    System.err.println("Thread "+Thread.currentThread().getName()+
			       " throwed exception "+e.getMessage());
	}
    }

    public static void main(String[] a) {
	
        final BallWorld world = new BallWorld();
	final JFrame win = new JFrame();
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.getContentPane().add(world);
		win.pack();
		win.setVisible(true);
	    }});
	
	Thread.currentThread().setName("MyMainThread");

	nap((int)(5000*Math.random()));
	new Ball(world, 50, 80, 5, 10, Color.red).start();
	nap((int)(5000*Math.random()));
	new Ball(world, 70, 100, 8, 6, Color.blue).start();
	nap((int)(5000*Math.random()));
	new Ball(world, 150, 100, 9, 7, Color.green).start();
	nap((int)(5000*Math.random()));
	new Ball(world, 200, 130, 3, 8, Color.black).start();
	nap((int)(5000*Math.random()));
    }
}

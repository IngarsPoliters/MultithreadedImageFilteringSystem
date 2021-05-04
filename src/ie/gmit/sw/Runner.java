package ie.gmit.sw;

import java.util.concurrent.*;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 *
 *The Runner class implements an application that will
 *display a menu to the standard output. The menu will request
 *an input from the user to enter a number. With the selected 
 *number option, Runner class will initiate a BlockingQueue interface
 *and run ImageProducer & ImageConsumer concurrently
 *
 *see case
 */

public class Runner {
	public static void main(String[] args) throws Exception {
		Client c = new Client();
		boolean keepRunning = true;
		BlockingQueue<Task> q = new ArrayBlockingQueue(5);
		Thread t1 = null;
		Thread t2 = null;

		do {
			c.getMenu();//get the option menu
			switch (c.getOption()) {
			case 1:// Enter Image Directory - takes all the images in and filters them
				t1 = new Thread(new ImageProducer(q));
				t2 = new Thread(new ImageConsumer(q));
				t1.start();
				t2.start();
				break;
			case 2:
				// Select Single Image - enter full image path
//				t1 = new Thread(new ImageProducer(q));
//				t2 = new Thread(new ImageConsumer(q));
//				t1.start();
//				t2.start();
				break;
			case 3:
				// Add a custom filter - enter custom filter, prompt to enter image directory/s
				break;
			case 4:
				// exit system
				keepRunning = false;
				break;
			default:
				
			}
			t1.join();// wait until the last thread has finished
			t2.join();
		} while (keepRunning == true);
	}
}

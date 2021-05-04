package ie.gmit.sw;

import java.util.concurrent.*;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 * 
 * The ImageProducer implements Runnable is a thread started from the 
 * Runner class. This class adds a Task to the BlockingQueue where the 
 * Task will be deployed to do its work
 * 
 * See Task
 * 
 * Scannable Interface is initialized as a ScanDirectory class,
 * ScanDirectory will ask the user to enter the directory containing
 * the images
 *
 */
public class ImageProducer implements Runnable {
	private int count = 0;
	private BlockingQueue<Task> que;
	boolean keepAlive = true;
	Scannable s = new ScanDirectory();

	public ImageProducer(BlockingQueue<Task> q) throws Exception {
		super();
		this.que = q;
	}

	public void run() {
		while (s.returnImages().size() > count) {
			
			/**
			 * Here the Task is initialized and later added to the BlockingQueue to start the image filtering
			 * @param count this is the first parameter to task constructor
			 * @param s.returnImages().get(count) this is the second parameter to task constructor
			 * 
			 */
			
			Task t = new Task(count, s.returnImages().get(count));

			System.out.println("Adding-> " + t);

			try {
				que.put(t);// BLOCKING METHOD
				t.startImageFilter();
				// t.startImageFilter();//Start the image filtering
				// t.startImageFilter(images.get(count));
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++;
		}
		try {
			que.put(new Poison(-1));// POISON THE BLOCKING QUE
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
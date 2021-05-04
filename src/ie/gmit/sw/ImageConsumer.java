package ie.gmit.sw;

import java.util.concurrent.*;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 * 
 * ImageConsumer implements Runnable is a thread consuming the Task from the BlockingQueue
 */

public class ImageConsumer implements Runnable {
	private BlockingQueue<Task> que;
	private volatile boolean keepRunning = true;
	
	public ImageConsumer(BlockingQueue<Task> q) {
		super();
		this.que = q;
	}
	
	public void run() {
		while (keepRunning) {
			try {
				Task t = que.take();// BLOCKING METHOD
				
				if(t instanceof Poison) {
					keepRunning = false;
					System.out.println("Que Poisoned-> "+ t);
				}
				System.out.println("Removing-> "+ t);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
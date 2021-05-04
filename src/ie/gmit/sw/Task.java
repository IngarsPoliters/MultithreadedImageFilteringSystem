package ie.gmit.sw;

import java.util.concurrent.*;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 * 
 * The class Task is the task to be completed when its in the BlockingQueue
 */

public class Task  {
	private final int KERNEL_SIZE = 10;
	private int number;
	ExecutorService executor = Executors.newFixedThreadPool(10);
	ImageDetails image;
	/**
	 * Task Constructor takes in these parameters and assigns them to the local variables
	 * @param num 
	 * @param img
	 */
	public Task (int num, ImageDetails img)  {
		super();
		this.number = num;
		this.image = img;
	}
	
	/**
	 * startImageFilter method loops over the kernel size.
	 * for each kernel ExecutorService starts a thread to 
	 * filter each image with all the kernel settings
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void startImageFilter() throws InterruptedException {
		for(int i = 1; i < KERNEL_SIZE; i++) {	//loop over the kernel size to apply all 9 filters	
			String name = image.getImageName();
			String path = image.getImagePath();
			
			Runnable thread = new ImageFilter(image.getImage(), image.getKernel(i),name, path);
			executor.execute(thread);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
        }
	}//end startImageFilter
	
	@Override
	public String toString() {
		return "Task [number=" + number + "]";
	}
}

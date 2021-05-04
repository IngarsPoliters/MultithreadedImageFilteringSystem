package ie.gmit.sw;

import java.awt.*;
import java.awt.image.*;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 * 
 * ImageFilter Class implements Runnable to start filtering images
 * with each kernel setting concurrently for all the 
 * images existing in the directory
 */

public class ImageFilter implements Runnable {
	private volatile BufferedImage oldImage, newImage;
	private float[][] kernel;
	String path;
	String name;
	
	/**
	 * ImageFilter Constructor receives all the required parameters
	 * to apply the filter to the image and output the filtered picture.
	 * Each filtered picture will output in the same directory with different names
	 * for each filter
	 * @param img BufferedImage parameter
	 * @param k kernel parameter to apply the filter to the image
	 * @param name Name of the image from the directory
	 * @param path Path of the image from the directory 
	 */
	// Constructor
	public ImageFilter(BufferedImage img, float[][] k, String name, String path) {
		this.kernel = k;
		this.oldImage = img;
		this.name = name;
		this.path = path;
	}

	/**
	 * The run method will apply the filter to each image.
	 * Each image is sent to the ImageOutput class and
	 * the image is written out to the path directory
	 */
	@Override
	public void run() {
		newImage = new BufferedImage(oldImage.getWidth(), oldImage.getHeight(), oldImage.getType());
		for (int x = 0; x < oldImage.getWidth(); x++) {// Loop over the 2D image pixel by pixel
			for (int y = 0; y < oldImage.getHeight(); y++) {
				float red = 0f, green = 0f, blue = 0f;
				for (int i = 0; i < kernel.length; i++) {
					for (int j = 0; j < kernel.length; j++) {
						int imgX = (x - kernel.length / 2 + i + oldImage.getWidth()) % oldImage.getWidth();
						int imgY = (y - kernel.length / 2 + j + oldImage.getHeight()) % oldImage.getHeight();

						int pixel = oldImage.getRGB(imgX, imgY);
						int R = (pixel >> 16) & 0xff; // red value
						int G = (pixel >> 8) & 0xff; // green value
						int B = (pixel) & 0xff; // blue value

						red += (R * kernel[i][j]);
						green += (G * kernel[i][j]);
						blue += (B * kernel[i][j]);
					} // end for j
				} // end for i
				int outR, outG, outB;
				// The value is truncated to 0 and 255 if it goes beyond
				outR = Math.min(Math.max((int) (red * 2), 0), 255);
				outG = Math.min(Math.max((int) (green * 2), 0), 255);
				outB = Math.min(Math.max((int) (blue * 2), 0), 255);
				newImage.setRGB(x, y, new Color(outR, outG, outB).getRGB());
				
			} // end for y
		} // end for x
		String kernel = Thread.currentThread().getName();
		new ImageOutput(newImage, kernel, name, path);
	}//end run
}

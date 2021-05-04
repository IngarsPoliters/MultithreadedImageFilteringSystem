package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 * 
 * The ImageOutput class outputs each image to the path directory.
 * It creates a new folder named from the filtered picture
 */

public class ImageOutput {
	private BufferedImage image;
	private String setting;
	private String name;
	private String path;
	
	//constructor
	public ImageOutput(BufferedImage img, String kernel, String name, String path )  {
		this.image = img;
		this.setting = kernel;
		this.name = name;
		this.path = path;
		try {
			outputImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * outputImage builds a new path for the image.
	 * The new path will create a new folder named after the image.
	 * In the created directory all the filtered images will be created
	 * @throws Exception
	 */
	public synchronized void outputImage() throws Exception {
		path = path +"\\"+ name+ "Filtered";
		File dir = new File(path );
		
		if(!dir.exists()) {// if directory does not exist, 
			dir.mkdirs();//create the directory
		}
		File file = new File(dir, name +setting + ".jpg"); 
		ImageIO.write(image, "jpg", (file));
	}
}

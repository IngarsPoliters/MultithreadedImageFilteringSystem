package ie.gmit.sw;

import java.awt.image.*;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 * 
 * ImageDetails is a class to hold all the image properties
 * once the image is converted from file to the BufferedImage,
 * you no longer hold its name and path, therefore you have this class
 * to store all the required details
 *
 */
class ImageDetails {
	private BufferedImage image;
	private String imageName;
	private String imagePath;
	Kernel k = new Kernel();

	public ImageDetails(BufferedImage img, String name, String path){
		setImage(img);
		setImageName(name);
		setImagePath(path);
	}

	public void setImage(BufferedImage img) {
		this.image = img;
	}
	public BufferedImage getImage() {
		return image;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}	
	/**
	 * Simple method to return the kernel filter from Kernel class.
	 * This is mostly requested in the Task class to pass the kernel to filter the image
	 * @param num
	 * @return k.getKernel(num) return the kernel requested from Kernel class
	 */
	public float[][] getKernel(int num) {
		return k.getKernel(num);
	}
}
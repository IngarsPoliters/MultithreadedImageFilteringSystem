package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 *
 * The ScanDirectory class implements Scannable
 * This class will ask the user to enter the path with all the images.
 * Once path is entered the imageScanner will start scanning for all the images in the directory
 */

public class ScanDirectory implements Scannable{
	private String path;
	private Scanner input = new Scanner(System.in);
	ArrayList<ImageDetails> images = new ArrayList<>();
	
	//ImageScanner Constructor
	public ScanDirectory () {
		path();
		imageScanner();
	}

	/**
	 * imageScanner method will scan the path directory
	 * if the path directory contains images (.jpg, .jpeg and .PNG)
	 * these images will get added to the ArrayList of ImageDetails type
	 */
	@Override
	public void imageScanner() {
		File f = new File(path);
		int count = 0;
		for(File file : f.listFiles()) {
			if(file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")|| file.getName().endsWith(".PNG") )) {
				try {
					String fileName = trimName(file.getName());
					ImageDetails img = new ImageDetails(ImageIO.read(file),  fileName, path);
					images.add(img);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				count++;
				System.out.println(count+ ") "+ file.getName());	
			}
		}
		System.out.println(images.size());
	}

	/**
	 * The path method will request the user 
	 * to enter the path containing the images
	 */
	@Override
	public void path() {
		System.out.print("Image Folder Path>");
		this.path = input.nextLine();
	}
	
	/**
	 * trimName method will substring the image name and get rid of everything after '.' character
	 * @param name Image name parameter where Image name has .jpg, .jpeg or .PNG  extension
	 * @return newName String where the name is trimmed
	 */
	public String trimName(String name) {
		String newName = name.substring(0, name.lastIndexOf('.'));
		return newName;
	}

	/**
	 * simple method to return the ArrayList of type ImageDetails
	 * @return images all scanned images returned
	 */
	@Override
	public ArrayList<ImageDetails> returnImages() {
		return images;
	}
}

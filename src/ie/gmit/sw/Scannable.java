package ie.gmit.sw;

import java.util.ArrayList;

public interface Scannable {	
	void path();
	void imageScanner();
	ArrayList<ImageDetails> returnImages();
}

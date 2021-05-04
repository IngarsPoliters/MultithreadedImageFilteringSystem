package ie.gmit.sw;

public class Kernel {
	
	public float[][] getKernel(int num) {
		switch(num) {
		case 1: 
			return kernel1();
		case 2:
			return kernel2();
		case 3: 
			return kernel3();
		case 4: 
			return kernel4();
		case 5: 
			return kernel5();
		case 6: 
			return kernel6();
		case 7: 
			return kernel7();
		case 8: 
			return kernel8();
		case 9: 
			return kernel9();
		default:
			System.out.println("Kernel Out of Bounds");
		}
		return null;
	}
	
	public float[][] kernel1() {// Identity Kernel Filter
		float[][] kernel = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		return kernel;
	}
	
	public float[][] kernel2() {// Edge Detection Kernel Filter
		float[][] kernel = {
				{-1, 0, 1},
				{-2, 0, 2},
				{-1, 0, 1}
		};
		return kernel;
	}
	
	public float[][] kernel3() {// Laplacian Kernel Filter
		float[][] kernel = {
				{0, -1, 0},
				{-1, 4, -1},
				{0, -1, 0}
		};
		return kernel;
	}
	
	public float[][] kernel4() {// Sharpen Kernel Filter
		float[][] kernel = {
				{0, -1, 0},
				{-1, 5, -1},
				{0, -1, 0}
		};
		return kernel;
	}
	
	public float[][] kernel5() {// Vertical Lines Kernel Filter
		float[][] kernel = {
				{-1, 2, -1},
				{-1, 2, -1},
				{-1, 2, -1}
		};
		return kernel;
	}
	
	public float[][] kernel6() {// Horizontal Lines Kernel Filter
		float[][] kernel = {
				{-1, -1, -1},
				{2, 2, 2},
				{-1, -1, -1}
		};
		return kernel;
	}
	
	public float[][] kernel7() {// Diagonal 45 Kernel Filter
		float[][] kernel = {
				{-1, -1, 2},
				{-1, 2, -1},
				{2, -1, -1}
		};
		return kernel;
	}
	
	public float[][] kernel8() {// Sobel Horizontal Kernel Filter
		float[][] kernel = {
				{-1, -2, -1},
				{0, 0, 0},
				{1, 2, 1}
		};
		return kernel;
	}
	
	public float[][] kernel9() {// Sobel Vertical Kernel Filter
		float[][] kernel = {
				{-1, 0, 1},
				{-2, 0, 2},
				{-1, 0, 1}
		};
		return kernel;
	}
	
//	public float[][] kernel10() {// Box Blur Kernel Filter
//		float[][] kernel = {
//				{0.111f, 0.111f, 0.111f},
//				{0.111f, 0.111f, 0.111f},
//				{0.111f, 0.111f, 0.111f}
//		};
//		return kernel;
//	}
}

//QA conducted on 07 Dec by Alex Hui

/**
 * This Apple class contains code that determines size and x/y coordinates of the Apple (green dot).
 */

public class Apple {
	int green = 255;
	int red = 0, blue = 0;
	int radius = 1;
	
	private int xCoor, yCoor;
	
	/**
	 * Constructor for each section of body
	 * @param xCoor
	 * @param yCoor
	 */
	public Apple(int xCoor, int yCoor){
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		
	}
	
	
	public void draw() {
		PennDraw.setPenColor(red, green, blue);
		PennDraw.filledCircle(xCoor, yCoor, radius);
	}


	public int getxCoor() {
		return xCoor;
	}


	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}


	public int getyCoor() {
		return yCoor;
	}


	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	
	
	
}

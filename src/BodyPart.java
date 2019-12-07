//QA conducted on 07 Dec by Alex Hui

/**
 * This BodyPart class contains code for the players within the snake game.
 */

public class BodyPart {
//	int red = 255;
//	int green = 0, blue = 0;
	int radius = 1;
	
	private int xCoor, yCoor;
	
	/**
	 * Constructor for each section of body
	 * @param xCoor
	 * @param yCoor
	 */
	public BodyPart(int xCoor, int yCoor){
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		
	}
	
	/**
	 * Create a circle with radius 1 unit and color with RGB Array
	 * @param color
	 */
	public void drawWithColor(int[] color) {
		// red, green, blue
		PennDraw.setPenColor(color[0], color[1], color[2]);
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

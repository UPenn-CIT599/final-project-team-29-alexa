
public class BodyPart {
	int red = 255;
	int green = 0, blue = 0;
	vectorLocation position;
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

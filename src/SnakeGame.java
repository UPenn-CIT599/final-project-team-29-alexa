import java.util.ArrayList;

public class SnakeGame {

	public static void main(String[] args) {
		PennDraw.setCanvasSize(500, 500);
		PennDraw.setScale(0, 50);
		PennDraw.enableAnimation(100);

		ArrayList<BodyPart> body = new ArrayList<BodyPart>();
		Apple apple;
		
		while (!isGameOver(body)) {
			PennDraw.clear();
			
			//Draw current body
			PennDraw.clear();
			for (BodyPart o: body) {
				o.draw();
			}
			
			
			//Draw apple location
			
			
			//takes user instruction: direction(WASD), keep a copy of current head location,
			//update next head location
			
			
			//if eats(head coor = apple), apple becomes new head, all bodypart pushed back 1 index, create apple 
			//if no eats, all body parts replaced by index-1
			
			
			PennDraw.advance();
		}
		
		//Display GAME OVER
		
		
	}

	
	/**
	 * Two conditions for ending a game: hit the wall, or hit itself
	 * @param body
	 * @return
	 */
	public static  boolean isGameOver(ArrayList<BodyPart> body) {
		//boolean isover = false;
		
		//collision with walls
		BodyPart head = body.get(0);
		if (head.getxCoor() > 50 || head.getyCoor()>50 ||
			head.getxCoor() < 0 || head.getyCoor() < 0) {
			return true;
		}
		
		//collision with itself
		for (int i = 1; i < body.size(); i++) {
			if (head.getxCoor() == body.get(i).getxCoor() && 
				head.getyCoor() == body.get(i).getyCoor()) {
				return true;
			}
		}
		
		return false;
	}

}

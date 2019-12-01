import java.util.ArrayList;
import java.util.Random;

public class SnakeGame {

	public static void main(String[] args) {
		Random random = new Random();
		PennDraw.setCanvasSize(500, 500);
		PennDraw.setScale(0, 50);
		PennDraw.enableAnimation(100);

		ArrayList<BodyPart> body = new ArrayList<BodyPart>();
		BodyPart initial = new BodyPart(25, 25); 
		BodyPart secondary = new BodyPart(24, 25);
		body.add(initial);
		body.add(secondary);
		
		Apple apple = new Apple(random.nextInt(51), random.nextInt(51));
		char direction = 'd';
		
		while (!isGameOver(body)) {
			PennDraw.clear();
			
			//Draw current body
			PennDraw.clear();
			for (BodyPart o: body)
				o.draw();
			
			//Draw apple
			apple.draw();
			
			//takes user instruction: direction(WASD), keep a copy of current head location,
			//update next head location
			BodyPart currentHead = body.get(0);
			
			if (PennDraw.hasNextKeyTyped()) {
				direction = Character.toLowerCase(PennDraw.nextKeyTyped());
			}
			if (direction == 'd')
				body.get(0).setxCoor(body.get(0).getxCoor()+1);
			else if (direction == 'a')
				body.get(0).setxCoor(body.get(0).getxCoor()-1);
			else if (direction == 'w')
				body.get(0).setyCoor(body.get(0).getyCoor()+1);
			else if (direction == 's')
				body.get(0).setyCoor(body.get(0).getyCoor()-1);
			
			
			//if eats(head coor = apple), apple becomes new head, all bodypart pushed back 1 index, update apple 
			//if no eats, all body parts replaced by index-1
			for (int j = (body.size() - 1); j > 1; j--) 
				body.set(j, body.get(j-1));
			body.set(1, currentHead);
			
			if (currentHead.getxCoor() == apple.getxCoor() && currentHead.getyCoor() == apple.getyCoor()) {} 
			else 
				body.remove(body.size()-1);	
			
			
			
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
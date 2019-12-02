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
		char direction = 'd'; while (!isGameOver(body)) {
			try {
				Thread.sleep(200);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			//Draw current body
			PennDraw.clear();
			for (BodyPart o: body)
				o.draw();
			
			//Draw apple
			apple.draw();
			
			//takes user instruction: direction(WASD), keep a copy of current head location,
			//update next head location
			if (PennDraw.hasNextKeyTyped()) {
				direction = Character.toLowerCase(PennDraw.nextKeyTyped());
			}
			if (direction == 'd')
				body.add(0, new BodyPart(body.get(0).getxCoor()+1, body.get(0).getyCoor()));
			else if (direction == 'a')
				body.add(0, new BodyPart(body.get(0).getxCoor()-1, body.get(0).getyCoor()));
			else if (direction == 'w')
				body.add(0, new BodyPart(body.get(0).getxCoor(), body.get(0).getyCoor()+1));
			else if (direction == 's')
				body.add(0, new BodyPart(body.get(0).getxCoor(), body.get(0).getyCoor()-1));

			//if eats(head coor = apple), apple becomes new head, all bodypart pushed back 1 index, update apple
			//if no eats, all body parts replaced by index-1
			if (body.get(0).getxCoor() != apple.getxCoor() || body.get(0).getyCoor() != apple.getyCoor()) {
				body.remove(body.size() - 1);
			} else {
				apple = new Apple(random.nextInt(51), random.nextInt(51));
			}
			
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
		if (head.getxCoor() > 50 || head.getyCoor() > 50 ||
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
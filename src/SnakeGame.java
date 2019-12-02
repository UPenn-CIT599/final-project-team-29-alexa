import java.util.ArrayList;
import java.util.Random;

public class SnakeGame {

	public static void main(String[] args) {
		Random random = new Random();
		PennDraw.setCanvasSize(500, 500);
		PennDraw.setScale(0, 50);
		PennDraw.enableAnimation(10);

		ArrayList<BodyPart> body = new ArrayList<BodyPart>();
		BodyPart initial = new BodyPart(25, 25); 
		BodyPart secondary = new BodyPart(24, 25);
		body.add(initial);
		body.add(secondary);
		
		Apple apple = new Apple(random.nextInt(51), random.nextInt(51));
		char direction = 'd';
		
		//while (true) {
		while (!isGameOver(body)) {
			
			//Draw current body and apple
			PennDraw.clear();
			for (BodyPart o: body)
				o.draw();
			apple.draw();
			
			//takes user instruction: direction(WASD), keep a copy of current head location,
			ArrayList<BodyPart> currentHead = new ArrayList<BodyPart>(body);
			//Test
			for (BodyPart o: body)
				System.out.println("Before direction: Body: xcoor is " + o.getxCoor() + ", ycoor is " + o.getyCoor());
			for (BodyPart ko: currentHead)
				System.out.println("Before direction: CurrentHead: xcoor is " + ko.getxCoor() + ", ycoor is " + ko.getyCoor());
			
			
			//next head location
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
			
			//Test
			for (BodyPart o: body)
				System.out.println("After direction: Body: xcoor is " + o.getxCoor() + ", ycoor is " + o.getyCoor());
			for (BodyPart ko: currentHead)
				System.out.println("After direction: CurrentHead: xcoor is " + ko.getxCoor() + ", ycoor is " + ko.getyCoor());
			
			
			//Every body section advance 1, by taking values from currentHead
			for (int j = 1; j < body.size(); j++) {
				body.set(j, currentHead.get(j-1));
			}
			System.out.println("Current head xcoor is " + currentHead.get(0).getxCoor() + 
					", ycoor is " + currentHead.get(0).getyCoor());
			body.set(1, currentHead.get(0));
			
			// if eats(head coor = apple), extend tail
			if (currentHead.get(0).getxCoor() == apple.getxCoor() && currentHead.get(0).getyCoor() == apple.getyCoor()) {
				body.add(currentHead.get(body.size()-1));
			} 
			
			
			//Test region
			System.out.println("direction is " + direction);
			System.out.println("body coordination is ");
			for (BodyPart jo: body)
				System.out.println("xcoor is " + jo.getxCoor() + ", ycoor is " + jo.getyCoor());
			System.out.println("end of loop");
			
			PennDraw.advance();
		}
		
		//Display GAME OVER
		System.out.println("Game over");
		
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
			System.out.println("wall error");
			return true;
		}
		
		//collision with itself
		for (int i = 1; i < body.size(); i++) {
			if (head.getxCoor() == body.get(i).getxCoor() && 
				head.getyCoor() == body.get(i).getyCoor()) {
//				System.out.println("itself error");
//				System.out.println("head xcoor " + head.getxCoor() + "  ycoor " + head.getyCoor());
//				System.out.println("body section " + i);
				return true;
			}
		}
		
		return false;
	}

}
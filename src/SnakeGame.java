import java.util.ArrayList;
import java.util.Random;

public class SnakeGame {

	public static void main(String[] args) {
		Random random = new Random();

		// Open main menu for choosing gaming mode
		// 1. Single player
		// 2. Two players
		// 3. Compete with AI
		MainMenu.draw();
		char mode = '0';
		while (mode != '1' && mode != '2' && mode != '3') {
			try {
				Thread.sleep(200);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			if (PennDraw.hasNextKeyTyped()) {
				mode = PennDraw.nextKeyTyped();
			}
		}

		// Start game and initialize game canvas
		PennDraw.setCanvasSize(500, 500);
		PennDraw.setScale(0, 50);
		PennDraw.enableAnimation(10);

		ArrayList<BodyPart> body = new ArrayList<BodyPart>();
		BodyPart initial = new BodyPart(25, 25); 
		BodyPart secondary = new BodyPart(24, 25);
		body.add(initial);
		body.add(secondary);

		Apple apple = new Apple(random.nextInt(51), random.nextInt(51));
		PlayerDirectionStore directionStore = new PlayerDirectionStore();

		while (!isGameOver(body)) {
			try {
				Thread.sleep(200);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			//Draw current body and apple
			PennDraw.clear();
			for (BodyPart o: body)
				o.draw();
			apple.draw();
			
			//takes user instruction: direction(WASD), head location is the head of ArrayList,
			directionStore.updateDirection();
			int[] player1Direction = directionStore.getPlayer1Direction();
			body.add(0, new BodyPart(body.get(0).getxCoor() + player1Direction[0],
					body.get(0).getyCoor() + player1Direction[1]));

			//if eats(head coor = apple), apple becomes new head, we need to generate new apple location
			//if no eats, remove the last one as snake is moving.
			if (body.get(0).getxCoor() != apple.getxCoor() || body.get(0).getyCoor() != apple.getyCoor()) {
				body.remove(body.size() - 1);
			} else {
				apple = new Apple(random.nextInt(51), random.nextInt(51));
			}

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
		if (head.getxCoor() > 50 || head.getyCoor() > 50 ||
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
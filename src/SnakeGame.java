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

		// initialize the two players and apple
		// first player with color red
		Player player1 = new Player(new int[]{255, 0, 0}, true);
		// second player with color blue
		Player player2 = new Player(new int[]{0, 0, 255}, false);
		Apple apple = new Apple(random.nextInt(51), random.nextInt(51));
		PlayerDirectionStore directionStore = new PlayerDirectionStore();
		GameDecider decider = new GameDecider(isSingerPlayer(mode));
		AiDirectionDecider aiDecider = new AiDirectionDecider();

		while (!decider.isGameOver(player1, player2)) {
			try {
				Thread.sleep(200);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			//Draw current body and apple
			PennDraw.clear();
			player1.draw();
			if (!isSingerPlayer(mode)) {
				player2.draw();
			}
			apple.draw();
			
			//takes user instruction: direction(WASD), head location is the head of ArrayList,
			directionStore.updateDirection();
			int[] player1Direction = directionStore.getPlayer1Direction();
			player1.addHead( player1.getHead().getxCoor() + player1Direction[0],
					player1.getHead().getyCoor() + player1Direction[1]);
			if (!isSingerPlayer(mode)) {
				int[] player2Direction;
				if (mode == '2') {
					player2Direction = directionStore.getPlayer2Direction();
				} else {
					player2Direction = aiDecider.getDirection(player1, player2, apple);
				}
				player2.addHead(player2.getHead().getxCoor() + player2Direction[0],
						player2.getHead().getyCoor() + player2Direction[1]);
			}

			//if eats(head coor = apple), apple becomes new head, we need to generate new apple location
			//if no eats, remove the last one as snake is moving.
			if (!player1.isHeadLocation(apple.getxCoor(), apple.getyCoor())) {
				player1.removeTail();
			} else {
				apple = new Apple(random.nextInt(51), random.nextInt(51));
			}

			if (!isSingerPlayer(mode)) {
				if (!player2.isHeadLocation(apple.getxCoor(), apple.getyCoor())) {
					player2.removeTail();
				} else {
					apple = new Apple(random.nextInt(51), random.nextInt(51));
				}
			}

			PennDraw.advance();

		}
		
		//Display GAME OVER
		System.out.println("Game over");
	}

	public static boolean isSingerPlayer(char mode) {
		return mode == '1';
	}
}
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class AiDirectionDeciderTest {
    private AiDirectionDecider directionDecider = new AiDirectionDecider();

    // createPlayer will create a player with one body at (x, y) for testing
    private Player createPlayer(int x, int y) {
        Player player = new Player(new int[]{0, 0, 0}, true);
        player.removeTail();
        player.removeTail();
        player.addHead(x, y);
        return player;
    }

    // Test for no blocking
    @Test
    public void testDeciderWithoutBlocker() {
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(24 , 25);
        Player player2 = createPlayer(26, 25);
        Assertions.assertArrayEquals(directionDecider.getDirection(player1, player2,apple), new int[]{-1, 0});
    }

    // Test Player1 blocking Ai
    @Test
    public void testDeciderWithPlayerBlocking() {
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(26 , 25);
        Player player2 = createPlayer(27, 25);
        Assertions.assertArrayEquals(directionDecider.getDirection(player1, player2,apple), new int[]{0, -1});
    }

    // Test for player at the edge
    @Test
    public void testDeciderAtEdge() {
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(26 , 25);
        Player player2 = createPlayer(0, 0);
        Assertions.assertArrayEquals(directionDecider.getDirection(player1, player2,apple), new int[]{0, 1});
    }

    // Test for ai surrounded by player with only one available direction
    @Test
    public void testDeciderWithOneExit() {
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(1 , 0);
        player1.addHead(0, 1);
        player1.addHead(2, 1);
        Player player2 = createPlayer(1, 1);
        Assertions.assertArrayEquals(directionDecider.getDirection(player1, player2, apple), new int[]{0, 1});
    }

    // Test for ai surrounded by player
    @Test
    public void testDeciderNoExit() {
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(1 , 0);
        player1.addHead(0, 1);
        player1.addHead(2, 1);
        player1.addHead(1, 2);
        Player player2 = createPlayer(1, 1);
        Assertions.assertArrayEquals(directionDecider.getDirection(player1, player2, apple), new int[]{-1, 0});
    }
}
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class GameDeciderTest {
    // createPlayer will create a player with one body at (x, y) for testing
    private Player createPlayer(int x, int y) {
        Player player = new Player(new int[]{0, 0, 0}, true);
        player.removeTail();
        player.removeTail();
        player.addHead(x, y);
        return player;
    }

    // Test Single Game Mode Not End
    @Test
    public void testSingleGameNotEnd() {
        GameDecider decider = new GameDecider(true);
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(25, 25);
        Player player2 = createPlayer(25, 25);
        Assertions.assertFalse(decider.isGameOver(player1, player2));
    }

    // Test Single Game Hit Wall
    @Test
    public void testSingleGameHitWall() {
        GameDecider decider = new GameDecider(true);
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(-1, 25);
        Player player2 = createPlayer(25, 25);
        Assertions.assertTrue(decider.isGameOver(player1, player2));
    }

    // Test Two Players Mode Not End
    @Test
    public void testTwoPlayerGameNotEnd() {
        GameDecider decider = new GameDecider(false);
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(25, 25);
        Player player2 = createPlayer(30, 30);
        Assertions.assertFalse(decider.isGameOver(player1, player2));
    }

    // Test Two Players Mode Hit Wall
    @Test
    public void testTwoPlayersHitWall() {
        GameDecider decider = new GameDecider(false);
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(-1, 25);
        Player player2 = createPlayer(30, 30);
        Assertions.assertTrue(decider.isGameOver(player1, player2));
    }

    // Test Two Players Hit Each Other
    @Test
    public void testTwoPlayersHit() {
        GameDecider decider = new GameDecider(false);
        Apple apple = new Apple(25, 25);
        Player player1 = createPlayer(25, 25);
        Player player2 = createPlayer(25, 25);
        Assertions.assertTrue(decider.isGameOver(player1, player2));
    }
}
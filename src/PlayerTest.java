import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class PlayerTest {
    // Test player1 initial state
    @Test
    public void testPlayer1InitalState() {
        Player player = new Player(new int[]{0, 0, 0}, true);
        Assertions.assertEquals(player.getBody().size(), 2);
        Assertions.assertEquals(player.getBody().get(0).getxCoor(), 15);
        Assertions.assertEquals(player.getBody().get(0).getyCoor(), 15);
        Assertions.assertEquals(player.getBody().get(1).getxCoor(), 14);
        Assertions.assertEquals(player.getBody().get(1).getyCoor(), 15);
    }

    // Test player2 initial state
    @Test
    public void testPlayer2InitalState() {
        Player player = new Player(new int[]{0, 0, 0}, false);
        Assertions.assertEquals(player.getBody().size(), 2);
        Assertions.assertEquals(player.getBody().get(0).getxCoor(), 35);
        Assertions.assertEquals(player.getBody().get(0).getyCoor(), 35);
        Assertions.assertEquals(player.getBody().get(1).getxCoor(), 34);
        Assertions.assertEquals(player.getBody().get(1).getyCoor(), 35);
    }

    // Test getHead
    @Test
    public void testGetHead() {
        Player player = new Player(new int[]{0, 0, 0}, true);
        BodyPart head = player.getHead();
        Assertions.assertEquals(head.getxCoor(), 15);
        Assertions.assertEquals(head.getyCoor(), 15);
    }

    // Test addHead
    @Test
    public void addHead() {
        Player player = new Player(new int[]{0, 0, 0}, true);
        player.addHead(10, 10);
        BodyPart head = player.getHead();
        Assertions.assertEquals(head.getxCoor(), 10);
        Assertions.assertEquals(head.getyCoor(), 10);
    }

    // Test removeTail
    @Test
    public void removeTail() {
        Player player = new Player(new int[]{0, 0, 0}, true);
        player.removeTail();
        Assertions.assertEquals(player.getBody().size(), 1);
        Assertions.assertEquals(player.getBody().get(0).getxCoor(), 15);
        Assertions.assertEquals(player.getBody().get(0).getyCoor(), 15);
    }
}
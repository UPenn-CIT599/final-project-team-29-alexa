import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class PlayerDirectionStoreTest {
    // Test player1 direction
    @Test
    public void testPlayer1Direction() {
        PlayerDirectionStore playerDirectionStore = new PlayerDirectionStore();
        char[] keys = new char[]{'a', 'd', 's', 'w'};
        int[][] expectedDirection = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            playerDirectionStore.player1Direction = keys[i];
            Assertions.assertArrayEquals(playerDirectionStore.getPlayer1Direction(), expectedDirection[i]);
        }
    }

    // Test player2 direction
    @Test
    public void testPlayer2Direction() {
        PlayerDirectionStore playerDirectionStore = new PlayerDirectionStore();
        char[] keys = new char[]{'j', 'l', 'k', 'i'};
        int[][] expectedDirection = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            playerDirectionStore.player2Direction = keys[i];
            Assertions.assertArrayEquals(playerDirectionStore.getPlayer2Direction(), expectedDirection[i]);
        }
    }
}
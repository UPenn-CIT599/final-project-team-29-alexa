import java.util.ArrayList;

/**
 * GameDecider contains the code for deciding whether game is over and who wins games
 */

public class GameDecider {
    /**
     * Two conditions for ending a game if only one player:
     * hit the wall, hit component, or hit itself
     * @param body
     * @return
     */
    private boolean isSinglePlayer;

    public GameDecider(boolean isSinglePlayer) {
       this.isSinglePlayer = isSinglePlayer;
    }

    public boolean isGameOver(Player player1, Player player2) {
        if (this.isSinglePlayer) {
            return isSinglePlayerCollide(player1);
        }
        // the case of two players will be more complicated:
        // players hit the wall or itself or hit each other.
        if (isSinglePlayerCollide(player1) || isSinglePlayerCollide(player2)) {
            return true;
        }
        if (isTwoPlayersCollide(player1, player2) || isTwoPlayersCollide(player2, player1)) {
            return true;
        }
        return false;
    }

    public boolean isSinglePlayerCollide(Player player) {
        //collision with walls
        BodyPart head = player.getHead();
        if (head.getxCoor() > 50 || head.getyCoor() > 50 ||
                head.getxCoor() < 0 || head.getyCoor() < 0) {
            System.out.println("wall error");
            return true;
        }

        //collision with itself
        for (int i = 1; i < player.getBody().size(); i++) {
            if (head.getxCoor() == player.getBody().get(i).getxCoor() &&
                    head.getyCoor() == player.getBody().get(i).getyCoor()) {
                return true;
            }
        }
        return false;
    }

    public boolean isTwoPlayersCollide(Player player, Player component) {
        BodyPart head = player.getHead();

        // collision with component
        for (int i = 0; i < component.getBody().size(); i++) {
            if (head.getxCoor() == component.getBody().get(i).getxCoor() &&
                    head.getyCoor() == component.getBody().get(i).getyCoor()) {
                return true;
            }
        }
        return false;
    }
}

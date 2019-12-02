import java.util.ArrayList;
import java.util.List;

/**
 * Player class will store all the information related with player, specifically, the body part.
 * It will keep updating the player's location and draw body.
 */

public class Player {
    private List<BodyPart> body;
    private int[] color;

    public Player(int[] color, boolean isPlayer1) {
        this.color = color;
        this.body = new ArrayList<>();
        if (isPlayer1) {
            this.body.add(new BodyPart(15, 15));
            this.body.add(new BodyPart(14, 15));
        } else {
            this.body.add(new BodyPart(35, 35));
            this.body.add(new BodyPart(34,35));
        }
    }

    public void addHead(int x, int y) {
        this.body.add(0, new BodyPart(x, y));
    }

    public void removeTail() {
        this.body.remove(this.body.size() - 1);
    }

    public BodyPart getHead() {
        return this.body.get(0);
    }

    public List<BodyPart> getBody() {
        return this.body;
    }

    public boolean isHeadLocation(int x, int y) {
        return this.body.get(0).getxCoor() == x && this.body.get(0).getyCoor() == y;
    }

    public void draw() {
        for (BodyPart o: this.body) {
            o.drawWithColor(this.color);
        }
    }
}

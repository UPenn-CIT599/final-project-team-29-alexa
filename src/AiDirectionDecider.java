//QA conducted on 07 Dec by Alex Hui

/**
 * AiDirectionDecider is a class that contains code related to which direction the AI (computer) will go during the game.
 */

public class AiDirectionDecider {
    private int[] curDirection;

    public AiDirectionDecider() {
        this.curDirection = new int[]{-1, 0};
    }

    // We will use a very simple rule based for our AI, the shortest distance
    // to the Apple and will not collide with its component or itself.

    public int[] getDirection(Player player, Player snakeAi, Apple apple) {
        // direction: j, l, k, i
        int[][] possibleDirections = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] bestDirection = this.curDirection;
        int bestDist = Integer.MAX_VALUE;
        for (int[] direction : possibleDirections) {
            // U-turn not allowed
            if (this.curDirection[0] == -direction[0] && this.curDirection[1] == -direction[1]) {
                continue;
            }
            BodyPart target = new BodyPart(snakeAi.getHead().getxCoor() + direction[0],
                    snakeAi.getHead().getyCoor() + direction[1]);
            // If it collides with itself or component, not allowed
            if (!isFeasible(target, player, snakeAi)) {
                continue;
            }
            if (getDistance(target, apple) < bestDist) {
                bestDist = getDistance(target, apple);
                bestDirection = direction;
            }
        }
        this.curDirection = bestDirection;
        return this.curDirection;
    }

    private int getDistance(BodyPart target, Apple apple) {
        return Math.abs(target.getxCoor() - apple.getxCoor())
                + Math.abs(target.getyCoor() - apple.getyCoor());
    }

    private boolean isFeasible(BodyPart target, Player player1, Player snakeAi) {
        // the target body shouldn't be collide with the other player
        for (int i = 0; i < player1.getBody().size(); i++) {
            if (target.getxCoor() == player1.getBody().get(i).getxCoor() &&
                    target.getyCoor() == player1.getBody().get(i).getyCoor()) {
                return false;
            }
        }
        for (int i = 0; i < snakeAi.getBody().size(); i++) {
            if (target.getxCoor() == snakeAi.getBody().get(i).getxCoor() &&
                    target.getyCoor() == snakeAi.getBody().get(i).getyCoor()) {
                return false;
            }
        }
        return true;
    }
}

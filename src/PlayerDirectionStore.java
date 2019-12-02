/**
 * PlayerDirectionStore will store two players' current direction and update if there are key stored
 */
public class PlayerDirectionStore {
    private char player1Direction = 'a';
    private char player2Direction = 'j';

    public int[] getPlayer1Direction()  {
       switch (this.player1Direction) {
           case 'a':
               return new int[]{-1, 0};
           case 'd':
               return new int[]{1, 0};
           case 's':
               return new int[]{0, -1};
           case 'w':
               return new int[]{0, 1};
       }
       return new int[]{-1, 0};
    }

    public int[] getPlayer2Direction()  {
        switch (this.player1Direction) {
            case 'j':
                return new int[]{-1, 0};
            case 'l':
                return new int[]{1, 0};
            case 'k':
                return new int[]{0, -1};
            case 'i':
                return new int[]{0, 1};
        }
        return new int[]{-1, 0};
    }

    public void updateDirection() {
        while (PennDraw.hasNextKeyTyped()) {
            char direction = Character.toLowerCase(PennDraw.nextKeyTyped());
            if (direction == 'a' || direction == 's' || direction == 'w' || direction == 'd') {
                this.player1Direction = direction;
            }
            if (direction == 'j' || direction == 'k' || direction == 'l' || direction == 'i') {
                this.player2Direction = direction;
            }
        }
    }

}

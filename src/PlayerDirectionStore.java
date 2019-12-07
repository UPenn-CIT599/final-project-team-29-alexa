//QA conducted on 07 Dec by Alex Hui

/**
 * This PlayerDirectionStore class stores the two players' current direction in the game
 * and updates the game/drawing when a keystroke is stored
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
        switch (this.player2Direction) {
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
    
    /**
     * Multi player mode controller: WASD, IJKL
     */
    public void updateDirection() {
        while (PennDraw.hasNextKeyTyped()) {
            char direction = Character.toLowerCase(PennDraw.nextKeyTyped());
            switch(direction) {
                // Don't allow U-turn as we already have body there!
                case 'a':
                    if (this.player1Direction != 'd') {
                        this.player1Direction = 'a';
                    }
                    break;
                case 's':
                    if (this.player1Direction != 'w') {
                        this.player1Direction = 's';
                    }
                    break;
                case 'w':
                    if (this.player1Direction != 's') {
                        this.player1Direction = 'w';
                    }
                    break;
                case 'd':
                    if (this.player1Direction != 'a') {
                        this.player1Direction = 'd';
                    }
                    break;
                case 'j':
                    if (this.player2Direction != 'l') {
                        this.player2Direction = 'j';
                    }
                    break;
                case 'k':
                    if (this.player2Direction != 'i') {
                        this.player2Direction = 'k';
                    }
                    break;
                case 'l':
                    if (this.player2Direction != 'j') {
                        this.player2Direction = 'l';
                    }
                    break;
                case 'i':
                    if (this.player2Direction != 'k') {
                        this.player2Direction = 'i';
                    }
            }
        }
    }

}

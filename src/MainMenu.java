/**
 * Class MainMenu will be the entry point UI for Snake Game, it will provide the three options:
 * 1. Single Player
 * 2. Two Players
 * 3. Compete with Computer
 */

public class MainMenu {

    public static void draw() {
        PennDraw.clear();
        PennDraw.text(0.4, 0.8, "Type number 1-3 to choose game modes:");
        PennDraw.text(0.4, 0.7, "1. Single Player");
        PennDraw.text(0.4, 0.6, "2. Two Players");
        PennDraw.text(0.4, 0.5, "3. Compete with AI");
    }
}

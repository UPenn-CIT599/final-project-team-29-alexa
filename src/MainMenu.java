/**
 * This MainMenu class acts as the main entry point UI selection screen for the Snake Game, it contains three options:
 * 1. Single Player
 * 2. Two Players
 * 3. Compete with Computer (Compete with AI)
 */

public class MainMenu {

    public static void draw() {
        PennDraw.setPenColor(0, 0, 0);
        PennDraw.text(25, 40, "Type number 1-3 to choose game modes:");
        PennDraw.text(25, 35, "1. Single Player");
        PennDraw.text(25, 30, "2. Two Players");
        PennDraw.text(25, 25, "3. Compete with AI");
    }
}

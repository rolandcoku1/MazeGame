import javax.swing.*;
import java.awt.*;

public class Player extends JFrame {
    private int playerPositionY;
    private int playerPositionX;
    private int treasureCount;
    private int pointsEarned;

    ImageIcon character;
    private JLabel playerLabel;
    public Player(){
        this.playerPositionX = 0;
        this.playerPositionY = 0;
        this.pointsEarned = 0;
        this.treasureCount = 0;

        character = new ImageIcon("C:\\Users\\rolan\\IdeaProjects\\MazeGame\\src\\character.png");
        character = new ImageIcon(character.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
        playerLabel = new JLabel();
        playerLabel.setBounds(this.getPlayerPositionX(),this.getPlayerPositionY(),40,40);
        playerLabel.setIcon(character);
    }

    public Player(int playerPositionY, int playerPositionX, int treasureCount, int pointsEarned){
        this.playerPositionY = playerPositionY;
        this.playerPositionX = playerPositionX;
        this.treasureCount = treasureCount;
        this.pointsEarned = pointsEarned;
    }

    public void movePlayerRight(){
        playerLabel.setLocation(playerPositionX++,playerPositionY);
    }
    public void movePlayerLeft(){
        playerLabel.setLocation(playerPositionX--,playerPositionY);
    }
    public void movePlayerUp(){
        playerLabel.setLocation(playerPositionX,playerPositionY--);}
    public void movePlayerDown(){
        playerLabel.setLocation(playerPositionX,playerPositionY++);
        System.out.println("moving down"+playerPositionY);
    }


    public int collectTreasure(){
        return 1;
    }

    public boolean isAnExit(){
        return true;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }
    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public JLabel getPlayerLabel() {
        return playerLabel;
    }
}

import javax.swing.*;
import java.awt.*;
public class Player extends JFrame {
    private int playerPositionY;
    private int playerPositionX;
    private int treasureCount;
    private int pointsEarned;
    private MazeGeneration maze;
    private JLabel playerLabel;
    public Player(MazeGeneration maze){
        this.playerPositionX = 0;
        this.playerPositionY = 0;
        this.pointsEarned = 0;
        this.treasureCount = 0;
        this.maze = maze;

        ImageIcon character = new ImageIcon("C:\\Users\\rolan\\IdeaProjects\\MazeGame\\src\\character.png");
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
        if(!this.HasRightWall())
            playerLabel.setLocation(playerPositionX+=40,playerPositionY);
    }
    public void movePlayerLeft(){
        if(!this.hasLeftWall())
            playerLabel.setLocation(playerPositionX-=40,playerPositionY);
    }
    public void movePlayerUp(){
        if (!this.hasTopWall())
            playerLabel.setLocation(playerPositionX,playerPositionY-=40);
    }
    public void movePlayerDown(){
        if (!this.hasBottomWall())
            playerLabel.setLocation(playerPositionX,playerPositionY+=40);
    }

    private boolean hasTopWall(){
            return maze.getCells().get(this.getPlayerCellIndex()).hasTopWall();
    }
    private boolean hasLeftWall(){
        return maze.getCells().get(this.getPlayerCellIndex()).hasLeftWall();
    }
    private boolean hasBottomWall(){
        return maze.getCells().get(this.getPlayerCellIndex()).hasBottomWall();
    }
    private boolean HasRightWall(){
        return maze.getCells().get(this.getPlayerCellIndex()).hasRightWall();
    }

    private int getPlayerCellIndex(){
        return (((int) Math.round((double) playerPositionY/maze.getSpacing()))*maze.getMazeSize() + (int) Math.round((double) playerPositionX/maze.getSpacing()));
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

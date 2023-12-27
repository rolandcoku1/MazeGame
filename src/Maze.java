import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class Maze{
    private List<Cell> cells = new ArrayList<>();
    private int mazeSize;
    private final int GRIDSIZE = 10;
    private final int width;
    private final int height;
    private final int spacing;
    public Maze(int size){
        this.width = 400;
        this.height = 400;
        this.spacing = (int)Math.floor((double) width/GRIDSIZE);
        this.mazeSize = size;

        //Create the cells objects
        for (int i = 0; i < size; i++){
           for (int j = 0; j < size; j++){
               cells.add(new Cell(i,j));
           }
        }
    }

    public void generateMaze(){

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Game");
            JPanel cellPanel = new JPanel(){
                @Override
                protected void paintComponent(Graphics graphics){
                    super.paintComponent(graphics);
                    //Set the color of the grid to black
                    graphics.setColor(Color.black);

                    for (Cell cell : cells) {
                        //Set the beginning point coordinates
                        int x = cell.getX() * spacing;
                        int y = cell.getY() * spacing;

                        // Draw top line
                        if(cell.getWall()[cell.getTOP()]){
                            graphics.drawLine(x, y, x + spacing, y);
                        }
                        // Draw left line
                        if(cell.getWall()[cell.getLEFT()]) {
                            graphics.drawLine(x, y, x, y + spacing);
                        }
                        // Draw right line
                        if(cell.getWall()[cell.getRIGHT()]) {
                            graphics.drawLine(x + spacing, y, x + spacing, y + spacing);
                        }
                        // Draw bottom line
                        if(cell.getWall()[cell.getBOTTOM()]) {
                            graphics.drawLine(x, y + spacing, x + spacing, y + spacing);
                        }
                    }
                }
            };
            frame.getContentPane().add(cellPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(400,200);
            frame.setSize(450, 450);
            frame.setVisible(true);
        });
    }

}
class Cell{
    //Create variables for the indexes of each wall on the boolean array wall;
    private final int TOP = 0;
    private final int RIGHT = 1;
    private final int BOTTOM = 2;
    private final int LEFT = 3;
    private int x;
    private int y;
    private boolean[] wall = {true, true, true, true};

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean[] getWall() {
        return wall;
    }

    public int getTOP() {
        return TOP;
    }

    public int getRIGHT() {
        return RIGHT;
    }

    public int getBOTTOM() {
        return BOTTOM;
    }

    public int getLEFT() {
        return LEFT;
    }
}


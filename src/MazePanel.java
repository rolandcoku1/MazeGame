import javax.swing.*;
import java.awt.*;
public class MazePanel extends JPanel {
    MazeGeneration maze;
    public MazePanel(MazeGeneration maze) {
        this.setBounds(0,0,1000,650);
        this.maze = maze;
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (Cell cell : maze.getCells()) {
            //Set the beginning point coordinates
            int x = cell.getX() * maze.getSpacing();
            int y = cell.getY() * maze.getSpacing();

            //Set the color of the grid to black
            graphics.setColor(Color.black);

            // Draw top line
            if (cell.hasTopWall()) {
                graphics.drawLine(x, y, x + maze.getSpacing(), y);
            }
            // Draw left line
            if (cell.hasLeftWall()) {
                graphics.drawLine(x, y, x, y + maze.getSpacing());
            }
            // Draw right line
            if (cell.hasRightWall()) {
                graphics.drawLine(x + maze.getSpacing(), y, x + maze.getSpacing(), y + maze.getSpacing());
            }
            // Draw bottom line
            if (cell.hasBottomWall()) {
                graphics.drawLine(x, y + maze.getSpacing(), x + maze.getSpacing(), y + maze.getSpacing());
            }
            if(cell.isVisited()){
                graphics.setColor(Color.LIGHT_GRAY);
                graphics.fillRect(x,y,maze.getSpacing(),maze.getSpacing());
            }
            if (cell.containsTreasure()){
                drawTreasure(graphics,x,y);
            }
        }
    }
    private void drawTreasure(Graphics graphics, int x, int y){
        int radius = 5;
        graphics.setColor(Color.RED);
        graphics.fillOval(x+(maze.getSpacing()/2) - radius,y+(maze.getSpacing()/2) - radius,2*radius,2*radius);
    }
}

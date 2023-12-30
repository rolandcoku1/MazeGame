import javax.swing.*;
import java.awt.*;
public class MazePanel extends JPanel {
    MazeGeneration maze = new MazeGeneration(15);
    public MazePanel() {
        this.setBounds(0,0,800,650);
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
            if (cell.getWall()[cell.getTopIndex()]) {
                graphics.drawLine(x, y, x + maze.getSpacing(), y);
            }
            // Draw left line
            if (cell.getWall()[cell.getLeftIndex()]) {
                graphics.drawLine(x, y, x, y + maze.getSpacing());
            }
            // Draw right line
            if (cell.getWall()[cell.getRightIndex()]) {
                graphics.drawLine(x + maze.getSpacing(), y, x + maze.getSpacing(), y + maze.getSpacing());
            }
            // Draw bottom line
            if (cell.getWall()[cell.getBottomIndex()]) {
                graphics.drawLine(x, y + maze.getSpacing(), x + maze.getSpacing(), y + maze.getSpacing());
            }
            if(cell.isVisited()){
                graphics.setColor(Color.LIGHT_GRAY);
                graphics.fillRect(x,y,maze.getSpacing(),maze.getSpacing());
            }
            if (cell.ContainsTreasure()){
                drawTreasure(graphics,x,y);
            }
        }
    }
    private void drawTreasure(Graphics graphics, int x, int y){
        int radius = 5;
        graphics.setColor(Color.RED);
        graphics.fillOval(x+(maze.getSpacing()/2) - radius,y+(maze.getSpacing()/2) - radius,2*radius,2*radius);
    }

    private void drawPlayer(Graphics graphics, int x, int y){
        int radius = 10;
        graphics.setColor(Color.BLACK);
        graphics.fillOval(x+(maze.getSpacing()/2)-radius,y+(maze.getSpacing()/2)-radius,2*radius,2*radius);
    }
}

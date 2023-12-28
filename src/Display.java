import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Display extends JPanel {
    private final List<Cell> cells;
    private final int spacing;
    private static Display instance;

    private static final int DELAY = 100;
    public Display(List<Cell> cells, int spacing) {
        this.cells = cells;
        this.spacing = spacing;
        instance = this;
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (Cell cell : cells) {
            //Set the beginning point coordinates
            int x = cell.getX() * spacing;
            int y = cell.getY() * spacing;
            //Set the color of the grid to black
            graphics.setColor(Color.black);

            // Draw top line
            if (cell.getWall()[cell.getTopIndex()]) {
                graphics.drawLine(x, y, x + spacing, y);
            }
            // Draw left line
            if (cell.getWall()[cell.getLeftIndex()]) {
                graphics.drawLine(x, y, x, y + spacing);
            }
            // Draw right line
            if (cell.getWall()[cell.getRightIndex()]) {
                graphics.drawLine(x + spacing, y, x + spacing, y + spacing);
            }
            // Draw bottom line
            if (cell.getWall()[cell.getBottomIndex()]) {
                graphics.drawLine(x, y + spacing, x + spacing, y + spacing);
            }
            if(cell.isVisited()){
                graphics.setColor(Color.LIGHT_GRAY);
                graphics.fillRect(x,y,spacing,spacing);
            }
            if (cell.ContainsTreasure()){
                drawTreasure(graphics,x,y);
            }
        }

    }

    public static void updateDisplay() {
        if(instance != null){
            instance.repaint();
            try {
                Thread.sleep(DELAY); // Add a delay for better visualization
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    private void drawTreasure(Graphics graphics, int x, int y){
        int radius = 5;
        graphics.setColor(Color.RED);
        graphics.fillOval(x+(spacing/2) - radius,y+(spacing/2) - radius,2*radius,2*radius);
    }

    public void MazeGrid() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Game");
            JPanel cellPanel = new Display(cells, spacing);
            frame.getContentPane().add(cellPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(100, 100);
            frame.setSize(1000, 1000);
            frame.setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Display extends JPanel {
    private final List<Cell> cells;
    private final int spacing;

    public Display(List<Cell> cells, int spacing) {
        this.cells = cells;
        this.spacing = spacing;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //Set the color of the grid to black
        graphics.setColor(Color.black);

        for (Cell cell : cells) {
            //Set the beginning point coordinates
            int x = cell.getX() * spacing;
            int y = cell.getY() * spacing;

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
        }
    }

    public void MazeGrid() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Game");
            JPanel cellPanel = new Display(cells, spacing);
            frame.getContentPane().add(cellPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(400, 200);
            frame.setSize(450, 450);
            frame.setVisible(true);
        });
    }
}
